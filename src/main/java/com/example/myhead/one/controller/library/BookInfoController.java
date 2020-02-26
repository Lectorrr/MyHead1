package com.example.myhead.one.controller.library;

import com.example.myhead.one.base.BaseController;
import com.example.myhead.one.common.entity.ResultData;
import com.example.myhead.one.entity.library.BookInfo;
import com.example.myhead.one.entity.library.Category;
import com.example.myhead.one.service.library.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/library/bookInfo")
public class BookInfoController extends BaseController<BookInfo, String> {

    @Autowired
    private BookInfoService bookInfoService;

    @Override
    public String getPathPrefix() {
        return "bookInfo";
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
        ResultData<BookInfo> bookInfoResultData = bookInfoService.findWithPage(parameterMap, BookInfo.class);
        return bookInfoResultData;
    }

    /**
     * 查找所有书籍信息
     */
    @RequestMapping(value = "/getAll")
    @ResponseBody
    public Object getAll() {
        List<BookInfo> bookInfos = bookInfoService.findAll();
        return bookInfos;
    }

    @RequestMapping(value = "/getByCategory")
    @ResponseBody
    public Object getByCategory(HttpServletRequest request, Category category) {
        List<BookInfo> bookInfos = bookInfoService.findAllByCategory(category);
        return bookInfos;
    }
}
