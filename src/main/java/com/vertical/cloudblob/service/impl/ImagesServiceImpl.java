package com.vertical.cloudblob.service.impl;

import com.vertical.cloudblob.service.ImagesService;
import com.vertical.cloudblob.domain.Images;
import com.vertical.cloudblob.repository.ImagesRepository;
import com.vertical.cloudblob.service.dto.ImagesDTO;
import com.vertical.cloudblob.service.mapper.ImagesMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link Images}.
 */
@Service
public class ImagesServiceImpl implements ImagesService {

    private final Logger log = LoggerFactory.getLogger(ImagesServiceImpl.class);

    private final ImagesRepository imagesRepository;

    private final ImagesMapper imagesMapper;

    public ImagesServiceImpl(ImagesRepository imagesRepository, ImagesMapper imagesMapper) {
        this.imagesRepository = imagesRepository;
        this.imagesMapper = imagesMapper;
    }

    /**
     * Save a images.
     *
     * @param imagesDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public ImagesDTO save(ImagesDTO imagesDTO) {
        log.debug("Request to save Images : {}", imagesDTO);
        Images images = imagesMapper.toEntity(imagesDTO);
        images = imagesRepository.save(images);
        return imagesMapper.toDto(images);
    }

    /**
     * Get all the images.
     *
     * @return the list of entities.
     */
    @Override
    public List<ImagesDTO> findAll() {
        log.debug("Request to get all Images");
        return imagesRepository.findAll().stream()
            .map(imagesMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one images by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    public Optional<ImagesDTO> findOne(String id) {
        log.debug("Request to get Images : {}", id);
        return imagesRepository.findById(id)
            .map(imagesMapper::toDto);
    }

    /**
     * Delete the images by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(String id) {
        log.debug("Request to delete Images : {}", id);

        imagesRepository.deleteById(id);
    }
}
