package com.vertical.cloudblob.web.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vertical.cloudblob.domain.Images;
import com.vertical.cloudblob.service.ImagesExtendService;
import com.vertical.cloudblob.service.dto.ImagesDTO;
import com.vertical.cloudblob.web.rest.errors.BadRequestAlertException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * ImagesExtendResource controller
 */
@RestController
@RequestMapping("/api")
public class ImagesExtendResource {

    private final Logger log = LoggerFactory.getLogger(ImagesExtendResource.class);
    private final ImagesExtendService imagesExtendService;
    private static final String ENTITY_NAME = "cloudblobImages";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    public ImagesExtendResource(ImagesExtendService imagesExtendService) {
        this.imagesExtendService = imagesExtendService;
    }

    @PostMapping("/images-extend/upload")
    public ResponseEntity createUpload(@RequestBody MultipartFile file) throws URISyntaxException {
        if (file == null) {
            throw new BadRequestAlertException("No File to upload", ENTITY_NAME, "No File Exist");
        }

        try {
            ImagesDTO image = new ImagesDTO();
            image.setOriginal(file.getBytes());
            image.setOriginalContentType(file.getContentType());

            if( !file.getContentType().toString().equals("image/svg+xml")){
                ByteArrayOutputStream thumbnail = imagesExtendService.createThumbnail(file,200);
                image.setThumbnail(thumbnail.toByteArray());
                image.setThumbnailContentType("image/png");
            }
            else{
                image.setThumbnail(file.getBytes());
                image.setThumbnailContentType(file.getContentType());
            }


            Map<String, Object> response = imagesExtendService.upload(image, file.getOriginalFilename());

            return ResponseEntity.ok().body(response);
        }
        catch(Exception ex){
            throw new BadRequestAlertException(ex.getMessage(), ENTITY_NAME, "Error");
        }
    }

    @PostMapping("/images-extend/upload/{id}")
    public ResponseEntity updateUpload(@RequestBody MultipartFile file, @PathVariable String id) throws URISyntaxException {
        if (file == null) {
            throw new BadRequestAlertException("No File to upload", ENTITY_NAME, "No File Exist");
        }

        try {
            ImagesDTO image = new ImagesDTO();
            image.setId(id);
            image.setOriginal(file.getBytes());
            image.setOriginalContentType(file.getContentType());

            if( !file.getContentType().toString().equals("image/svg+xml")){
                ByteArrayOutputStream thumbnail = imagesExtendService.createThumbnail(file,200);
                image.setThumbnail(thumbnail.toByteArray());
                image.setThumbnailContentType("image/png");
            }
            else{
                image.setThumbnail(file.getBytes());
                image.setOriginalContentType(file.getContentType());
            }

            Map<String, Object> response = imagesExtendService.upload(image, file.getOriginalFilename());

            return ResponseEntity.ok().body(response);
        }
        catch(Exception ex){
            throw new BadRequestAlertException(ex.getMessage(), ENTITY_NAME, "Error");
        }
    }

    @GetMapping("/images-extend/{id}/{handle}")
    public ResponseEntity<byte[]> getImages(@PathVariable String id, @PathVariable String handle) {
        Optional<ImagesDTO> imagesDTO = imagesExtendService.findOne(id);
        byte[] photo;
        HttpHeaders header = new HttpHeaders();

        switch (handle) {
            case "thumbnail":
                header.setContentType(MediaType.valueOf(imagesDTO.get().getThumbnailContentType()));
                header.setContentLength(imagesDTO.get().getThumbnail().length);
                photo = imagesDTO.get().getThumbnail();
                break;
            case "original":
                header.setContentType(MediaType.valueOf(imagesDTO.get().getOriginalContentType()));
                header.setContentLength(imagesDTO.get().getOriginal().length);
                photo = imagesDTO.get().getOriginal();
                break;
            default:
                header.setContentType(MediaType.valueOf(imagesDTO.get().getThumbnailContentType()));
                header.setContentLength(imagesDTO.get().getThumbnail().length);
                photo = imagesDTO.get().getThumbnail();
        }

        return new ResponseEntity<>(photo, header, HttpStatus.OK);
    }
}
