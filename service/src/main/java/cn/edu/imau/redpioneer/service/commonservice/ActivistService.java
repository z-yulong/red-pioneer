package cn.edu.imau.redpioneer.service.commonservice;

import cn.edu.imau.redpioneer.entity.Activist;
import cn.edu.imau.redpioneer.vo.ResultVO;
import org.apache.ibatis.session.RowBounds;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * @author: zyl
 * @date 2021/10/28 12:12
 */
public interface ActivistService {

    ResultVO deleteById(Integer id);

    ResultVO getUserById(Integer id);

    ResultVO getUserByAccount(String account);

    ResultVO updateActivistByid(Activist activist, HttpServletRequest request);

    ResultVO getUserByName(String name);

    Activist getUser(String account);

    ResultVO getUserByRole();

    ResultVO register(String account,String name,String roles);

    ResultVO selectActivistPage(RowBounds rowBounds, HttpServletRequest request);

}
