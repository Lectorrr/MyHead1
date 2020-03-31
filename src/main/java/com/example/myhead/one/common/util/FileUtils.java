package com.example.myhead.one.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class FileUtils {

    private final static Logger logger = LoggerFactory.getLogger(FileUtils.class);

    /***
     * 保存文件
     * @param file
     * @return
     */
    public static boolean saveFile(MultipartFile file, String path, String fileName) {
        // 判断文件是否为空
        if (!file.isEmpty()) {
            try {
                File filepath = new File(path);
                if (!filepath.exists()){
                    filepath.mkdirs();
                }
                // 文件保存路径
                String savePath = filepath.getPath() + File.separator + fileName;
                // 转存文件
                file.transferTo(new File(savePath));
                return true;
            } catch (Exception e) {
                logger.error("文件保存失败：{}",path + "/" + fileName);
                return false;
            }
        }
        return false;
    }

    /**
     * 删除文件
     *
     * @param filePath 文件路径
     * @return boolean
     */
    public static boolean deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.exists() && file.isFile()) {
            return file.delete();
        }
        return false;
    }

    /**
     * 下载文件
     */
    public static Boolean downloadFile(String fileName, String filePath, HttpServletRequest request, HttpServletResponse response) {
        response.reset();
        response.setContentType("text/html;charset=utf-8");

        try {

            File file = new File(filePath);

            //如果文件不存在，则显示下载失败
            if (!file.exists()) {
                logger.warn("File:{{}} is not exists!",fileName);
                return false;
            } else {
                // 设置相应头，控制浏览器下载该文件，这里就是会出现当你点击下载后，出现的下载地址框
                response.setContentType("application/x-download");
                fileName = processFileName(request, fileName);
                response.setHeader("content-disposition", "attachment;filename=" + fileName);
                // 读取要下载的文件，保存到文件输入流
                FileInputStream in = new FileInputStream(filePath);
                // 创建输出流
                OutputStream out = response.getOutputStream();
                // 创建缓冲区
                byte buffer[] = new byte[1024];
                int len;
                // 循环将输入流中的内容读取到缓冲区中
                while ((len = in.read(buffer)) > 0) {
                    // 输出缓冲区内容到浏览器，实现文件下载
                    out.write(buffer, 0, len);
                }
                // 关闭文件流
                in.close();
                // 关闭输出流
                out.close();
            }
            return true;
        } catch (Exception e) {
            logger.error("Exception downloading file, fileName:{}", fileName);
            e.printStackTrace();
            return false;
        }
    }


    /**
     * @Title: processFileName
     * @Description: ie, chrom, firfox下处理文件名显示乱码
     */
    public static String processFileName(HttpServletRequest request, String fileNames) {
        String codedfilename = null;
        try {
            String agent = request.getHeader("USER-AGENT");
            if (null != agent && agent.contains("MSIE") || null != agent && agent.contains("Trident")) {// ie
                codedfilename = URLEncoder.encode(fileNames, "UTF8");
            } else if (null != agent && agent.contains("Mozilla")) {// 火狐,chrome等
                codedfilename = new String(fileNames.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
            } else {
                codedfilename = URLEncoder.encode(fileNames, "UTF8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return codedfilename;
    }


//    //静态方法：三个参数：文件的二进制，文件路径，文件名
//    //通过该方法将在指定目录下添加指定文件
//    public static void fileupload(byte[] file,String filePath,String fileName) throws IOException {
//        //目标目录
//        File targetfile = new File(filePath);
//        if(targetfile.exists()) {
//            targetfile.mkdirs();
//        }
//
//        //二进制流写入
//        FileOutputStream out = new FileOutputStream(filePath+fileName);
//        out.write(file);
//        out.flush();
//        out.close();
//    }



    //            // 获取文件名称,包含后缀
//            String fileName = file.getOriginalFilename();
//
//            // 存放在这个路径下：该路径是该工程目录下的static文件下：(注：该文件可能需要自己创建)
//            // 放在static下的原因是，存放的是静态文件资源，即通过浏览器输入本地服务器地址，加文件名时是可以访问到的
//            String path = ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static/";
//
//            try {
//                // 该方法是对文件写入的封装，在util类中，导入该包即可使用，后面会给出方法
//                FileUtils.fileupload(file.getBytes(), path, fileName);
//            } catch (IOException e) {
    //TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//
//            // 接着创建对应的实体类，将以下路径进行添加，然后通过数据库操作方法写入
//            FilePath biaopath = new FilePath();
//            biaopath.setPath("http://localhost:8080/"+fileName);
//            filePathRepository.save(biaopath);
}
