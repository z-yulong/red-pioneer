package cn.edu.imau.redpioneer.entity;

import cn.edu.imau.redpioneer.utils.ExcelVOAttribute;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Activist对象",description = "用户信息")
public class Activist {
    /**
     * id
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
     * 积极分子结业证
     */
    private String diploma;

    /**
     * 成为积极分子时间
     */
    @Column(name = "upactivist_time")
    private Date upactivistTime;

    /**
     * 角色
     */
    private String roles;

    /**
     * 权限
     */
    private String permission;

    /**
     * 班级
     */
    private String classes;

    /**
     * 状态
     */
    private String state;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取账号
     *
     * @return account - 账号
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置账号
     *
     * @param account 账号
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取民族
     *
     * @return nation - 民族
     */
    public String getNation() {
        return nation;
    }

    /**
     * 设置民族
     *
     * @param nation 民族
     */
    public void setNation(String nation) {
        this.nation = nation;
    }

    /**
     * 获取出生日期
     *
     * @return date_of_birth - 出生日期
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * 设置出生日期
     *
     * @param dateOfBirth 出生日期
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * 获取籍贯
     *
     * @return native_place - 籍贯
     */
    public String getNativePlace() {
        return nativePlace;
    }

    /**
     * 设置籍贯
     *
     * @param nativePlace 籍贯
     */
    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    /**
     * 获取入学时间
     *
     * @return admission_time - 入学时间
     */
    public Date getAdmissionTime() {
        return admissionTime;
    }

    /**
     * 设置入学时间
     *
     * @param admissionTime 入学时间
     */
    public void setAdmissionTime(Date admissionTime) {
        this.admissionTime = admissionTime;
    }

    /**
     * 获取地址
     *
     * @return address - 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址
     *
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取身份证号码
     *
     * @return id_card - 身份证号码
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * 设置身份证号码
     *
     * @param idCard 身份证号码
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    /**
     * 获取电话
     *
     * @return tel - 电话
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置电话
     *
     * @param tel 电话
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获取申请时间
     *
     * @return application_time - 申请时间
     */
    public Date getApplicationTime() {
        return applicationTime;
    }

    /**
     * 设置申请时间
     *
     * @param applicationTime 申请时间
     */
    public void setApplicationTime(Date applicationTime) {
        this.applicationTime = applicationTime;
    }

    /**
     * 获取照片
     *
     * @return photo - 照片
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * 设置照片
     *
     * @param photo 照片
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * 获取党小组组长
     *
     * @return leader_stu - 党小组组长
     */
    public Integer getLeaderStu() {
        return leaderStu;
    }

    /**
     * 设置党小组组长
     *
     * @param leaderStu 党小组组长
     */
    public void setLeaderStu(Integer leaderStu) {
        this.leaderStu = leaderStu;
    }

    /**
     * 获取培养人_老师
     *
     * @return leader_techer - 培养人_老师
     */
    public Integer getLeaderTecher() {
        return leaderTecher;
    }

    /**
     * 设置培养人_老师
     *
     * @param leaderTecher 培养人_老师
     */
    public void setLeaderTecher(Integer leaderTecher) {
        this.leaderTecher = leaderTecher;
    }

    /**
     * 获取积极分子结业证
     *
     * @return diploma - 积极分子结业证
     */
    public String getDiploma() {
        return diploma;
    }

    /**
     * 设置积极分子结业证
     *
     * @param diploma 积极分子结业证
     */
    public void setDiploma(String diploma) {
        this.diploma = diploma;
    }

    /**
     * 获取成为积极分子时间
     *
     * @return upactivist_time - 成为积极分子时间
     */
    public Date getUpactivistTime() {
        return upactivistTime;
    }

    /**
     * 设置成为积极分子时间
     *
     * @param upactivistTime 成为积极分子时间
     */
    public void setUpactivistTime(Date upactivistTime) {
        this.upactivistTime = upactivistTime;
    }

    /**
     * 获取角色
     *
     * @return roles - 角色
     */
    public String getRoles() {
        return roles;
    }

    /**
     * 设置角色
     *
     * @param roles 角色
     */
    public void setRoles(String roles) {
        this.roles = roles;
    }

    /**
     * 获取权限
     *
     * @return permission - 权限
     */
    public String getPermission() {
        return permission;
    }

    /**
     * 设置权限
     *
     * @param permission 权限
     */
    public void setPermission(String permission) {
        this.permission = permission;
    }

    /**
     * 获取班级
     *
     * @return classes - 班级
     */
    public String getClasses() {
        return classes;
    }

    /**
     * 设置班级
     *
     * @param classes 班级
     */
    public void setClasses(String classes) {
        this.classes = classes;
    }

    /**
     * 获取状态
     *
     * @return state - 状态
     */
    public String getState() {
        return state;
    }

    /**
     * 设置状态
     *
     * @param state 状态
     */
    public void setState(String state) {
        this.state = state;
    }
}