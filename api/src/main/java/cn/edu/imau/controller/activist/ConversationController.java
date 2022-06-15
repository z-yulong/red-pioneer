package cn.edu.imau.controller.activist;

import cn.edu.imau.redpioneer.entity.Conversation;
import cn.edu.imau.redpioneer.vo.ResultVO;
import cn.edu.imau.redpioneer.service.userservice.ConversationService;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import java.io.IOException;
import java.util.Date;

/**
 * @author: zyl
 * @date 2022/1/1 22:17
 */
@CrossOrigin
@RestController
@ResponseBody
@RequestMapping("/conversation")
@Api(value = "提供用户志愿服务操作接口",tags = "志愿服务")
public class ConversationController {
    private ConversationService conversationService;
    @Autowired
    public ConversationController(ConversationService conversationService) {
        this.conversationService = conversationService;
    }


    @RequiresRoles(logical = Logical.OR, value = {"admin","shuji","zuzhang","user"})
    @ApiOperation(value = "上传志愿服务信息接口")
    @PostMapping("/addConversation")
    public ResultVO addConversation(
            @DateTimeFormat(pattern="yyyy-MM-dd") @RequestParam("volunteerTime") Date volunteerTime
            ,@RequestParam("volunteerAddress")String volunteerAddress
            ,@RequestParam("volunteerInfo")String volunteerInfo
            ,@RequestParam("volunteerSize")String volunteerSize
            , @RequestParam("prove") MultipartFile prove
            , ServletRequest request) throws IOException {

        return conversationService.addconversation(volunteerTime,volunteerAddress,volunteerInfo,volunteerSize,prove,request);
    }


    @RequiresRoles(logical = Logical.OR, value = {"admin","shuji","zuzhang","user"})
    @ApiOperation(value = "通过id获取志愿信息")
    @GetMapping("/getConversation/{id}")
    public ResultVO getConversation(@PathVariable("id")Integer id){
        return conversationService.getConversationById(id);
    }

    /**
     * 删除用户志愿信息
     * @param id
     * @return
     */
    @RequiresRoles(logical = Logical.OR, value = {"admin","shuji","zuzhang","user"})
    @ApiOperation(value = "删除用户志愿信息")
    @DeleteMapping("/deleteConversation/{id}")
    public ResultVO deleteConversation(@PathVariable("id") Integer id){
        return conversationService.deleteConversation(id);
    }
}
