package com.example.myhead.one.dto.sys;

import com.example.myhead.one.base.BaseDTO;
import com.example.myhead.one.entity.sys.SysRole;

public class SysUserDTO extends BaseDTO<String> {

    /**
     * 帐号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 加密盐
     */
    private String salt;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 手机号码
     */
    private String telPhone;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 帐号状态：0-正常；1-锁定
     */
    private Integer status = 0;

    /**
     * 性别
     */
    private String sex;

    /**
     * 是否被删除: false-未删除， true-已删除
     */
    private Boolean is_deleted = false;

    /**
     * 用户和角色关联
     * 多对多的关系
     */
    private SysRoleDTO role;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Boolean getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(Boolean is_deleted) {
        this.is_deleted = is_deleted;
    }

    public SysRoleDTO getRole() {
        return role;
    }

    public void setRole(SysRoleDTO role) {
        this.role = role;
    }

    /**
     * 密码盐
     * 重新对盐进行定义，salt = 用户名 + salt
     */
    public String getCredentialsSalt() {
        return this.account + this.salt;
    }

    @Override
    public String toString() {
        return "SysUserDTO{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", nickname='" + nickname + '\'' +
                ", telPhone='" + telPhone + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", sex='" + sex + '\'' +
                ", is_deleted=" + is_deleted +
                ", role=" + role +
                '}';
    }
}
