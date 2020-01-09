package com.example.myhead.one.dao.sys;

import com.example.myhead.one.base.BaseDao;
import com.example.myhead.one.entity.sys.SysUser;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserDao extends BaseDao<SysUser, String> {

    SysUser findByUsername(String username);
    SysUser findByUsernameAndPassword(String username, String password);
    SysUser getByUsername(String username);
}
