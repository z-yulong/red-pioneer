package cn.edu.imau.redpioneer.service.impl;

import cn.edu.imau.redpioneer.dao.ActivistMapper;
import cn.edu.imau.redpioneer.entity.Activist;

import cn.edu.imau.redpioneer.enums.ResStatus;
import cn.edu.imau.redpioneer.enums.ResultVO;
import cn.edu.imau.redpioneer.exception.LianjiaException;
import cn.edu.imau.redpioneer.service.ImportActivistService;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.boot.devtools.restart.RestartInitializer;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
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
    private final static String XLS = "xls";
    public static final String XLSX = "xlsx";

    private final static Logger logger = LoggerFactory.getLogger(ImportActivistService.class);

    @Resource
    ActivistMapper activistMapper;

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

                //  账号
                String account = getCellValue(row.getCell(0));
                activist.setAccount(account);
                //  姓名
                String name = getCellValue(row.getCell(1));
                activist.setName(name);
//                // 成为积极分子时间
//                String date =getCellValue(row.getCell(2));
//
//                SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
//                try {
//                    activist.setUpactivistTime(formatter.parse(date));
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
                activists.add(activist);
            }
        }
        activistMapper.batchInsert(activists);  //  批量插入

        return new ResultVO(ResStatus.OK.getValue()
                ,ResStatus.OK.getText(),null);
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
