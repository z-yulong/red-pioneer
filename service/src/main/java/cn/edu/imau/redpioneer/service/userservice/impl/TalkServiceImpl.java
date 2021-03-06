package cn.edu.imau.redpioneer.service.userservice.impl;

import cn.edu.imau.redpioneer.dao.TalkMapper;
import cn.edu.imau.redpioneer.entity.Prize;
import cn.edu.imau.redpioneer.entity.Talk;
import cn.edu.imau.redpioneer.enums.ResStatus;
import cn.edu.imau.redpioneer.vo.ResultVO;
import cn.edu.imau.redpioneer.enums.State;
import cn.edu.imau.redpioneer.service.userservice.TalkService;
import cn.edu.imau.redpioneer.utils.FileUtil;
import cn.edu.imau.redpioneer.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author: zyl
 * @date 2022/1/18 14:25
 */
@Service
public class TalkServiceImpl implements TalkService {
    @Resource
    TalkMapper talkMapper;
    @Resource
    FileUtil fileUtil;
    /**
     * 上传谈话记录
     * @param talkTime
     * @param talkPeople
     * @param talkType
     * @param prove
     * @param request
     * @return
     * @throws IOException
     */
    @Override
    public ResultVO uploadTalk(Date talkTime, String talkPeople, Integer talkType, MultipartFile prove, ServletRequest request) throws IOException {

        //从header中获取token
        HttpServletRequest req= (HttpServletRequest) request;
        String token = req.getHeader("Authorization");
        //获取文件保存路径
        String talkImgPATH = fileUtil.uploadImg(prove);

        //从token中获取当前用户id
        Integer id= Integer.valueOf(JWTUtil.getIdByToken(token));

        Talk talk = new Talk();
        talk.setActivistId(id);
        talk.setTalkTime(talkTime);
        talk.setTalkPeople(talkPeople);
        talk.setTalkType(talkType); //谈话类型；1：小组谈话 2：支部谈话
        talk.setProve(talkImgPATH);
        //待审批
        talk.setTalkState(State.PENDING.getValue());
        //插入
        int i = talkMapper.insertSelective(talk);

        if(i == 1){
            //成功
            return new ResultVO(ResStatus.OK.getValue(), ResStatus.OK.getText(), null);
        }
        return new ResultVO(ResStatus.NO.getValue(), ResStatus.NO.getText(), null);
    }

    /**
     * 获取用户谈话息
     * @param id
     * @return
     */
    @Override
    public ResultVO getTalkById(Integer id) {
        Example example=new Example(Talk.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("activistId",id);
        List<Talk> talks = talkMapper.selectByExample(example);
        return new ResultVO(ResStatus.OK.getValue(),ResStatus.OK.getText(), talks);
    }

    /**
     * 删除谈话息
     * @param id
     * @return
     */
    @Override
    public ResultVO deleteTalkById(Integer id) {
        int i = talkMapper.deleteByPrimaryKey(id);
        if(i == 1){
            //成功
            return new ResultVO(ResStatus.DELETE_OK.getValue(), ResStatus.DELETE_OK.getText(), null);
        }
        return new ResultVO(ResStatus.NO.getValue(), ResStatus.NO.getText(), null);
    }


}
