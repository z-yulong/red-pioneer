package cn.edu.imau.redpioneer.service.commonservice;

import cn.edu.imau.redpioneer.vo.ResultVO;

import javax.servlet.http.HttpServletRequest;

public interface AuditService {

    ResultVO getPending(HttpServletRequest request);

    ResultVO approved(Integer id, String remark, HttpServletRequest request);

    ResultVO fail(Integer id, String remark, HttpServletRequest request);


}
