package cn.edu.imau.controller;

import cn.edu.imau.redpioneer.enums.ResultVO;
import cn.edu.imau.redpioneer.service.ImportActivistService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author: zyl
 * @date 2021/11/24 17:28
 */
@CrossOrigin//解决跨域访问
@RestController
@ResponseBody
@RequestMapping("/import")
@Api(value = "提供管理员批量新增用户",tags = "批量注册")
public class ImportExcel {

    @Autowired
    ImportActivistService importActivistService;

    //  Excel导入数据到数据库
    @RequiresRoles("管理员")
    @ApiOperation(value = "批量注册接口")
    @PostMapping("/importExcel")
    public ResultVO importExcel(@RequestParam("myfile") MultipartFile myFile){

        return importActivistService.importExcel(myFile);
    }
}
