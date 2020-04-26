package com.example.myhead.one.controller;

import com.example.myhead.one.entity.sys.SysPermission;
import com.example.myhead.one.entity.sys.SysRole;
import com.example.myhead.one.entity.sys.SysUser;
import com.example.myhead.one.service.sys.SysPermissionService;
import com.example.myhead.one.service.sys.SysRoleService;
import com.example.myhead.one.service.sys.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class LoginController {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysPermissionService sysPermissionService;

    @RequiresRoles(value = "admin")
    @RequiresPermissions(value = "add")
    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/registered")
    public String registered() {
        return "registered";
    }

    /**
     * 验证登录
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map<String, Object> loginConfirm(HttpServletRequest request) {

        Map<String, Object> data = new HashMap<>();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        SysUser sysUser = sysUserService.findSysUserByUsernameAndPassword(username, password);

        if (!sysUserService.isExist(username)) {
            data.put("message", "用户不存在");
        } else if (sysUser == null) {
            data.put("message", "用户名或者密码错误");
        }

        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            //进行验证，这里可以捕获异常，然后返回对应信息
            subject.login(token);
//            subject.checkRole("admin");
//            subject.checkPermissions("query", "add");
        } catch (UnknownAccountException uae) {
            data.put("message", "未知账户");
        } catch (IncorrectCredentialsException ice) {
            data.put("message", "密码不正确");
        } catch (LockedAccountException lae) {
            data.put("message", "账户已锁定");
        } catch (ExcessiveAttemptsException eae) {
            data.put("message", "用户名或密码错误次数过多");
        } catch (AuthenticationException ae) {
            data.put("message", "用户名或密码不正确");
        }

        if (subject.isAuthenticated()) {
            data.put("code", 200);
            data.put("message", "登录成功");
        } else {
            token.clear();
            data.put("message", "登录失败");
        }

        return data;
    }

    /**
     * 验证登录
     */
    @RequestMapping(value = "/test")
    public void test() {

        //共添加两个用户，两个用户都是admin一个角色，
        //wsl有query和add权限，zhangsan只有一个query权限   "1","query"
        SysPermission permissions1 = new SysPermission();
        permissions1.setId("1");
        permissions1.setPermission("query");
        SysPermission permissions2 = new SysPermission();
        permissions2.setId("2");
        permissions2.setPermission("add");
        List<SysPermission> permissionsSet = new ArrayList<>();
        permissionsSet.add(permissions1);
        permissionsSet.add(permissions2);
        SysRole role = new SysRole();
        role.setId("1");
        role.setRoleName("admin");
        role.setPermissions(permissionsSet);
        Set<SysRole> roleSet = new HashSet<>();
        roleSet.add(role);
        SysUser user = new SysUser();
        user.setId("1");
        user.setUsername("system");
        user.setPassword("system");
        user.setRole(role);
        Map<String ,SysUser> map = new HashMap<>();
        map.put(user.getUsername(), user);

        SysPermission permissions3 = new SysPermission();
        permissions3.setId("3");
        permissions3.setPermission("query");
        List<SysPermission> permissionsSet1 = new ArrayList<>();
        permissionsSet1.add(permissions3);
        SysRole role1 = new SysRole();
        role1.setId("2");
        role1.setRoleName("user");
        role1.setPermissions(permissionsSet1);

        Set<SysRole> roleSet1 = new HashSet<>();
        roleSet1.add(role1);
        SysUser user1 = new SysUser();
        user1.setId("2");
        user1.setUsername("user");
        user1.setPassword("user");
        user1.setRole(role1);

        List<SysPermission> permission = new ArrayList<>();
        permission.add(sysPermissionService.saveOrUpdate(permissions1));
        permission.add(sysPermissionService.saveOrUpdate(permissions2));
        role.setPermissions(permission);
        user.setRole(sysRoleService.saveOrUpdate(role));
        sysUserService.saveOrUpdate(user);

        List<SysPermission> permission1 = new ArrayList<>();
        permission1.add(sysPermissionService.saveOrUpdate(permissions3));
        role1.setPermissions(permission1);
        user1.setRole(sysRoleService.saveOrUpdate(role1));
        sysUserService.saveOrUpdate(user1);

    }


//    /**
//     * 验证登陆
//     * @return
//     */
//    @PostMapping("login.dd")
//    @ResponseBody
//    public AjaxResult login(HttpServletRequest request){
//        AjaxResult ajaxResult=new AjaxResult();
//        ajaxResult.setState(true);
//        String loginName=request.getParameter("loginName");
//        String passWord=request.getParameter("passWord");
//        //密码加密
//        passWord=encodePassword(passWord);
//
//        Example example=new Example(UserEntity.class);
//        Example.Criteria criteria = example.createCriteria();
//        criteria.andEqualTo("loginName",loginName);
//        criteria.andEqualTo("delFlag","0");
//        List<UserEntity> back = userService.findList(example,null);
//        if(back==null||back.size()<=0){
//            ajaxResult.setState(false);
//            ajaxResult.setMessage("账号或密码错误");
//        }else if(!passWord.equals(back.get(0).getPassWord())){
//            ajaxResult.setState(false);
//            ajaxResult.setMessage("账号或密码错误");
//        }else{
//            System.out.println("登录成功");
//        }
//        return ajaxResult;
//    }
}
