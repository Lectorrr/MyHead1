package com.example.myhead.one.service.resource;

import com.example.myhead.one.base.BaseService;
import com.example.myhead.one.dto.resource.FilesDTO;
import com.example.myhead.one.entity.resource.Files;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class FilesService extends BaseService<Files, FilesDTO, String> {
    @Override
    public FilesDTO toDTO(Files entity) {

        FilesDTO result = new FilesDTO();
        if (entity != null) {
            BeanUtils.copyProperties(entity, result);
        }
        return result;

    }

    @Override
    public Files toEntity(FilesDTO dto) {
        Files result = new Files();
        if (dto != null) {
            BeanUtils.copyProperties(dto, result);
        }
        return result;
    }

}
