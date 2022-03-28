package cn.edu.imau.controller.activist;

import cn.edu.imau.redpioneer.vo.ResultVO;
import cn.edu.imau.redpioneer.service.userservice.PrizeService;
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
 * @date 2022/1/1 15:56
 */
@CrossOrigin
@RestController
@RequestMapping("/prize")
@Api(value = "奖惩信息接口",tags = "奖惩信息")
public class PrizeController {

    private PrizeService prizeService;

    @Autowired
    public PrizeController(PrizeService prizeService) {
        this.prizeService = prizeService;
    }

    /**
     * 上传上传奖惩信息
     * @param prizeImg
     * @param date
     * @param info
     * @param request
     * @throws IOException
     */
    @RequiresRoles(logical = Logical.OR, value = {"admin","shuji","zuzhang","user"})
    @ApiOperation(value = "上传奖惩信息接口")
    @PostMapping("/addPrize")
    public ResultVO addPrizeImg(@RequestParam("prizeImg") MultipartFile prizeImg
            , @RequestParam("date") @DateTimeFormat(pattern="yyyy-MM-dd") Date date
            , @RequestParam("info")String info, ServletRequest request) throws IOException {
        return prizeService.addprize(prizeImg,date,info,request);
    }

    /**
     * 获取用户惩信息
     * @param id
     * @return
     */
    @RequiresRoles(logical = Logical.OR, value = {"admin","shuji","zuzhang","user"})
    @ApiOperation(value = "获取用户惩信息接口")
    @GetMapping("/getPrize/{id}")
    public ResultVO getPrize(@PathVariable("id") Integer id){
        return prizeService.getPrizeById(id);
    }

    /**
     * 删除用户奖惩信息
     * @param id
     * @return
     */
    @RequiresRoles(logical = Logical.OR, value = {"admin","shuji","zuzhang","user"})
    @ApiOperation(value = "删除用户奖惩信息")
    @DeleteMapping("/deletePrize/{id}")
    public ResultVO deletePrize(@PathVariable("id") Integer id){
        return prizeService.deletePrizeById(id);
    }
}
