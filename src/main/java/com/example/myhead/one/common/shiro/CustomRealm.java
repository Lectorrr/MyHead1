package com.example.myhead.one.common.shiro;

import com.example.myhead.one.entity.sys.SysPermission;
import com.example.myhead.one.entity.sys.SysUser;
import com.example.myhead.one.service.sys.SysUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义Realm用于查询用户的角色和权限信息并保存到权限管理器：
 * 继承 AuthorizingRealm 并且重写父类中的 doGetAuthorizationInfo（权限相关）、doGetAuthenticationInfo（身份认证）这两个方法。
 */
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 功能描述：授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        //获取登录用户名
        String name = (String) principalCollection.getPrimaryPrincipal();
        //根据用户名去数据库查询用户信息
        SysUser user = sysUserService.findSysUserByUsername(name);
        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//        for (SysRole role : user.getRole()) {

            //添加角色
            simpleAuthorizationInfo.addRole(user.getRole().getRoleName());
            //添加权限
            for (SysPermission permissions : user.getRole().getPermissions()) {
                simpleAuthorizationInfo.addStringPermission(permissions.getPermission());
            }
//        }
        return simpleAuthorizationInfo;
    }

    /**
     * 功能描述: 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //加这一步的目的是在Post请求的时候会先进认证，然后在到请求
        if (authenticationToken.getPrincipal() == null) {
            return null;
        }
        //获取用户信息
        String name = authenticationToken.getPrincipal().toString();
        SysUser user = sysUserService.findSysUserByUsername(name);
        if (user == null) {
            //这里返回后会报出对应异常
            return null;
        } else {
            //这里验证authenticationToken和simpleAuthenticationInfo的信息
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(name, user.getPassword().toString(), getName());
            return simpleAuthenticationInfo;
        }
    }




}
