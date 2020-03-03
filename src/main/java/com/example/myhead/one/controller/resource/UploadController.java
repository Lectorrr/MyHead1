package com.example.myhead.one.controller.resource;

import com.example.myhead.one.base.BaseController;
import com.example.myhead.one.entity.resource.Upload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/resource/upload")
public class UploadController extends BaseController<Upload, String>{
}
