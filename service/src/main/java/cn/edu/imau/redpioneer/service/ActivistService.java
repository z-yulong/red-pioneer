package cn.edu.imau.redpioneer.service;

import cn.edu.imau.redpioneer.entity.Activist;
import cn.edu.imau.redpioneer.enums.ResultVO;

import java.io.UnsupportedEncodingException;

/**
 * @author: zyl
 * @date 2021/10/28 12:12
 */
public interface ActivistService {

    ResultVO login(String name, String password) throws UnsupportedEncodingException;
    ResultVO deleteById(Integer id);
    ResultVO getUserById(Integer id);

    ResultVO getUserByAccount(String account);

    ResultVO updateActivistByid(Activist activist);

    ResultVO getUserByName(String name);

    Activist getUser(String account);

    ResultVO getUserByRole();

    ResultVO register(String account,String name,String roles);
}
