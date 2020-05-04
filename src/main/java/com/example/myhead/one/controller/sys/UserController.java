package com.example.myhead.one.controller.sys;

import com.alibaba.fastjson.JSON;
import com.example.myhead.one.base.BaseController;
import com.example.myhead.one.common.entity.ResultData;
import com.example.myhead.one.entity.sys.SysUser;
import com.example.myhead.one.service.sys.SysRoleService;
import com.example.myhead.one.service.sys.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/sys/userManage")
public class UserController extends BaseController<SysUser, String> {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleService sysRoleService;

    @Override
    public String getPathPrefix() {
        return "userManage";
    }

    @Override
    public String showCreatePage(Model model) {
        model.addAttribute("role", sysRoleService.findAll());
        return super.showCreatePage(model);
    }

    /**
     * showList界面的数据
     * 包含分页查询
     *
     * @param request http请求
     */
    @RequestMapping(value = "/listData", method = RequestMethod.GET)
    @ResponseBody
    public String listData(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        ResultData<SysUser> resultData = sysUserService.findWithPage(parameterMap, SysUser.class);
        return JSON.toJSONString(resultData);
    }

    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> saveOrUpdate(@RequestBody SysUser sysUser){

        Map<String, Object> data = new HashMap<>();
        if (sysUserService.isExist(sysUser.getUsername())){
            data.put("message", "该用户名已被占用");
        } else if (sysUser.getUsername() == null){
            data.put("message", "请输入用户名");
        }else {
            sysUserService.saveOrUpdate(sysUser);
            data.put("message", "创建成功");
        }

        return data;
    }

}
