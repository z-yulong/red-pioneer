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
    LOGIN_FAIL_NOT(20004,"请先登录"),
    /**
     * 登录过期
     */
    LOGIN_EXPIRATION(20005,"登录过期,请重新登录"),
    /**
     * token不合法
     */
    TOKEN_ERROR(10010,"token不合法"),
    /**
     * 400请求参数出错
     */
    BAD_REQUEST(400, "请求参数出错"),
    /**
     * 403没有权限
     */
    FORBIDDEN(403, "没有权限"),
    /**
     * 410已被删除
     */
    GONE(410, "已被删除"),
    /**
     * 423已被锁定
     */
    LOCKED(423, "已被锁定"),
    /**
     * 500服务器出错
     */
    INTERNAL_SERVER_ERROR(500, "服务器出错"),
    /**
     * 异常
     */
    EXCPTION_ERROR(4001, "异常"),


    PARAMETER_ERROR(1003,"系统参数错误"),
    FILE_IS_NOT_EXCEL(1004,"文件不是Excel"),
    DATA_IS_NULL(1005,"数据为空，请填写数据"),
    USERNAME_IS_ERROR(1006,"用户名错误"),
    PASSWORD_IS_ERROR(1007,"密码错误");

    private final Integer value;
    private final String text;

    private ResStatus(Integer value, String text) {
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
