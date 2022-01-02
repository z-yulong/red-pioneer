package cn.edu.imau.redpioneer.service.userservice;

import cn.edu.imau.redpioneer.enums.ResultVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import java.io.IOException;
import java.util.Date;

public interface PrizeService {
    ResultVO addprize(MultipartFile prizeImg, Date date, String info, ServletRequest request) throws IOException;

    ResultVO getPrize(ServletRequest request);
}
