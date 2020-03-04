package com.example.myhead.one.controller.resource;

import com.example.myhead.one.base.BaseController;
import com.example.myhead.one.common.entity.ResultData;
import com.example.myhead.one.entity.resource.Upload;
import com.example.myhead.one.service.resource.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/resource/upload")
public class UploadController extends BaseController<Upload, String>{

    @Autowired
    private UploadService uploadService;

    @Override
    public String getPathPrefix() {
        return "upload";
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
        ResultData<Upload> bookInfoResultData = uploadService.findWithPage(parameterMap, Upload.class);
        return bookInfoResultData;
    }

    /**
     * 查找所有书籍信息
     */
    @RequestMapping(value = "/getAll")
    @ResponseBody
    public Object getAll() {
        List<Upload> bookInfos = uploadService.findAll();
        return bookInfos;
    }
}