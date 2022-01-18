package cn.edu.imau.redpioneer.enums;

/**
 * 审批状态枚举类
 */
public enum State {

    /**
     * 禁用
     */
    PASS(0,"未通过"),

    /**
     * 待审批
     */
    PENDING(1,"待审批！"),

    /**
     * 通过
     */
    APPROVED(2,"通过");


    private final Integer value;
    private final String text;

    State(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    /**
     * 获取value
     */
    public Integer getValue() {
        return this.value;
    }
    /**
     * 获取Text
     */
    public String getText() {
        return this.text;
    }

}


