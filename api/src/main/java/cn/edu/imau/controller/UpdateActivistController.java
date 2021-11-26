package cn.edu.imau.controller;

import cn.edu.imau.redpioneer.entity.Activist;
import cn.edu.imau.redpioneer.enums.ResultVO;
import cn.edu.imau.redpioneer.service.UpdateActivistService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author: zyl
 * @date 2021/11/11 15:51
 */

@CrossOrigin//解决跨域访问
@RestController
@RequestMapping("/center")
@Api(value = "个人中心接口",tags = "个人信息接口")
public class UpdateActivistController {
    @Resource
    private UpdateActivistService updateActivistService;

    @ApiOperation(value = "修改个人信息接口")
    @PostMapping("/update")
    @ApiImplicitParam(dataType = "String",name = "token",value = "授权令牌",required = true)
    public ResultVO updateUser(Activist activist){
        return updateActivistService.updateActivistInfo(activist);

    }


}
