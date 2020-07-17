package com.example.myhead.one.dto.sys;

import com.example.myhead.one.base.BaseDTO;

import java.util.List;

public class SysRoleDTO extends BaseDTO<String> {

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 是否删除:-1-已删除；0-正常
     */
    private Integer delFlag = 0;

    /**
     * 是否被删除: false-未删除， true-已删除
     */
    private Boolean is_deleted = false;

    /**
     * 角色和权限关联
     * 多对多的关系
     */
    private List<SysPermissionDTO> permissions;

    /**
     * 角色和用户关联
     * 多对多的关系
     */
    private List<SysUserDTO> users;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Boolean getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(Boolean is_deleted) {
        this.is_deleted = is_deleted;
    }

    public List<SysPermissionDTO> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SysPermissionDTO> permissions) {
        this.permissions = permissions;
    }

    public List<SysUserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<SysUserDTO> users) {
        this.users = users;
    }
}
