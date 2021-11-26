package cn.edu.imau.redpioneer.exception;


import cn.edu.imau.redpioneer.enums.ResStatus;

/**
 * @author: zyl
 * @date 2021/11/24 16:27
 */
public class LianjiaException extends RuntimeException {

    private Integer value;

    public LianjiaException(ResStatus resStatus){
        super(resStatus.getText());
        this.value = resStatus.getValue();
    }

    public LianjiaException(Integer value, java.lang.String msg){

        super(msg);
        this.value = this.value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
