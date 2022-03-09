package cn.edu.imau.redpioneer.service.commonservice;

import cn.edu.imau.redpioneer.vo.ResultVO;
import org.springframework.web.multipart.MultipartFile;


public interface ImportActivistService {

    ResultVO importExcel(MultipartFile myFile);
}
