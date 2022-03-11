package cn.edu.imau.redpioneer.service.commonservice.impl;

import cn.edu.imau.redpioneer.dao.ActivistMapper;
import cn.edu.imau.redpioneer.entity.Activist;
import cn.edu.imau.redpioneer.enums.ResStatus;
import cn.edu.imau.redpioneer.service.commonservice.LoginService;
import cn.edu.imau.redpioneer.utils.JWTUtil;
import cn.edu.imau.redpioneer.vo.ResultVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import java.io.UnsupportedEncodingException;

/**
 * @author: zyl
 * @date 2022/3/10 8:53
 */
@Service
public class LoginServiceImpl implements LoginService {

    ActivistMapper activistMapper;

    @Autowired
    public LoginServiceImpl(ActivistMapper activistMapper) {
        this.activistMapper = activistMapper;
    }

    /**
     * 登录
     * @param account 账号
     * @param password 密码
     * @return activist
     * @throws UnsupportedEncodingException c
     */
    @Override
    public ResultVO login(String account, String password,String validateCode) throws UnsupportedEncodingException {
        Subject subject = SecurityUtils.getSubject();
        //判断验证码
        Session session =subject.getSession();
        String code = (String) session.getAttribute("verifyCode");
        //.toLowerCase()
        if (!((validateCode.toLowerCase()).equals(code.toLowerCase()))){
            return new ResultVO(1010,"验证码错误",null);
        }

        //创建一个Example封装类 类别Activist查询条件
        Example example = new Example(Activist.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("account",account);
        Activist activist = activistMapper.selectOneByExample(example);

        if(activist == null){
            //用户名不存在
            session.removeAttribute("verifyCode");//销毁验证码
            return new ResultVO(ResStatus.USER_DOSE_NOT_EXITS.getValue(),ResStatus.USER_DOSE_NOT_EXITS.getText(),null);
        }else{
            if(activist.getPassword().equals(password)){
                //登录成功
                //生成token令牌
                String token= JWTUtil.createToken(activist);
                session.removeAttribute("verifyCode");
                return new ResultVO(ResStatus.OK.getValue(),token,activist);
            }else{
                //密码错误
                session.removeAttribute("verifyCode");
                return new ResultVO(ResStatus.PASSWORD_ERROR.getValue(), ResStatus.PASSWORD_ERROR.getText(),null);
            }
        }


    }
}
