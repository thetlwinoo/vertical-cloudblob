package com.vertical.cloudblob.service;

import com.vertical.cloudblob.service.dto.ImagesDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.vertical.cloudblob.domain.Images}.
 */
public interface ImagesService {

    /**
     * Save a images.
     *
     * @param imagesDTO the entity to save.
     * @return the persisted entity.
     */
    ImagesDTO save(ImagesDTO imagesDTO);

    /**
     * Get all the images.
     *
     * @return the list of entities.
     */
    List<ImagesDTO> findAll();


    /**
     * Get the "id" images.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ImagesDTO> findOne(String id);

    /**
     * Delete the "id" images.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
