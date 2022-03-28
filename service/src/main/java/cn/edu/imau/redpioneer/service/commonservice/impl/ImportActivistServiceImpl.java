package cn.edu.imau.redpioneer.service.commonservice.impl;

import cn.edu.imau.redpioneer.dao.ActivistMapper;
import cn.edu.imau.redpioneer.dao.PartyBranchMapper;
import cn.edu.imau.redpioneer.dao.PartyGroupMapper;
import cn.edu.imau.redpioneer.entity.Activist;
import cn.edu.imau.redpioneer.entity.PartyBranch;
import cn.edu.imau.redpioneer.entity.PartyGroup;
import cn.edu.imau.redpioneer.enums.ResStatus;
import cn.edu.imau.redpioneer.vo.ResultVO;
import cn.edu.imau.redpioneer.exception.LianjiaException;
import cn.edu.imau.redpioneer.service.commonservice.ImportActivistService;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Example;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: zyl
 * @date 2021/11/24 16:20
 */
@Service
public class ImportActivistServiceImpl implements ImportActivistService {

    private ActivistMapper activistMapper;
    private PartyBranchMapper partyBranchMapper;
    private PartyGroupMapper partyGroupMapper;
    @Autowired
    public ImportActivistServiceImpl(ActivistMapper activistMapper,PartyBranchMapper partyBranchMapper,PartyGroupMapper partyGroupMapper){
        this.activistMapper=activistMapper;
        this.partyBranchMapper=partyBranchMapper;
        this.partyGroupMapper=partyGroupMapper;
    }
    private static final String XLS = "xls";
    private static final String XLSX = "xlsx";


    @Override
    public ResultVO importExcel(MultipartFile myFile) {
        //1.  使用HSSFWorkbook 打开或者创建 “Excel对象”
        //2.  用HSSFWorkbook返回对象或者创建sheet对象
        //3.  用sheet返回行对象，用行对象得到Cell对象
        //4.  对Cell对象进行读写
        List<Activist> activists = new ArrayList<>();
        Workbook workbook = null;
        String fileName = myFile.getOriginalFilename();//  获取文件名

        if (fileName.endsWith(XLS))
        {
            try {
                workbook = new HSSFWorkbook(myFile.getInputStream());//  2003版本

            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(fileName.endsWith(XLSX)){
            try {
                workbook = new XSSFWorkbook(myFile.getInputStream());//  2007版本
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            throw new LianjiaException(ResStatus.FILE_IS_NOT_EXCEL.getValue()
                    ,ResStatus.FILE_IS_NOT_EXCEL.getText()); // 文件不是Excel文件
        }
        Sheet sheet = workbook.getSheet("sheet1");
        int rows = sheet.getLastRowNum();

        if(rows == 0){
            throw new LianjiaException(ResStatus.DATA_IS_NULL.getValue()
                    ,ResStatus.DATA_IS_NULL.getText());// 数据为空 请填写数据
        }

        for(int i = 1;i<= rows+1;i++){
            Row row = sheet.getRow(i);
            Activist activist = new Activist();
            if(row !=null){

                //账号
                String account = getCellValue(row.getCell(0));
                activist.setAccount(account);
                //姓名
                String name = getCellValue(row.getCell(1));

                activist.setName(name);
                //支部
                String branchName = getCellValue(row.getCell(2));
                Example example = new Example(PartyBranch.class);
                Example.Criteria criteria = example.createCriteria();
                criteria.andEqualTo("branchName",branchName);

                PartyBranch branch = partyBranchMapper.selectOneByExample(example);
                if(branch==null){
                    //return new ResultVO(ResStatus.PARAMETER_ERROR.getValue(),"支部"+branchName+"不存在！",null);
                    continue;
                }
                activist.setBranchId(branch.getId());
                //党小组
                String groupName = getCellValue(row.getCell(3));

                Example example1 = new Example(PartyGroup.class);
                Example.Criteria criteria1 = example1.createCriteria();
                criteria1.andEqualTo("groupName",groupName);

                PartyGroup group = partyGroupMapper.selectOneByExample(example1);
                if(group==null){
                    //return new ResultVO(ResStatus.PARAMETER_ERROR.getValue(),"支部"+branchName+"不存在！",null);
                    continue;
                }
                if(group.getBranch().equals(branch.getId())){
                    activist.setPartyGroup(group.getActivistId());
                }
                activists.add(activist);
            }
        }
        activistMapper.batchInsert(activists);  //  批量插入

        return new ResultVO(ResStatus.OK.getValue(),ResStatus.OK.getText(),null);
    }

    public String getCellValue(Cell cell) {
        String value = "";
        if (cell != null) {
            switch(cell.getCellType()){
                case HSSFCell.CELL_TYPE_NUMERIC:// 数字
                    value = cell.getNumericCellValue()+ " ";
                    if(HSSFDateUtil.isCellDateFormatted(cell)){
                        Date date = cell.getDateCellValue();
                        if(date != null){
                            value = new SimpleDateFormat("yyyy-MM-dd").format(date); //  日期格式化
                        }else{
                            value = "";
                        }
                    }else {
                        //  解析cell时候 数字类型默认是double类型的 但是想要获取整数类型 需要格式化
                        value = new DecimalFormat("0").format(cell.getNumericCellValue());
                    }
                    break;
                case HSSFCell.CELL_TYPE_STRING: //  字符串
                    value = cell.getStringCellValue();
                    break;
                case HSSFCell.CELL_TYPE_BOOLEAN:   //  Boolean类型
                    value = cell.getBooleanCellValue()+"";
                    break;
                case HSSFCell.CELL_TYPE_BLANK:   // 空值
                    value = "";
                    break;
                case HSSFCell.CELL_TYPE_ERROR: // 错误类型
                    value ="非法字符";
                    break;
                default:
                    value = "未知类型";
                    break;
            }

        }
        return value.trim();
    }

}
