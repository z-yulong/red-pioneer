package cn.edu.imau.redpioneer.enums;

public enum ResStatus {
    /**
     * 10000请求成功
     */
    OK(10000, "请求成功"),
    /**
     * 10001请求失败
     */
    NO(10001,"请求失败"),
    /**
     * 20002用户不存在
     */
    USER_DOSE_NOT_EXITS(20002,"用户不存在"),
    /**
     * 20003密码错误
     */
    PASSWORD_ERROR(20003,"密码错误"),
    /**
     * 请先登录
     */
    EXISTED(20004,"该账号已存在"),
    /**
     * 登录过期
     */
    LOGIN_EXPIRATION(20005,"登录过期,请重新登录"),
    /**
     * token不合法
     */
    PARAMETER_ERROR(10010,"参数错误"),

    /**
     * 未经授权,无法访问!
     */
    USER_UNAUTHORIZED(20020,"未经授权,无法访问!"),

    /**
     * 文件不是Excel
     */
    FILE_IS_NOT_EXCEL(1004,"文件不是Excel"),

    /**
     * 数据为空，请填写数据
     */
    DATA_IS_NULL(1005,"数据为空，请填写数据"),

    /**
     * 删除成功
     */
    DELETE_OK(10000,"删除成功！"),
    /**
     * 更新成功
     */
    UPDATE_OK(10000,"更新成功"),

    EMPTY(1006,"当前没有待审批用户！");

    private final Integer value;
    private final String text;

    ResStatus(Integer value, String text) {
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
