package cn.edu.imau.redpioneer.entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "leader_stu")
public class LeaderStu {
    @Id
    private Integer id;

    private String account;

    private String password;

    private String name;

    private Integer juri;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
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
     * @return juri
     */
    public Integer getJuri() {
        return juri;
    }

    /**
     * @param juri
     */
    public void setJuri(Integer juri) {
        this.juri = juri;
    }
}