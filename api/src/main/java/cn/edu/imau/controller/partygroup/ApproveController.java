package cn.edu.imau.controller.partygroup;

import cn.edu.imau.redpioneer.vo.ResultVO;
import cn.edu.imau.redpioneer.service.commonservice.AuditService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: zyl
 * @date 2022/3/8 10:19
 */
@CrossOrigin//解决跨域访问
@RestController
@RequestMapping("/audit")
@Api(value = "提供审批接口",tags = "审批接口")
public class ApproveController {

    AuditService auditService;
    @Autowired
    public ApproveController(AuditService auditService) {
        this.auditService = auditService;
    }

    /**
     * 获取待审批用户
     */
    @ApiOperation(value = "获取待审批用户")
    @RequiresRoles("zuzhang")
    @GetMapping("/getPending")
    public ResultVO getPending(HttpServletRequest request){
        return auditService.getPending(request);
    }


    /**
     * 审批未通过
     */
    @ApiOperation(value = "审批通过")
    @RequiresRoles("zuzhang")
    @PutMapping("/fail/{id}")
    public ResultVO fail(@PathVariable("id")Integer id,String remark,HttpServletRequest request){
        return auditService.fail(id,remark,request);
    }

    /**
     * 审批通过
     */
    @ApiOperation(value = "审批通过")
    @RequiresRoles("zuzhang")
    @PutMapping("/approve/{id}")
    public ResultVO approved(@PathVariable("id")Integer id,String remark,HttpServletRequest request){
        return auditService.approved(id,remark,request);
    }
}
