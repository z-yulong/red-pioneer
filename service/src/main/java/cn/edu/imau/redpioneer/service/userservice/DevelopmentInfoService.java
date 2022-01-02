package cn.edu.imau.redpioneer.service.userservice;

import cn.edu.imau.redpioneer.enums.ResultVO;
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
}
