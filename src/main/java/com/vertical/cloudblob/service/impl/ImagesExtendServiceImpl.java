package com.vertical.cloudblob.service.impl;

import com.vertical.cloudblob.domain.Images;
import com.vertical.cloudblob.repository.ImagesRepository;
import com.vertical.cloudblob.service.ImagesExtendService;
import com.vertical.cloudblob.service.dto.ImagesDTO;
import com.vertical.cloudblob.service.mapper.ImagesMapper;
import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ImagesExtendServiceImpl implements ImagesExtendService {

    private final Logger log = LoggerFactory.getLogger(ImagesExtendServiceImpl.class);
    private final ImagesRepository imagesRepository;

    private final ImagesMapper imagesMapper;

    public ImagesExtendServiceImpl(ImagesRepository imagesRepository, ImagesMapper imagesMapper) {
        this.imagesRepository = imagesRepository;
        this.imagesMapper = imagesMapper;
    }

    @Override
    public Optional<ImagesDTO> findOne(String id) {
        log.debug("Request to get Images : {}", id);
        return imagesRepository.findById(id)
            .map(imagesMapper::toDto);
    }

    @Override
    public ImagesDTO save(ImagesDTO imagesDTO) {
        log.debug("Request to save Images : {}", imagesDTO);
        Images images = imagesMapper.toEntity(imagesDTO);
        images = imagesRepository.save(images);
        return imagesMapper.toDto(images);
    }

    @Override
    public Map<String, Object> upload(ImagesDTO imagesDTO, String fileName) {
        log.debug("Request to save Images : {}", imagesDTO);
        Images images = imagesMapper.toEntity(imagesDTO);
        images = imagesRepository.save(images);

        Map<String, Object> response = new HashMap<String, Object>();
//        System.out.println(file.getResource());
        response.put("name",fileName);
        response.put("id",images.getId());
        response.put("status","done");
        response.put("thumbUrl",images.getId() + "/thumbnail");
        response.put("url",images.getId() + "/original");

        return response;
    }

    @Override
    public ByteArrayOutputStream createThumbnail(MultipartFile orginalFile, Integer width) throws IOException {
        ByteArrayOutputStream thumbOutput = new ByteArrayOutputStream();
        BufferedImage thumbImg = null;
        BufferedImage img = ImageIO.read(orginalFile.getInputStream());
        thumbImg = Scalr.resize(img, Scalr.Method.AUTOMATIC, Scalr.Mode.AUTOMATIC, width, Scalr.OP_ANTIALIAS);
        ImageIO.write(thumbImg, orginalFile.getContentType().split("/")[1] , thumbOutput);
        return thumbOutput;
    }
}
