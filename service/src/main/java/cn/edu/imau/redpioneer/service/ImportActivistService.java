package cn.edu.imau.redpioneer.service;

import cn.edu.imau.redpioneer.enums.ResultVO;
import org.springframework.web.multipart.MultipartFile;


public interface ImportActivistService {

    ResultVO importExcel(MultipartFile myFile);
}
