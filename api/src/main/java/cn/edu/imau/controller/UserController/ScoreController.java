package cn.edu.imau.controller.UserController;

import cn.edu.imau.redpioneer.entity.Score;
import cn.edu.imau.redpioneer.enums.ResultVO;
import cn.edu.imau.redpioneer.service.userservice.PrizeService;
import cn.edu.imau.redpioneer.service.userservice.ScoreService;
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
 *
 * @author: zyl
 * @date 2021/12/11 12:33
 */

@CrossOrigin//解决跨域访问
@RestController
@RequestMapping("/source")
@Api(value = "成绩信息接口",tags = "成绩信息")
public class ScoreController {

    @Autowired
    ScoreService scoreService;

    /**
     * 上传成绩
     * @param request
     * @return
     */
    @RequiresRoles("user")
    @ApiOperation(value = "上传成绩接口")
    @PostMapping("/addScore")
    public ResultVO addScore(@RequestBody Score score, ServletRequest request){
        return scoreService.addScore(score,request);
    }

}
