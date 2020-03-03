package com.example.myhead.one.controller.resource;

import com.example.myhead.one.base.BaseController;
import com.example.myhead.one.entity.resource.Files;
import com.example.myhead.one.service.resource.FilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/resource/files")
public class FilesController extends BaseController<Files, String> {

    @Autowired
    private FilesService filesService;
}
