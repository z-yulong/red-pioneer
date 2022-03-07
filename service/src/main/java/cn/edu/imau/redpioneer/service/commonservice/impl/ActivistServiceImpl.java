package cn.edu.imau.redpioneer.service.commonservice.impl;

import cn.edu.imau.redpioneer.dao.ActivistMapper;
import cn.edu.imau.redpioneer.entity.Activist;
import cn.edu.imau.redpioneer.enums.ResStatus;
import cn.edu.imau.redpioneer.enums.ResultVO;
import cn.edu.imau.redpioneer.service.commonservice.ActivistService;
import cn.edu.imau.redpioneer.utils.JWTUtil;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * @author: zyl
 * @date 2021/10/28 17:16
 */
@Service
public class ActivistServiceImpl implements ActivistService {
    private final ActivistMapper activistMapper;
    @Autowired
    public ActivistServiceImpl(ActivistMapper activistMapper){
        this.activistMapper=activistMapper;
    }


    /**
     * 登录
     * @param account 账号
     * @param password 密码
     * @return activist
     * @throws UnsupportedEncodingException c
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
     * @param id 用户id
     * @return null
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
     * @param id 用户id
     * @return activist
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
     * @param account 账号
     * @return activist
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
     * @param account 账号
     * @return activist
     */
    public Activist getUser(String account) {
        Example example = new Example(Activist.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("account",account);
        return activistMapper.selectOneByExample(example);
    }

    /**
     * 根据角色获取支部负责人
     * @return activists
     */
    @Override
    public ResultVO getUserByRole() {

        Example example = new Example(Activist.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("roles","shuji");

        List<Activist> activists = activistMapper.selectByExample(example);

        return new ResultVO(ResStatus.OK.getValue(), ResStatus.OK.getText(),activists);
    }

    /**
     * 管理员注册账号
     * @param account 账号
     * @param name 姓名
     * @param roles 角色
     * @return activist
     */
    @Override
    public ResultVO register(String account, String name, String roles) {
        //查询账号是否存在
        Example example = new Example(Activist.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("account",account);
        Activist activist1 = activistMapper.selectOneByExample(example);
        if(activist1 != null){
            return new ResultVO(ResStatus.EXISTED.getValue(), ResStatus.EXISTED.getText(),null);
        }
        Activist activist = new Activist();
        activist.setAccount(account);
        activist.setName(name);
        activist.setRoles(roles);

        //设置默认值
        defaultValue(activist);

        int i = activistMapper.insert(activist);

        if(i == 1){
            //注册成功
            return new ResultVO(ResStatus.OK.getValue(), ResStatus.OK.getText(),null);
        }
        return new ResultVO(ResStatus.NO.getValue(), ResStatus.NO.getText(),activist);
    }

    /**
     * 分页查询所有人
     * @param rowBounds rowBounds
     * @param request request
     * @return activists
     */
    @Override
    public ResultVO selectActivistPage(RowBounds rowBounds, HttpServletRequest request) {
        Activist activist = new Activist();
        List<Activist> activists = activistMapper.selectByRowBounds(activist, rowBounds);
        return new ResultVO(ResStatus.OK.getValue(), ResStatus.OK.getText(), activists);
    }


    /**
     * 根据姓名获取一个用户
     * @param name 姓名
     * @return activist
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
     * 通过id更新个人信息
     * @param activist activist
     * @return activist
     */
    @Override
    public ResultVO updateActivistByid(Activist activist, HttpServletRequest request) {

        String token = request.getHeader("Authorization");

        //从token中获取当前用户id
        Integer id= Integer.valueOf(JWTUtil.getIdByToken(token));
        activist.setId(id);

        //根据主键更新不为null的值
        int i = activistMapper.updateByPrimaryKeySelective(activist);

        if(i == 1){
            //更新成功
            return new ResultVO(ResStatus.UPDATE_OK.getValue(), ResStatus.UPDATE_OK.getText(),null);
        }
        return new ResultVO(ResStatus.NO.getValue(), ResStatus.NO.getText(),activist);
    }

    /**
     * 设置默认值
     * @param activist activist
     */
    private void defaultValue(Activist activist){
        activist.setSex("");
        activist.setPassword("888888");
        activist.setBirthday(new Date(2000-01-01));
        activist.setNation("");
        activist.setNativePlace("");
        activist.setIdCard("");
        activist.setAddress("");
        activist.setTel("");
        activist.setPhoto("");
        activist.setClasses("");
        activist.setEmail("");
        activist.setTrain("");
        activist.setStateCode(1);
    }

}
