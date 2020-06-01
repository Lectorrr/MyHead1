package com.example.myhead.one.controller;

import com.example.myhead.one.entity.sys.SysPermission;
import com.example.myhead.one.entity.sys.SysRole;
import com.example.myhead.one.entity.sys.SysUser;
import com.example.myhead.one.service.sys.SysPermissionService;
import com.example.myhead.one.service.sys.SysRoleService;
import com.example.myhead.one.service.sys.SysUserService;

import java.util.*;

public class test {
    public static void main(String[] args) {


        SysUserService sysUserService = null;
        SysRoleService sysRoleService = null;
        SysPermissionService sysPermissionService = null;

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


        new SysPermissionService().saveOrUpdate(permissions1);
        new SysPermissionService().saveOrUpdate(permissions2);
        new SysPermissionService().saveOrUpdate(permissions3);

        new SysRoleService().saveOrUpdate(role);
        new SysRoleService().saveOrUpdate(role1);

        new SysUserService().saveOrUpdate(user);
        new SysUserService().saveOrUpdate(user1);





    }
}
