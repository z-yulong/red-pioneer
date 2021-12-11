package cn.edu.imau.redpioneer.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "history_activist")
public class HistoryActivist {
    /**
     * 历史表主键
     */
    @Id
    private Integer id;

    private String account;

    private String password;

    private String name;

    private String sex;

    private String nation;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "native_place")
    private String nativePlace;

    @Column(name = "admission_time")
    private Date admissionTime;

    private String address;

    @Column(name = "id_card")
    private String idCard;

    private String tel;

    @Column(name = "application_time")
    private Date applicationTime;

    private String photo;

    @Column(name = "leader_stu")
    private Integer leaderStu;

    @Column(name = "leader_techer")
    private Integer leaderTecher;

    private String diploma;

    @Column(name = "upactivist_time")
    private Date upactivistTime;

    private String roles;

    private String permission;

    private String classes;

    private String state;

    /**
     * 获取历史表主键
     *
     * @return id - 历史表主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置历史表主键
     *
     * @param id 历史表主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return account
     */
    public String getAccount() {
        return account;
    }

    /**
     * @param account
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return nation
     */
    public String getNation() {
        return nation;
    }

    /**
     * @param nation
     */
    public void setNation(String nation) {
        this.nation = nation;
    }

    /**
     * @return date_of_birth
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @return native_place
     */
    public String getNativePlace() {
        return nativePlace;
    }

    /**
     * @param nativePlace
     */
    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    /**
     * @return admission_time
     */
    public Date getAdmissionTime() {
        return admissionTime;
    }

    /**
     * @param admissionTime
     */
    public void setAdmissionTime(Date admissionTime) {
        this.admissionTime = admissionTime;
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return id_card
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * @param idCard
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    /**
     * @return tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * @return application_time
     */
    public Date getApplicationTime() {
        return applicationTime;
    }

    /**
     * @param applicationTime
     */
    public void setApplicationTime(Date applicationTime) {
        this.applicationTime = applicationTime;
    }

    /**
     * @return photo
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * @param photo
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * @return leader_stu
     */
    public Integer getLeaderStu() {
        return leaderStu;
    }

    /**
     * @param leaderStu
     */
    public void setLeaderStu(Integer leaderStu) {
        this.leaderStu = leaderStu;
    }

    /**
     * @return leader_techer
     */
    public Integer getLeaderTecher() {
        return leaderTecher;
    }

    /**
     * @param leaderTecher
     */
    public void setLeaderTecher(Integer leaderTecher) {
        this.leaderTecher = leaderTecher;
    }

    /**
     * @return diploma
     */
    public String getDiploma() {
        return diploma;
    }

    /**
     * @param diploma
     */
    public void setDiploma(String diploma) {
        this.diploma = diploma;
    }

    /**
     * @return upactivist_time
     */
    public Date getUpactivistTime() {
        return upactivistTime;
    }

    /**
     * @param upactivistTime
     */
    public void setUpactivistTime(Date upactivistTime) {
        this.upactivistTime = upactivistTime;
    }

    /**
     * @return roles
     */
    public String getRoles() {
        return roles;
    }

    /**
     * @param roles
     */
    public void setRoles(String roles) {
        this.roles = roles;
    }

    /**
     * @return permission
     */
    public String getPermission() {
        return permission;
    }

    /**
     * @param permission
     */
    public void setPermission(String permission) {
        this.permission = permission;
    }

    /**
     * @return classes
     */
    public String getClasses() {
        return classes;
    }

    /**
     * @param classes
     */
    public void setClasses(String classes) {
        this.classes = classes;
    }

    /**
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }
}