package com.example.myhead.one.controller.sys;

import com.example.myhead.one.base.BaseController;
import com.example.myhead.one.entity.sys.SysRole;
import com.example.myhead.one.entity.sys.SysUser;
import com.example.myhead.one.service.sys.SysRoleService;
import com.example.myhead.one.service.sys.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/sys/userManage")
public class SysUserController extends BaseController<SysUser, String> {

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
     * @param request http请求
     * @param page 前端界面中第几页
     * @param limit 每一页多少数据
     * @return
     */
    @RequestMapping(value = "/listData", method = RequestMethod.GET)
    @ResponseBody
    public Object listData(HttpServletRequest request, int page, int limit) {

//        Map<String, String[]> parameterMap = request.getParameterMap();
//        ResultData<SysUser> resultData = sysUserService.findWithPage(parameterMap, SysUser.class);
//        return JSON.toJSONString(resultData);

//        TablePage<SysUser> table = new TablePage<>();
//        table.setRows(sysUserService.findAll());
        Map<String, Object> data = new HashMap<>();
        data.put("data", sysUserService.findAll());
        return data;
    }

    /**
     * 保存
     * 若 sysUser 实体的 id 不存在，新建
     * 否则 直接保存实体 更新数据
     * @param sysUser
     * @return
     */
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> saveOrUpdate(@RequestBody SysUser sysUser){

        Map<String, Object> data = new HashMap<>();

        if (StringUtils.isEmpty(sysUser.getId())){
            if (sysUserService.isExist(sysUser.getAccount())){
                data.put("message", "该用户名已被占用");
            } else {
                SysRole sysRole = sysRoleService.get(sysUser.getRole().getId());
                sysUser.setRole(sysRole);
                sysUserService.saveOrUpdate(sysUser);
                data.put("message", "创建成功");
            }
        } else {
            SysRole sysRole = sysRoleService.get(sysUser.getRole().getId());
            sysUser.setRole(sysRole);
            sysUserService.saveOrUpdate(sysUser);
            data.put("message", "更新成功");
        }

        return data;
    }

    @Override
    public String doShowUpdatePage(SysUser entity, Model model) {

        model.addAttribute("role", sysRoleService.findAll());
        return super.doShowUpdatePage(entity, model);
    }
}
