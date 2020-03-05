package com.example.myhead.one.controller.resource;

import com.example.myhead.one.base.BaseController;
import com.example.myhead.one.common.entity.ResultData;
import com.example.myhead.one.entity.resource.Files;
import com.example.myhead.one.service.resource.FilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/resource/files")
public class FilesController extends BaseController<Files, String> {

    @Autowired
    private FilesService filesService;

    @Override
    public String getPathPrefix() {
        return "files";
    }

    /**
     * 显示 文件上传 界面
     */
    @RequestMapping("/showUploadPage")
    public String showUploadPage() {
        return this.viewName(this.getPathPrefix()) + "-upload";
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
        Map<String, String[]> parameterMap = request.getParameterMap();
        ResultData<Files> filesResultData = filesService.findWithPage(parameterMap, Files.class);
        return filesResultData;
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
}
