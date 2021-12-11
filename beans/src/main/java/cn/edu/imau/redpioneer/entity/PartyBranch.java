package cn.edu.imau.redpioneer.entity;

import javax.persistence.*;

@Table(name = "party_branch")
public class PartyBranch {
    @Id
    private Integer id;

    /**
     * 支部名称
     */
    private String name;

    /**
     * 负责人id
     */
    private Integer secretary;

    private String tel;

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
     * 获取支部名称
     *
     * @return name - 支部名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置支部名称
     *
     * @param name 支部名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取负责人id
     *
     * @return secretary - 负责人id
     */
    public Integer getSecretary() {
        return secretary;
    }

    /**
     * 设置负责人id
     *
     * @param secretary 负责人id
     */
    public void setSecretary(Integer secretary) {
        this.secretary = secretary;
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
}