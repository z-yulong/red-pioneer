package cn.edu.imau.redpioneer.service;

import cn.edu.imau.redpioneer.entity.Activist;
import cn.edu.imau.redpioneer.enums.ResultVO;

/**
 * @author: zyl
 * @date 2021/11/10 21:09
 */
public interface UpdateActivistService {

    ResultVO updateActivistInfo(Activist activist);

    ResultVO updateActivistAvatar(String avatar);
}
