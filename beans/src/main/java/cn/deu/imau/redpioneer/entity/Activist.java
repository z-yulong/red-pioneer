package cn.deu.imau.redpioneer.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class Activist {
    /**
     * id
     */
    @Id
    private Integer id;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 姓名
     */
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
     * 获取学历
     *
     * @return education - 学历
     */
    public String getEducation() {
        return education;
    }

    /**
     * 设置学历
     *
     * @param education 学历
     */
    public void setEducation(String education) {
        this.education = education;
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
     * 获取是否成年
     *
     * @return is_adult - 是否成年
     */
    public String getIsAdult() {
        return isAdult;
    }

    /**
     * 设置是否成年
     *
     * @param isAdult 是否成年
     */
    public void setIsAdult(String isAdult) {
        this.isAdult = isAdult;
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
     * 获取权限
     *
     * @return juri - 权限
     */
    public Integer getJuri() {
        return juri;
    }

    /**
     * 设置权限
     *
     * @param juri 权限
     */
    public void setJuri(Integer juri) {
        this.juri = juri;
    }
}