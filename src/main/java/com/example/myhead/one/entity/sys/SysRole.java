package com.example.myhead.one.entity.sys;

import com.example.myhead.one.base.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sys_role")
public class SysRole extends BaseEntity<String> {

    /**
     * 角色名称
     */
    @Column(name = "role_name")
    private String roleName;

    /**
     * 是否删除:-1-已删除；0-正常
     */
    @Column(name = "del_flag")
    private Integer delFlag = 0;

    /**
     * 是否被删除: false-未删除， true-已删除
     */
    @Column(name = "is_deleted")
    private Boolean is_deleted = false;

    /**
     * 角色和权限关联
     * 多对多的关系
     */
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "sys_role_permission",
            joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "uuid")},
            inverseJoinColumns = {@JoinColumn(name = "permission_id", referencedColumnName = "uuid")}
    )
    private List<SysPermission> permissions;

    /**
     * 角色和用户关联
     * 多对多的关系
     */
    @OneToMany
    @JoinTable(
            name = "sys_user_role",
            joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "uuid")},
            inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "uuid")},
            uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "role_id"})}
    )
    private List<SysUser> users;

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

    public List<SysPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SysPermission> permissions) {
        this.permissions = permissions;
    }

    public List<SysUser> getUsers() {
        return users;
    }

    public void setUsers(List<SysUser> users) {
        this.users = users;
    }
}
