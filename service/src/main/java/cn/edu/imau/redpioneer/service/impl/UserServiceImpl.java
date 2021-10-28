package cn.edu.imau.redpioneer.service.impl;

import cn.deu.imau.redpioneer.entity.Activist;
import cn.deu.imau.redpioneer.entity.SupperAdmin;

import cn.edu.imau.redpioneer.dao.ActivistMapper;
import cn.edu.imau.redpioneer.service.UserService;
import cn.edu.imau.redpioneer.vo.ResultVO;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: zyl
 * @date 2021/10/28 17:16
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private ActivistMapper activistMapper;

    @Override
    public ResultVO login(String name, String password) {

        Example example = new Example(SupperAdmin.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("account",name);
        Activist activist = activistMapper.selectOneByExample(example);

        if(activist == null){
            //用户名不存在
            return new ResultVO(10001,"用户名不存在",null);
        }else{
            if(activist.getPassword().equals(password)){
                //登录成功
                return new ResultVO(10000,"登陆成功",activist);
            }else{
                //密码错误
                return new ResultVO(10001,"密码错误",activist);
            }
        }

    }
}
