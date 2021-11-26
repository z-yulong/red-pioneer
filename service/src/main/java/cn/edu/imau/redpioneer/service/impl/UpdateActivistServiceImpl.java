package cn.edu.imau.redpioneer.service.impl;

import cn.edu.imau.redpioneer.entity.Activist;
import cn.edu.imau.redpioneer.dao.ActivistMapper;
import cn.edu.imau.redpioneer.enums.ResStatus;
import cn.edu.imau.redpioneer.enums.ResultVO;
import cn.edu.imau.redpioneer.service.UpdateActivistService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: zyl
 * @date 2021/11/10 21:55
 */
@Service
public class UpdateActivistServiceImpl implements UpdateActivistService {

    @Resource
    private ActivistMapper activistMapper;


    @Override
    public ResultVO updateActivistInfo(Activist activist) {
        //activistMapper.updateByPrimaryKey(activist);

        activistMapper.updateInfoByPrimaryKey(activist);
        return new ResultVO(ResStatus.OK.getValue(), ResStatus.OK.getText(),activist);
    }

    @Override
    public ResultVO updateActivistAvatar(String avatar) {
        return null;
    }
}
