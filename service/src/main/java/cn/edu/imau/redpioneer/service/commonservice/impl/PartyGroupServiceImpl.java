package cn.edu.imau.redpioneer.service.commonservice.impl;

import cn.edu.imau.redpioneer.dao.ActivistMapper;
import cn.edu.imau.redpioneer.dao.DevelopmentInfoMapper;
import cn.edu.imau.redpioneer.dao.PartyGroupMapper;
import cn.edu.imau.redpioneer.dao.TrainMapper;
import cn.edu.imau.redpioneer.entity.Activist;
import cn.edu.imau.redpioneer.entity.DevelopmentInfo;
import cn.edu.imau.redpioneer.entity.PartyGroup;
import cn.edu.imau.redpioneer.entity.Train;
import cn.edu.imau.redpioneer.enums.ResStatus;
import cn.edu.imau.redpioneer.enums.ResultVO;
import cn.edu.imau.redpioneer.enums.State;
import cn.edu.imau.redpioneer.service.commonservice.PartyGroupService;
import cn.edu.imau.redpioneer.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: zyl
 * @date 2022/1/6 15:38
 */
@Service
public class PartyGroupServiceImpl implements PartyGroupService {
    //用户状态码：待审批
    private static final Integer PENDING = 2;

    @Autowired
    TrainMapper trainMapper;
    @Autowired
    PartyGroupMapper partyGroupMapper;
    @Autowired
    ActivistMapper activistMapper;
    @Autowired
    DevelopmentInfoMapper developmentInfoMapper;

    /**
     * 添加培养人
     * @param train
     * @param request
     * @return
     */
    @Override
    public ResultVO addTrain(Train train, HttpServletRequest request) {

        //从header中获取token
        String token = request.getHeader("Authorization");
        //从token中获取当前用户id
        Integer id= Integer.valueOf(JWTUtil.getIdByToken(token));

        //查询当前用户所管理的党小组信息
        Example example = new Example(PartyGroup.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("activistId",id);
        PartyGroup partyGroup = partyGroupMapper.selectOneByExample(example);

        //设置培养人所属党小组
        train.setPartyGroupId(partyGroup.getId());
        //插入
        int i = trainMapper.insert(train);
        if(i == 1){
            return new ResultVO(ResStatus.OK.getValue(), ResStatus.OK.getText(), null);
        }
        return new ResultVO(ResStatus.NO.getValue(), ResStatus.NO.getText(), null);

    }

    /**
     * 通过id删除培养人
     * @param id
     * @return
     */
    @Override
    public ResultVO deleteTrainById(Integer id) {
        int i = trainMapper.deleteByPrimaryKey(id);
        if(i == 1){
            return new ResultVO(ResStatus.DELETE_OK.getValue(), ResStatus.DELETE_OK.getText(), null);
        }
        return new ResultVO(ResStatus.NO.getValue(), ResStatus.NO.getText(), null);
    }

    /**
     * 通过id更新培养人信息
     * @param train
     * @return
     */
    @Override
    public ResultVO updateTrainById(Train train) {
        int i = trainMapper.updateByPrimaryKeySelective(train);

        if(i == 1){
            //更新成功
            return new ResultVO(ResStatus.UPDATE_OK.getValue(), ResStatus.UPDATE_OK.getText(), null);
        }
        return new ResultVO(ResStatus.NO.getValue(), ResStatus.NO.getText(), null);
    }

    /**
     * 获取自己小组下所有培养人
     * @return
     */
    @Override
    public ResultVO getAllTrain(HttpServletRequest request) {
        //从header中获取token
        String token = request.getHeader("Authorization");
        //从token中获取当前用户id
        Integer id= Integer.valueOf(JWTUtil.getIdByToken(token));

        //查询自己党小组下培养人
        Example example = new Example(Train.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("partyGroupId",id);
        List<Train> trains = trainMapper.selectByExample(example);

        return new ResultVO(ResStatus.OK.getValue(), ResStatus.OK.getText(), trains);
    }

    /**
     * 通过id修改积极分子信息，培养人分配
     * @return
     */
    @Override
    public ResultVO updateActivist(Activist activist) {

        int i = activistMapper.updateByPrimaryKeySelective(activist);

        if(i == 1){
            //更新成功
            return new ResultVO(ResStatus.UPDATE_OK.getValue(), ResStatus.UPDATE_OK.getText(), null);
        }
        return new ResultVO(ResStatus.NO.getValue(), ResStatus.NO.getText(), null);
    }

    /**
     * 获取待审批用户
     */
    @Override
    public ResultVO getPending() {
        //创建一个Example封装类 类别Activist查询条件
        Example example = new Example(DevelopmentInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("stateCode", State.PENDING.getValue());

        List<DevelopmentInfo> developmentInfos = developmentInfoMapper.selectByExample(example);

        if(developmentInfos.isEmpty()){
            //没有待审批用户
            return new ResultVO(ResStatus.EMPTY.getValue(), ResStatus.EMPTY.getText(), null);
        }
        return new ResultVO(ResStatus.OK.getValue(), ResStatus.OK.getText(), developmentInfos);
    }


    /**
     * 审批通过
     */
    @Override
    public ResultVO approved(Integer id,String remark) {
        DevelopmentInfo developmentInfo = new DevelopmentInfo();

        developmentInfo.setId(id);
        //通过
        developmentInfo.setStateCode(State.APPROVED.getValue());

        //如果备注不为null或者""
        if (!remark.isEmpty() || "".equals(remark)){
            developmentInfo.setRemark(remark);
        }
        //根据主键更新不为null的字段
        int i = developmentInfoMapper.updateByPrimaryKeySelective(developmentInfo);

        if(i == 1){
            //更新成功
            return new ResultVO(ResStatus.UPDATE_OK.getValue(), ResStatus.UPDATE_OK.getText(), null);
        }
        return new ResultVO(ResStatus.NO.getValue(), ResStatus.NO.getText(), null);
    }

    /**
     * 审批未通过
     */
    @Override
    public ResultVO pass(Integer id, String remark) {

        DevelopmentInfo developmentInfo = new DevelopmentInfo();

        developmentInfo.setId(id);
        //未通过
        developmentInfo.setStateCode(State.PASS.getValue());

        //如果备注不为null或者""
        if (!remark.isEmpty() || "".equals(remark)){
            developmentInfo.setRemark(remark);
        }
        //根据主键更新不为null的字段
        int i = developmentInfoMapper.updateByPrimaryKeySelective(developmentInfo);

        if(i == 1){
            //更新成功
            return new ResultVO(ResStatus.UPDATE_OK.getValue(), ResStatus.UPDATE_OK.getText(), null);
        }
        return new ResultVO(ResStatus.NO.getValue(), ResStatus.NO.getText(), null);

    }


}
