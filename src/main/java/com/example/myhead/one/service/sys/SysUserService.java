package com.example.myhead.one.service.sys;

import com.example.myhead.one.base.BaseService;
import com.example.myhead.one.dao.sys.SysUserDao;
import com.example.myhead.one.dto.sys.SysUserDTO;
import com.example.myhead.one.entity.sys.SysUser;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.persistence.criteria.*;
import java.util.List;

@Service
public class SysUserService extends BaseService<SysUser, SysUserDTO, String> {

    @Autowired
    private SysUserDao sysUserDao;

    @Autowired
    private SysRoleService sysRoleService;

    @Override
    public SysUserDTO toDTO(SysUser entity) {
        SysUserDTO result = new SysUserDTO();
        if (entity != null) {
            if (entity.getRole() != null){
                result.setRole(sysRoleService.toDTO(entity.getRole()));
            }
            BeanUtils.copyProperties(entity, result);
        }
        return result;
    }

    @Override
    public SysUser toEntity(SysUserDTO dto) {
        SysUser result = new SysUser();
        if (dto != null) {
            if (dto.getRole() != null){
                result.setRole(sysRoleService.toEntity(dto.getRole()));
            }
            BeanUtils.copyProperties(dto, result);
        }
        return result;
    }

    /**
     * 根据用户名查用户信息
     *
     * @param username 用户名
     */
    public SysUser findSysUserByUsername(String username) {
        return sysUserDao.findSysUserByUsername(username);
    }

    /**
     * 根据用户名和密码获取用户信息
     *
     * @param username 用户名
     * @param password 密码
     */
    public SysUser findSysUserByUsernameAndPassword(String username, String password) {
        return sysUserDao.findSysUserByUsernameAndPassword(username, password);
    }

    /**
     * 根据用户名判断用户是否存在
     *
     * @param username 用户名
     *                 return -true 存在该用户 -false 不存在该用户
     */
    public boolean isExist(String username) {
        SysUser user = sysUserDao.getSysUserByUsername(username);
        return null != user;
    }

    public SysUser findUserByUser(String account, String password) {

        Specification<SysUser> specification = new Specification<SysUser>() {

            @Override
            public Predicate toPredicate(Root<SysUser> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                Path<String> tAccount = root.get("account");
                Predicate predicateAccount = criteriaBuilder.equal(tAccount, account);

                Path<String> tPassword = root.get("password");
                Predicate predicatePassword = criteriaBuilder.equal(tPassword, password);

                return criteriaBuilder.and(predicateAccount, predicatePassword);
            }
        };
        List<SysUser> all = this.sysUserDao.findAll(specification);

        return CollectionUtils.isEmpty(all) ? null : all.get(0);
    }
}
