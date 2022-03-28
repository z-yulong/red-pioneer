package cn.edu.imau.controller.activist;

import cn.edu.imau.redpioneer.vo.ResultVO;
import cn.edu.imau.redpioneer.service.userservice.TalkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import java.io.IOException;
import java.util.Date;

/**
 * @author: zyl
 * @date 2022/1/18 14:26
 */
@CrossOrigin//解决跨域访问
@RestController
@RequestMapping("/talk")
@Api(value = "谈话信息接口",tags = "谈话信息")
public class TalkController {

    private TalkService talkService;
    @Autowired
    public TalkController(TalkService talkService) {
        this.talkService = talkService;
    }

    /**
     * 
     * @param talkTime 谈话时间
     * @param talkPeople 谈话人
     * @param talkType 谈话类型 （1：小组谈话；2：支部谈话）
     * @param prove
     * @param request
     * @return
     */
    @RequiresRoles("user")
    @ApiOperation(value = "上传谈话信息接口")
    @PostMapping("/uploadTalk")
    public ResultVO uploadTalk(
            @RequestParam("talkTime") @DateTimeFormat(pattern="yyyy-MM-dd") Date talkTime,
            @RequestParam("talkPeople") String talkPeople,
            @RequestParam("talkType") Integer talkType,
            MultipartFile prove, ServletRequest request) throws IOException {
        return talkService.uploadTalk(talkTime,talkPeople,talkType,prove,request);
    }

    /**
     * 获取用户谈话息接口
     * @param id
     * @return
     */
    @RequiresRoles(logical = Logical.OR, value = {"admin","shuji","zuzhang","user"})
    @ApiOperation(value = "获取用户谈话息接口")
    @GetMapping("/getTalk/{id}")
    public ResultVO getTalk(@PathVariable("id") Integer id){
        return talkService.getTalkById(id);
    }

    /**
     * 删除谈话息接口
     * @param id
     * @return
     */
    @RequiresRoles(logical = Logical.OR, value = {"admin","shuji","zuzhang","user"})
    @ApiOperation(value = "删除谈话息接口")
    @DeleteMapping("/deleteTalk/{id}")
    public ResultVO deletePrize(@PathVariable("id") Integer id){
        return talkService.deleteTalkById(id);
    }
}
