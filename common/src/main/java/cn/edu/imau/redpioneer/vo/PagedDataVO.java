package cn.edu.imau.redpioneer.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author: zyl
 * @date 2022/3/15 20:42
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagedDataVO{
    private int page;   //页码
    private int pageSize;  //长度
    private int totalPage;   //总页数
    private int totalItem;   //总条数
    private Object data;    //返回对象
}
