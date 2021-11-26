package cn.edu.imau.redpioneer.service.impl;

import cn.edu.imau.redpioneer.entity.Activist;

import cn.edu.imau.redpioneer.dao.ActivistMapper;
import cn.edu.imau.redpioneer.enums.ResStatus;
import cn.edu.imau.redpioneer.enums.ResultVO;
import cn.edu.imau.redpioneer.service.ActivistService;
import cn.edu.imau.redpioneer.utils.GenerateToken;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author: zyl
 * @date 2021/10/28 17:16
 */
@Service
public class ActivistServiceImpl implements ActivistService {

    @Resource
    private ActivistMapper activistMapper;


    @Override
    public ResultVO login(String account, String password) {

        Example example = new Example(Activist.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("account",account);
        Activist activist = activistMapper.selectOneByExample(example);

        if(activist == null){
            //用户名不存在
            return new ResultVO(ResStatus.USER_DOSE_NOT_EXITS.getValue()
                                , ResStatus.USER_DOSE_NOT_EXITS.getText(),null);
        }else{
            //String md5Pwd = MD5Utils.md5(password);
            if(activist.getPassword().equals(password)){
                //登录成功
                //生成token令牌
                HashMap<String,Object> map = new HashMap<>();
                map.put("id",activist.getId());
                map.put("juri",activist.getJuri());
                String token = GenerateToken.createToken(activist.getId(), account, activist, map);

                return new ResultVO(ResStatus.OK.getValue(),token,activist);
            }else{
                //密码错误
                return new ResultVO(ResStatus.PASSWORD_ERROR.getValue()
                            , ResStatus.PASSWORD_ERROR.getText(),null);
            }
        }

    }
}
