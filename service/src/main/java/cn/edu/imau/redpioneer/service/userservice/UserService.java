package cn.edu.imau.redpioneer.service.userservice;

import cn.edu.imau.redpioneer.entity.Score;
import cn.edu.imau.redpioneer.enums.ResultVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import java.io.IOException;
import java.util.Date;

public interface UserService {


    ResultVO addprize(MultipartFile prizeImg, Date date, String level, ServletRequest request) throws IOException;

    ResultVO getPrize(ServletRequest request);

    ResultVO addScore(Score score, ServletRequest request);
}
