package com.vertical.cloudblob.service;

import com.vertical.cloudblob.service.dto.ImagesDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;

public interface ImagesExtendService {
    Optional<ImagesDTO> findOne(String id);

    ImagesDTO save(ImagesDTO imagesDTO);

    Map<String, Object> upload(ImagesDTO imagesDTO,String fileName);

    ByteArrayOutputStream createThumbnail(MultipartFile orginalFile, Integer width) throws IOException;
}
