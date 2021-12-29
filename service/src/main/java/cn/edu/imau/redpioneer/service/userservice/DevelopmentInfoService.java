package cn.edu.imau.redpioneer.service.userservice;

import cn.edu.imau.redpioneer.enums.ResultVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import java.io.IOException;

public interface DevelopmentInfoService {

    ResultVO uploadRdsq(MultipartFile imgFile, ServletRequest request) throws IOException;
}
