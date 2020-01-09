package com.example.myhead.one.controller.api.bookInfo;


import com.example.myhead.one.base.BaseController;
import com.example.myhead.one.entity.bookInfo.BookInfo;
import com.example.myhead.one.service.bookInfo.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;

//@Controller
//@RequestMapping(value = "/api/bookInfo")
public class ApiBookInfoController extends BaseController<BookInfo, String> {

    @Autowired
    private BookInfoService bookInfoService;

//    @Override
//    public String getPathPrefix() {
//        return "/bookInfo";
//    }

}
