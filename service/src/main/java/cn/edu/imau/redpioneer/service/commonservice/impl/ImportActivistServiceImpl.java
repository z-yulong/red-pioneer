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
        //1.  ??????HSSFWorkbook ?????????????????? ???Excel?????????
        //2.  ???HSSFWorkbook????????????????????????sheet??????
        //3.  ???sheet????????????????????????????????????Cell??????
        //4.  ???Cell??????????????????
        List<Activist> activists = new ArrayList<>();
        Workbook workbook = null;
        String fileName = myFile.getOriginalFilename();//  ???????????????

        if (fileName.endsWith(XLS))
        {
            try {
                workbook = new HSSFWorkbook(myFile.getInputStream());//  2003??????

            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(fileName.endsWith(XLSX)){
            try {
                workbook = new XSSFWorkbook(myFile.getInputStream());//  2007??????
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            throw new LianjiaException(ResStatus.FILE_IS_NOT_EXCEL.getValue()
                    ,ResStatus.FILE_IS_NOT_EXCEL.getText()); // ????????????Excel??????
        }
        Sheet sheet = workbook.getSheet("sheet1");
        int rows = sheet.getLastRowNum();

        if(rows == 0){
            throw new LianjiaException(ResStatus.DATA_IS_NULL.getValue()
                    ,ResStatus.DATA_IS_NULL.getText());// ???????????? ???????????????
        }

        for(int i = 1;i<= rows+1;i++){
            Row row = sheet.getRow(i);
            Activist activist = new Activist();
            if(row !=null){

                //??????
                String account = getCellValue(row.getCell(0));
                activist.setAccount(account);
                //??????
                String name = getCellValue(row.getCell(1));

                activist.setName(name);
                //??????
                String branchName = getCellValue(row.getCell(2));
                Example example = new Example(PartyBranch.class);
                Example.Criteria criteria = example.createCriteria();
                criteria.andEqualTo("branchName",branchName);

                PartyBranch branch = partyBranchMapper.selectOneByExample(example);
                if(branch==null){
                    //return new ResultVO(ResStatus.PARAMETER_ERROR.getValue(),"??????"+branchName+"????????????",null);
                    continue;
                }
                activist.setBranchId(branch.getId());
                //?????????
                String groupName = getCellValue(row.getCell(3));

                Example example1 = new Example(PartyGroup.class);
                Example.Criteria criteria1 = example1.createCriteria();
                criteria1.andEqualTo("groupName",groupName);

                PartyGroup group = partyGroupMapper.selectOneByExample(example1);
                if(group==null){
                    //return new ResultVO(ResStatus.PARAMETER_ERROR.getValue(),"??????"+branchName+"????????????",null);
                    continue;
                }
                if(group.getBranch().equals(branch.getId())){
                    activist.setPartyGroup(group.getActivistId());
                }
                activists.add(activist);
            }
        }
        activistMapper.batchInsert(activists);  //  ????????????

        return new ResultVO(ResStatus.OK.getValue(),ResStatus.OK.getText(),null);
    }

    public String getCellValue(Cell cell) {
        String value = "";
        if (cell != null) {
            switch(cell.getCellType()){
                case HSSFCell.CELL_TYPE_NUMERIC:// ??????
                    value = cell.getNumericCellValue()+ " ";
                    if(HSSFDateUtil.isCellDateFormatted(cell)){
                        Date date = cell.getDateCellValue();
                        if(date != null){
                            value = new SimpleDateFormat("yyyy-MM-dd").format(date); //  ???????????????
                        }else{
                            value = "";
                        }
                    }else {
                        //  ??????cell?????? ?????????????????????double????????? ?????????????????????????????? ???????????????
                        value = new DecimalFormat("0").format(cell.getNumericCellValue());
                    }
                    break;
                case HSSFCell.CELL_TYPE_STRING: //  ?????????
                    value = cell.getStringCellValue();
                    break;
                case HSSFCell.CELL_TYPE_BOOLEAN:   //  Boolean??????
                    value = cell.getBooleanCellValue()+"";
                    break;
                case HSSFCell.CELL_TYPE_BLANK:   // ??????
                    value = "";
                    break;
                case HSSFCell.CELL_TYPE_ERROR: // ????????????
                    value ="????????????";
                    break;
                default:
                    value = "????????????";
                    break;
            }

        }
        return value.trim();
    }

}
