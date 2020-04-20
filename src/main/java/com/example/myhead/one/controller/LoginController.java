package com.example.myhead.one.controller;

import com.example.myhead.one.service.sys.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/registered")
    public String registered(){
        return "registered";
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
