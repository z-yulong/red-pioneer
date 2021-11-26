package cn.edu.imau.redpioneer.enums;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: zyl
 * @date 2021/10/28 17:11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "响应的VO对象",description = "封装接口返回给前端的数据")
public class ResultVO {

    //响应给前端的状态码
    @ApiModelProperty(value = "响应状态码",dataType = "int")
    private int code;

    //响应给前端的提示信息
    @ApiModelProperty(value = "响应提示信息",dataType = "string")
    private String msg;

    //响应给前端的数据
    @ApiModelProperty(value = "响应数据",dataType = "Object")
    private Object data;
}
