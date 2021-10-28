package cn.edu.imau.redpioneer.service;

import cn.edu.imau.redpioneer.vo.ResultVO;

/**
 * @author: zyl
 * @date 2021/10/28 12:12
 */
public interface UserService {

    public ResultVO login(String name, String password);


}
