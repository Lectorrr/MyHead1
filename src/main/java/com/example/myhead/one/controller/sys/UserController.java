package com.example.myhead.one.controller.sys;

import com.example.myhead.one.base.BaseController;
import com.example.myhead.one.common.entity.ResultData;
import com.example.myhead.one.entity.sys.SysUser;
import com.example.myhead.one.service.sys.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping(value = "/sys/userManage")
public class UserController extends BaseController<SysUser, String> {

    @Autowired
    private SysUserService sysUserService;

    @Override
    public String getPathPrefix() {
        return "userManage";
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
        ResultData<SysUser> resultData = sysUserService.findWithPage(parameterMap, SysUser.class);
        return resultData;
    }

}
