package cn.edu.imau.redpioneer.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageHelper{

    //起始页
    private int offset;

    //页面大小
    private int limit;

}
