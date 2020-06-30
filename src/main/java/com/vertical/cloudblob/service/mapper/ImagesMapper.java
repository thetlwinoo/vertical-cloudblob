package com.vertical.cloudblob.service.mapper;


import com.vertical.cloudblob.domain.*;
import com.vertical.cloudblob.service.dto.ImagesDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Images} and its DTO {@link ImagesDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ImagesMapper extends EntityMapper<ImagesDTO, Images> {



    default Images fromId(String id) {
        if (id == null) {
            return null;
        }
        Images images = new Images();
        images.setId(id);
        return images;
    }
}
