package cn.edu.imau.redpioneer.entity;

import cn.edu.imau.redpioneer.utils.ExcelVOAttribute;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Activist对象",description = "用户信息")
public class Activist implements Serializable {

    @Id
    private Integer id;
    /**
     * 账号
     */
    @ExcelVOAttribute(name = "学号",column = "A")
    private String account;
    /**
     * 密码
     */
    private String password;
    /**
     * 姓名
     */
    @ExcelVOAttribute(name = "姓名",column = "B")
    private String name;
    /**
     * 性别
     */
    private String sex;
    /**
     * 民族
     */
    private String nation;
    /**
     * 出生日期
     */
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    /**
     * 籍贯
     */
    @Column(name = "native_place")
    private String nativePlace;
    /**
     * 学历
     */
    private String education;
    /**
     * 入学时间
     */
    @Column(name = "admission_time")
    private Date admissionTime;
    /**
     * 地址
     */
    private String address;
    /**
     * 身份证号码
     */
    @Column(name = "id_card")
    private String idCard;
    /**
     * 电话
     */
    private String tel;
    /**
     * 申请时间
     */
    @Column(name = "application_time")
    private Date applicationTime;
    /**
     * 是否成年
     */
    @Column(name = "is_adult")
    private String isAdult;
    /**
     * 照片
     */
    private String photo;
    /**
     * 党小组组长
     */
    @Column(name = "leader_stu")
    private Integer leaderStu;
    /**
     * 培养人_老师
     */
    @Column(name = "leader_techer")
    private Integer leaderTecher;
    /**
     * 权限
     */
    private Integer juri;

    /**
     * 积极分子结业证
     */
    private String diploma;

    /**
     * 成为积极分子时间
     */
//    @ExcelVOAttribute(name = "成为积极分子时间",column = "C")
    private Date upactivistTime;




}