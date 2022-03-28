package cn.edu.imau.redpioneer.service.userservice;

import cn.edu.imau.redpioneer.vo.ResultVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import java.io.IOException;
import java.util.Date;

public interface DevelopmentInfoService {

    ResultVO uploadRdsq(
            Date applicationTime,
            MultipartFile applicationForm,
            Date upactivistTime,
            MultipartFile diploma,
            ServletRequest request
    ) throws IOException;

    ResultVO getDevelopmentInfo(String info);

    ResultVO getDevelopmentInfoById(Integer id);

    ResultVO deleteDevelopmentById(Integer id);

    ResultVO uploadDiploma(Date upactivistTime, MultipartFile diploma, ServletRequest request) throws IOException;

    ResultVO uploadApplication(Date applicationTime, MultipartFile applicationForm, ServletRequest request) throws IOException;
}
