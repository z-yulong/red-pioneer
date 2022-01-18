package cn.edu.imau.redpioneer.entity;

import cn.edu.imau.redpioneer.utils.ExcelVOAttribute;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Activist对象",description = "用户信息")
public class Activist {
    /**
     * 用户表主键
     */
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
     * 出生年月
     */
    private Date birthday;

    /**
     * 民族
     */
    private String nation;

    /**
     * 籍贯
     */
    @Column(name = "native_place")
    private String nativePlace;

    /**
     * 身份证
     */
    @Column(name = "id_card")
    private String idCard;

    /**
     * 地址
     */
    private String address;

    /**
     * 邮箱
     */
    private String Email;

    /**
     * 电话
     */
    private String tel;

    /**
     * 照片
     */
    private String photo;

    /**
     * 班级
     */
    private String classes;
    /**
     * 培养人
     */
    private String train;

    /**
     * 角色
     */
    private String roles;

    /**
     * 状态
     */
    @Column(name = "state_code")
    private Integer stateCode;

}