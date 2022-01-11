package cn.edu.imau.redpioneer.service.commonservice.impl;

import cn.edu.imau.redpioneer.dao.ActivistMapper;
import cn.edu.imau.redpioneer.dao.PartyGroupMapper;
import cn.edu.imau.redpioneer.dao.TrainMapper;
import cn.edu.imau.redpioneer.entity.Activist;
import cn.edu.imau.redpioneer.entity.PartyGroup;
import cn.edu.imau.redpioneer.entity.Train;
import cn.edu.imau.redpioneer.enums.ResStatus;
import cn.edu.imau.redpioneer.enums.ResultVO;
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
    @Autowired
    TrainMapper trainMapper;
    @Autowired
    PartyGroupMapper partyGroupMapper;
    @Autowired
    ActivistMapper activistMapper;

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
        criteria.andEqualTo("activistId",id);
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


}
