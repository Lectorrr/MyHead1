package com.example.myhead.one.dto.sys;

import com.example.myhead.one.base.BaseDTO;

public class SysPermissionDTO extends BaseDTO<String> {

    /**
     * 权限
     */
    private String permission;

    /**
     * 资源路径
     */
    private String resourceUrl;

    /**
     * 资源类型，[menu | button]
     */
    private String resourceType;

    /**
     * 权限和角色的关系
     * 多对一的关系
     */
    private SysRoleDTO role;

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public SysRoleDTO getRole() {
        return role;
    }

    public void setRole(SysRoleDTO role) {
        this.role = role;
    }
}
