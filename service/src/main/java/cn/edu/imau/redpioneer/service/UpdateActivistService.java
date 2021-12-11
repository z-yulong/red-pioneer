package cn.edu.imau.redpioneer.service;

import cn.edu.imau.redpioneer.entity.Activist;
import cn.edu.imau.redpioneer.enums.ResultVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author: zyl
 * @date 2021/11/10 21:09
 */
public interface UpdateActivistService {

    ResultVO updateActivistInfo(Activist activist);

    ResultVO updateActivistAvatar(MultipartFile avatar, ServletRequest request) throws IOException;
}
