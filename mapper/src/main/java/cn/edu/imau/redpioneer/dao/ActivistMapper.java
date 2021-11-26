package cn.edu.imau.redpioneer.dao;

import cn.edu.imau.redpioneer.entity.Activist;
import cn.edu.imau.redpioneer.general.GeneralDAO;

import java.util.List;

public interface ActivistMapper extends GeneralDAO<Activist> {

//    int updateInfoByPrimaryKey(String name, //姓名
//                               String sex,  //性别
//                               String nation, //名族
//                               Date dateOfBirth, //出生日期
//                               String nativePlace, //籍贯
//                               String education,  //学历
//                               Date admissionTime, //入学时间
//                               String address, //地址
//                               String idCard, //身份证号
//                               String tel, //电话
//                               Date applicationTime, //申请时间
//                               String isAdult//是否成年
//                                );
    int updateInfoByPrimaryKey(Activist activist);

    void batchInsert(List<Activist> activists);


}