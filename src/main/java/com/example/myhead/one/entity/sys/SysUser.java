package com.example.myhead.one.entity.sys;

import com.example.myhead.one.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sys_user")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer", "password"})
public class SysUser extends BaseEntity<String> {

    /**
     * 帐号
     */
    @Column(name = "account")
    private String account;

    /**
     * 密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 加密盐
     */
    @Column(name = "salt")
    private String salt;

    /**
     * 昵称
     */
    @Column(name = "nickname")
    private String nickname;

    /**
     * 手机号码
     */
    @Column(name = "tel_Phone")
    private String telPhone;

    /**
     * 电子邮箱
     */
    @Column(name = "email")
    private String email;

    /**
     * 帐号状态：0-正常；1-锁定
     */
    @Column(name = "status")
    private Integer status = 0;

    /**
     * 性别
     */
    @Column(name = "sex")
    private String sex;

    /**
     * 是否被删除: false-未删除， true-已删除
     */
    @Column(name = "is_deleted")
    private Boolean is_deleted = false;

    /**
     * 上次登录时间
     */
//    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_login_date_time")
    private Date lastLoginDateTime;

    /**
     * 用户和角色关联
     * 多对多的关系
     */
    @ManyToOne
    @JoinTable(
            name = "sys_user_role",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "uuid")},             //sys_user表中的id在这个表中喂USER_ID
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "uuid")}       //sys_role表中的id在sys_user_role表中喂ROLE_ID
    )
    private SysRole role;

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

    public SysRole getRole() {
        return role;
    }

    public void setRole(SysRole role) {
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
        return "SysUser{" +
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
