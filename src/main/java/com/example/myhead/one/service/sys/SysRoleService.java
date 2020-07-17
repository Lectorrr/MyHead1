package com.example.myhead.one.service.sys;

import com.example.myhead.one.base.BaseService;
import com.example.myhead.one.dto.sys.SysPermissionDTO;
import com.example.myhead.one.dto.sys.SysRoleDTO;
import com.example.myhead.one.dto.sys.SysUserDTO;
import com.example.myhead.one.entity.sys.SysPermission;
import com.example.myhead.one.entity.sys.SysRole;
import com.example.myhead.one.entity.sys.SysUser;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysRoleService extends BaseService<SysRole, SysRoleDTO, String> {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysPermissionService sysPermissionService;

    @Override
    public SysRoleDTO toDTO(SysRole entity) {
        SysRoleDTO result = new SysRoleDTO();
        if (entity != null) {
            if (entity.getUsers() != null) {
                List<SysUserDTO> sysUserDTOList = new ArrayList<>();
                for (SysUser sysUser : entity.getUsers()) {
                    SysUserDTO sysUserDTO = new SysUserDTO();
                    sysUserDTO = sysUserService.toDTO(sysUser);
                    sysUserDTOList.add(sysUserDTO);
                }
                result.setUsers(sysUserDTOList);
            }

            if (entity.getPermissions() != null) {
                List<SysPermissionDTO> sysPermissionDTOList = new ArrayList<>();
                for (SysPermission sysPermission : entity.getPermissions()) {
                    SysPermissionDTO sysPermissionDTO = new SysPermissionDTO();
                    sysPermissionDTO = sysPermissionService.toDTO(sysPermission);
                    sysPermissionDTOList.add(sysPermissionDTO);
                }
                result.setPermissions(sysPermissionDTOList);
            }

            BeanUtils.copyProperties(entity, result);
        }
        return result;
    }

    @Override
    public SysRole toEntity(SysRoleDTO dto) {
        SysRole result = new SysRole();
        if (dto != null) {

            if (dto.getUsers() != null) {
                List<SysUser> sysUserList = new ArrayList<>();
                for (SysUserDTO sysUserDTO : dto.getUsers()) {
                    SysUser sysUser = new SysUser();
                    sysUser = sysUserService.toEntity(sysUserDTO);
                    sysUserList.add(sysUser);
                }
                result.setUsers(sysUserList);
            }

            if (dto.getPermissions() != null) {
                List<SysPermission> sysPermissionList = new ArrayList<>();
                for (SysPermissionDTO sysPermissionDTO : dto.getPermissions()) {
                    SysPermission sysPermission = new SysPermission();
                    sysPermission = sysPermissionService.toEntity(sysPermissionDTO);
                    sysPermissionList.add(sysPermission);
                }
                result.setPermissions(sysPermissionList);
            }

            BeanUtils.copyProperties(dto, result);
        }
        return result;
    }
}
