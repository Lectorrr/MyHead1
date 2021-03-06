package com.example.myhead.one.controller.resource;

import com.alibaba.fastjson.JSON;
import com.example.myhead.one.base.BaseController;
import com.example.myhead.one.common.util.FileUtils;
import com.example.myhead.one.dto.resource.FilesDTO;
import com.example.myhead.one.entity.resource.Files;
import com.example.myhead.one.service.resource.FilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/resource/files")
public class FilesController extends BaseController<Files, FilesDTO, String> {

    @Autowired
    private FilesService filesService;

    @Override
    public String getPathPrefix() {
        return "files";
    }

    /**
     * showList界面的数据
     * 包含分页查询
     *
     * @param request http请求
     */
    @RequestMapping(value = "/listData", method = RequestMethod.GET)
    @ResponseBody
    public Object listData(HttpServletRequest request) {
        Map<String, Object> data = new HashMap<>();
        data.put("data", filesService.findAll());
        return JSON.toJSONString(data);
//        Map<String, String[]> parameterMap = request.getParameterMap();
//        ResultData<Files> filesResultData = filesService.findWithPage(parameterMap, Files.class);
//        return filesResultData;
    }

    /**
     * 单文件上传
     * @param file
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
        if(!file.isEmpty()) {
            String fileName = file.getOriginalFilename();

            //这个文件路径有问题，保存在了打的 target 包里面。
            String filePath = ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static/";
            if (FileUtils.saveFile(file, filePath, fileName)){
                Files files = new Files();
                files.setFileName(fileName + file.getOriginalFilename());
                files.setFileRoad(filePath);

//                FilesType filesType = new FilesType();
//                filesType.setType(file.getContentType());
//                filesTypeService.saveOrUpdate(filesType);
//                files.setFilesType(filesType);
                filesService.saveOrUpdate(files);
            }
        }

        return "";
    }

    /**
     * 查找所有书籍信息
     */
    @RequestMapping(value = "/getAll")
    @ResponseBody
    public Object getAll() {
        List<Files> bookInfos = filesService.findAll();
        return bookInfos;
    }

    /**
     * 文件下载
     */
    @RequestMapping(value = "/download")
    @ResponseBody
    public String download() {
        List<Files> bookInfos = filesService.findAll();
        return "";
    }
}
