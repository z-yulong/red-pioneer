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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import java.io.IOException;

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

    @Autowired
    ConversationService conversationService;

    @RequiresRoles(logical = Logical.OR, value = {"admin","shuji","zuzhang","user"})
    @ApiOperation(value = "上传志愿服务信息接口")
    @PostMapping("/addConversation")
    public ResultVO addConversation(@RequestParam("conversationJson") String conversationJson,@RequestParam("prove") MultipartFile prove, ServletRequest request) throws IOException {

        //将String转为json并保存到conversation
        Gson gson=new Gson();
        Conversation conversation = gson.fromJson(conversationJson,Conversation.class);

        return conversationService.addconversation(conversation,prove,request);
    }

    /**
     * 通过姓名或账号查询用户志愿信息
     * @param info
     * @return
     */
    //@RequiresRoles(logical = Logical.OR, value = {"admin","shuji","zuzhang","user"})
    @ApiOperation(value = "通过姓名或账号查询用户发展信息")
    @GetMapping("/getDevelopmentInfo")
    public ResultVO getConversation(@RequestParam("info")String info){
        return conversationService.getConversation(info);

    }
}
