package com.example.myhead.one.service.sys;

import com.example.myhead.one.base.BaseService;
import com.example.myhead.one.dto.sys.SysPermissionDTO;
import com.example.myhead.one.entity.sys.SysPermission;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysPermissionService extends BaseService<SysPermission, SysPermissionDTO, String> {

    @Autowired
    private SysRoleService sysRoleService;

    @Override
    public SysPermissionDTO toDTO(SysPermission entity) {
        SysPermissionDTO result = new SysPermissionDTO();
        if (entity != null) {
            if (entity.getRole() != null) {
                result.setRole(sysRoleService.toDTO(entity.getRole()));
            }
            BeanUtils.copyProperties(entity, result);
        }
        return result;
    }

    @Override
    public SysPermission toEntity(SysPermissionDTO dto) {
        SysPermission result = new SysPermission();
        if (dto != null) {
            if (dto.getRole() != null) {
                result.setRole(sysRoleService.toEntity(dto.getRole()));
            }
            BeanUtils.copyProperties(dto, result);
        }
        return result;
    }
}
