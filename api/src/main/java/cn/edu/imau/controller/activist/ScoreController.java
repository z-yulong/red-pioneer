package cn.edu.imau.controller.activist;

import cn.edu.imau.redpioneer.entity.Score;
import cn.edu.imau.redpioneer.vo.ResultVO;
import cn.edu.imau.redpioneer.service.userservice.ScoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;


/**
 *
 * @author: zyl
 * @date 2021/12/11 12:33
 */

@CrossOrigin//解决跨域访问
@RestController
@RequestMapping("/score")
@Api(value = "成绩信息接口",tags = "成绩信息")
public class ScoreController {

    @Resource
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

    @RequiresRoles(logical = Logical.OR, value = {"admin","shuji","zuzhang","user"})
    @ApiOperation(value = "获取成绩接口")
    @GetMapping("/getScore/{id}")
    public ResultVO addScore(@PathVariable Integer id){
        return scoreService.getScoreById(id);
    }


    /**
     * 删除用户学习成绩信息
     * @param id
     * @return
     */
    @RequiresRoles(logical = Logical.OR, value = {"admin","shuji","zuzhang","user"})
    @ApiOperation(value = "删除用户学习成绩信息")
    @DeleteMapping("/deleteScore/{id}")
    public ResultVO deleteScore(@PathVariable("id") Integer id){
        return scoreService.deleteScore(id);
    }
}
