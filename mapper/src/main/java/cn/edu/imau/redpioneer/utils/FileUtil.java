package cn.edu.imau.redpioneer.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * 文件下载
 * @author: zyl
 * @date 2021/11/24 15:07
 */

public class FileUtil {

    public static HttpServletResponse download(String path, HttpServletResponse response) {
        try {
            // path是指欲下载的文件的路径。
            File file = new File(path);
            // 取得文件名。
            String filename = file.getName();
            // 取得文件的后缀名。
            String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();

            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream(path));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
            response.addHeader("Content-Length", "" + file.length());
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return response;
    }

    /**
     * 判断是linux系统还是其他系统
     * 如果是Linux系统，返回true，否则返回false
     */
    public static boolean isLinux() {
        return System.getProperty("os.name").toLowerCase().contains("linux");
    }

    /**
     * 创建默认目录
     *
     * @throws IOException io异常
     */
    public static void creatDefaultDir() throws IOException {
        String dir = "C:\\opt\\mail\\mail";
        if (FileUtil.isLinux()) {
            dir = "/opt/mail/mail/";
        }
        if (dir==null) {
            File file = new File(dir);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
        }
    }



    /**
     * 创建指定目录
     * @param
     * @throws IOException io异常
     */
    public static void createTargetDir(String dir){
        if (null == dir){
            dir = "C:\\opt\\mail";
            if (FileUtil.isLinux()) {
                dir = "/opt/mail/";
            }
        }
        if (null != dir) {
            File file = new File(dir);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("创建文件失败");
            }
        }
    }
}
