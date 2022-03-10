package cn.edu.imau.redpioneer.service.commonservice;

import cn.edu.imau.redpioneer.vo.ResultVO;

import java.io.UnsupportedEncodingException;

public interface LoginService {

    ResultVO login(String name, String password) throws UnsupportedEncodingException;
}
