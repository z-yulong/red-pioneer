package cn.edu.imau.redpioneer.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Random;
import java.util.UUID;

/**
 * 文件下载
 * @author: zyl
 * @date 2021/11/24 15:07
 */
@Component
public class FileUtil {

    @Value("${spring.upload.path}")
    private String path;
    /**
     * 获取随机名称
     * @param realName 真实名称
     * @return uuid 随机名称
     */
    public static String getUUIDName(String realName) {
        //获取后缀名
        int index = realName.lastIndexOf(".");
        if (index == -1) {
            return UUID.randomUUID().toString().replace("-", "").toUpperCase();
        } else {
            return UUID.randomUUID().toString().replace("-", "").toUpperCase() + realName.substring(index);
        }
    }


    /**
     * 获取文件目录,可以获取256个随机目录
     * @return 随机目录
     */
    public static String getDir() {
        String s = "0123456789ABCDEF";
        Random r = new Random();
        // /A/A
        return "/" + s.charAt(r.nextInt(16)) + "/" + s.charAt(r.nextInt(16));
    }

    /**
     * 上传头像
     * @param avatar
     * @return path 保存路径
     * @throws IOException
     */
    public String uploadImg(MultipartFile avatar) throws IOException {

        //获取文件内容
        InputStream is = avatar.getInputStream();

        //获取原始文件名
        String originalFilename = avatar.getOriginalFilename();

        //生成一个uuid名称出来
        String uuidFilename = getUUIDName(originalFilename);

        //产生一个随机目录
        String randomDir = getDir();

        File fileDir = new File(path + randomDir);

        //若文件夹不存在,则创建出文件夹
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }

        //创建新的文件夹
        File newFile = new File(path + randomDir, uuidFilename);

        //将文件输出到目标的文件中
        avatar.transferTo(newFile);

        //生成保存路径
        String savePath = randomDir + "/" + uuidFilename;

        return savePath;
    }

    /**
     * 文件删除
     *
     * @param filePath 文件路径
     * @return false、true
     */
    public Boolean deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
            //System.out.println("===========删除成功===========");
            return true;
        } else {
            //System.out.println("===========删除失败===========");
            return false;
        }
    }


}
