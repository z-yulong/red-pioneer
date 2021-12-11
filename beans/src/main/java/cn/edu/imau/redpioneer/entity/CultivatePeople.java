package cn.edu.imau.redpioneer.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "cultivate_people")
public class CultivatePeople {
    @Id
    private Integer id;

    /**
     * 培养人姓名
     */
    private String name;

    /**
     * 入党时间
     */
    @Column(name = "time_of_joining_the_party")
    private Date timeOfJoiningTheParty;

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
     * 获取培养人姓名
     *
     * @return name - 培养人姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置培养人姓名
     *
     * @param name 培养人姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取入党时间
     *
     * @return time_of_joining_the_party - 入党时间
     */
    public Date getTimeOfJoiningTheParty() {
        return timeOfJoiningTheParty;
    }

    /**
     * 设置入党时间
     *
     * @param timeOfJoiningTheParty 入党时间
     */
    public void setTimeOfJoiningTheParty(Date timeOfJoiningTheParty) {
        this.timeOfJoiningTheParty = timeOfJoiningTheParty;
    }
}