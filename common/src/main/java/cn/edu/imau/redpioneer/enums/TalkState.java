package cn.edu.imau.redpioneer.enums;

public enum TalkState {

    /**
     * 禁用
     */
    PASS(0,"未通过"),

    /**
     * 支部谈话通过
     */
    PARTY_APPROVED(1,"支部谈话通过"),

    /**
     * 通过
     */
    GROUP_APPROVED(2,"小组谈话通过"),

    /**
     * 待审批
     */
    PENDING(3,"待审批");

    private final Integer value;
    private final String text;

    TalkState(Integer value, String text) {
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
