package cn.edu.imau.redpioneer.entity;

import javax.persistence.*;

@Table(name = "leader_techer")
public class LeaderTecher {
    @Id
    private Integer id;

    @Column(name = "activist_id")
    private String activistId;

    private String name;

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
     * @return activist_id
     */
    public String getActivistId() {
        return activistId;
    }

    /**
     * @param activistId
     */
    public void setActivistId(String activistId) {
        this.activistId = activistId;
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
}