package cn.edu.imau.redpioneer.service.impl;

import cn.edu.imau.redpioneer.entity.Activist;

import cn.edu.imau.redpioneer.dao.ActivistMapper;
import cn.edu.imau.redpioneer.enums.ResStatus;
import cn.edu.imau.redpioneer.enums.ResultVO;
import cn.edu.imau.redpioneer.service.ActivistService;
import cn.edu.imau.redpioneer.utils.JWTUtil;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * @author: zyl
 * @date 2021/10/28 17:16
 */
@Service
public class ActivistServiceImpl implements ActivistService {

    @Resource
    private ActivistMapper activistMapper;

    /**
     * 登录
     * @param account
     * @param password
     * @return
     * @throws UnsupportedEncodingException
     */
    @Override
    public ResultVO login(String account, String password) throws UnsupportedEncodingException {
        //创建一个Example封装类 类别Activist查询条件
        Example example = new Example(Activist.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("account",account);

        Activist activist = activistMapper.selectOneByExample(example);

        if(activist == null){
            //用户名不存在
            return new ResultVO(ResStatus.USER_DOSE_NOT_EXITS.getValue()
                                ,ResStatus.USER_DOSE_NOT_EXITS.getText(),null);
        }else{
            //String md5Pwd = MD5Utils.md5(password);
            if(activist.getPassword().equals(password)){
                //登录成功
                //生成token令牌
                String token= JWTUtil.createToken(activist);
                return new ResultVO(ResStatus.OK.getValue(),token,activist);
            }else{
                //密码错误
                return new ResultVO(ResStatus.PASSWORD_ERROR.getValue()
                            , ResStatus.PASSWORD_ERROR.getText(),null);
            }
        }
    }

    /**
     * 根据id删除一个用户
     * @param id
     * @return
     */
    @Override
    public ResultVO deleteById(Integer id) {

        int i = activistMapper.deleteByPrimaryKey(id);

        if(i == 1){
            //删除成功
            return new ResultVO(ResStatus.DELETE_OK.getValue()
                    , ResStatus.DELETE_OK.getText(),null);
        }
            //用户不存在（id传错了）
            return new ResultVO(ResStatus.USER_DOSE_NOT_EXITS.getValue()
                    , ResStatus.USER_DOSE_NOT_EXITS.getText(),null);
    }

    /**
     * 根据id获取一个用户
     * @param id
     * @return
     */
    @Override
    public ResultVO getUserById(Integer id) {
        Activist activist = activistMapper.selectByPrimaryKey(id);
        if(activist == null){
            //用户不存在
            return new ResultVO(ResStatus.USER_DOSE_NOT_EXITS.getValue()
                    , ResStatus.USER_DOSE_NOT_EXITS.getText(),null);
        }
            return new ResultVO(ResStatus.OK.getValue()
                    , ResStatus.OK.getText(),activist);
    }

    /**
     * 根据账号获取一个用户
     * @param account
     * @return
     */
    @Override
    public ResultVO getUserByAccount(String account) {

        Example example = new Example(Activist.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("account",account);
        Activist activist = activistMapper.selectOneByExample(example);

        if(activist == null){
            //用户不存在
            return new ResultVO(ResStatus.USER_DOSE_NOT_EXITS.getValue()
                    , ResStatus.USER_DOSE_NOT_EXITS.getText(),null);
        }
            return new ResultVO(ResStatus.OK.getValue()
                    , ResStatus.OK.getText(),activist);
    }


    /**
     * 根据账号获取一个用户
     * @param account
     * @return
     */
    public Activist getUser(String account) {
        Example example = new Example(Activist.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("account",account);
        Activist activist = activistMapper.selectOneByExample(example);
        return activist;
    }

    /**
     * 根据角色获取支部负责人
     * @return
     */
    @Override
    public ResultVO getUserByRole() {

        Example example = new Example(Activist.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("roles","shuji");

        List<Activist> activists = activistMapper.selectByExample(example);

        return new ResultVO(ResStatus.OK.getValue()
                , ResStatus.OK.getText(),activists);
    }

    /**
     * 管理员注册账号
     * @param account
     * @param name
     * @param roles
     * @return
     */
    @Override
    public ResultVO register(String account, String name, String roles) {

        Activist activist = new Activist();
        activist.setAccount(account);
        activist.setPassword("888888");
        activist.setName(name);
        activist.setRoles(roles);

        int i = activistMapper.insert(activist);
        if(i == 1){
            //注册成功
            return new ResultVO(ResStatus.OK.getValue()
                    , ResStatus.OK.getText(),null);
        }
        return new ResultVO(ResStatus.NO.getValue()
                , ResStatus.NO.getText(),activist);
    }


    /**
     * 根据姓名获取一个用户
     * @param name
     * @return
     */
    @Override
    public ResultVO getUserByName(String name) {

        Example example = new Example(Activist.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("name",name);
        Activist activist = activistMapper.selectOneByExample(example);

        if(activist == null){
            return new ResultVO(ResStatus.USER_DOSE_NOT_EXITS.getValue()
                    , ResStatus.USER_DOSE_NOT_EXITS.getText(),null);
        }
            return new ResultVO(ResStatus.OK.getValue()
                    , ResStatus.OK.getText(),activist);

    }

    /**
     * 通过id更新一个用户
     * @param activist
     * @return
     */
    @Override
    public ResultVO updateActivistByid(Activist activist) {
        int i = activistMapper.updateByPrimaryKey(activist);

        if(i == 1){
            //更新成功
            return new ResultVO(ResStatus.UPDATE_OK.getValue()
                    , ResStatus.UPDATE_OK.getText(),null);
        }
        return new ResultVO(ResStatus.NO.getValue()
                , ResStatus.NO.getText(),activist);
    }

}
