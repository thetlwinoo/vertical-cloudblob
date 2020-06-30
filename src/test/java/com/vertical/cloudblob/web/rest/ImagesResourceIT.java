package com.vertical.cloudblob.web.rest;

import com.vertical.cloudblob.CloudblobApp;
import com.vertical.cloudblob.config.TestSecurityConfiguration;
import com.vertical.cloudblob.domain.Images;
import com.vertical.cloudblob.repository.ImagesRepository;
import com.vertical.cloudblob.service.ImagesService;
import com.vertical.cloudblob.service.dto.ImagesDTO;
import com.vertical.cloudblob.service.mapper.ImagesMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Base64Utils;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link ImagesResource} REST controller.
 */
@SpringBootTest(classes = { CloudblobApp.class, TestSecurityConfiguration.class })
@AutoConfigureMockMvc
@WithMockUser
public class ImagesResourceIT {

    private static final byte[] DEFAULT_THUMBNAIL = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_THUMBNAIL = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_THUMBNAIL_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_THUMBNAIL_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_ORIGINAL = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_ORIGINAL = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_ORIGINAL_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_ORIGINAL_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_BANNER_TALL = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_BANNER_TALL = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_BANNER_TALL_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_BANNER_TALL_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_BANNER_WIDE = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_BANNER_WIDE = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_BANNER_WIDE_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_BANNER_WIDE_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_CIRCLE = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_CIRCLE = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_CIRCLE_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_CIRCLE_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_SHARPENED = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_SHARPENED = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_SHARPENED_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_SHARPENED_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_SQUARE = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_SQUARE = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_SQUARE_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_SQUARE_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_WATERMARK = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_WATERMARK = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_WATERMARK_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_WATERMARK_CONTENT_TYPE = "image/png";

    private static final Long DEFAULT_REF_ID = 1L;
    private static final Long UPDATED_REF_ID = 2L;

    @Autowired
    private ImagesRepository imagesRepository;

    @Autowired
    private ImagesMapper imagesMapper;

    @Autowired
    private ImagesService imagesService;

    @Autowired
    private MockMvc restImagesMockMvc;

    private Images images;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Images createEntity() {
        Images images = new Images()
            .thumbnail(DEFAULT_THUMBNAIL)
            .thumbnailContentType(DEFAULT_THUMBNAIL_CONTENT_TYPE)
            .original(DEFAULT_ORIGINAL)
            .originalContentType(DEFAULT_ORIGINAL_CONTENT_TYPE)
            .bannerTall(DEFAULT_BANNER_TALL)
            .bannerTallContentType(DEFAULT_BANNER_TALL_CONTENT_TYPE)
            .bannerWide(DEFAULT_BANNER_WIDE)
            .bannerWideContentType(DEFAULT_BANNER_WIDE_CONTENT_TYPE)
            .circle(DEFAULT_CIRCLE)
            .circleContentType(DEFAULT_CIRCLE_CONTENT_TYPE)
            .sharpened(DEFAULT_SHARPENED)
            .sharpenedContentType(DEFAULT_SHARPENED_CONTENT_TYPE)
            .square(DEFAULT_SQUARE)
            .squareContentType(DEFAULT_SQUARE_CONTENT_TYPE)
            .watermark(DEFAULT_WATERMARK)
            .watermarkContentType(DEFAULT_WATERMARK_CONTENT_TYPE)
            .refId(DEFAULT_REF_ID);
        return images;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Images createUpdatedEntity() {
        Images images = new Images()
            .thumbnail(UPDATED_THUMBNAIL)
            .thumbnailContentType(UPDATED_THUMBNAIL_CONTENT_TYPE)
            .original(UPDATED_ORIGINAL)
            .originalContentType(UPDATED_ORIGINAL_CONTENT_TYPE)
            .bannerTall(UPDATED_BANNER_TALL)
            .bannerTallContentType(UPDATED_BANNER_TALL_CONTENT_TYPE)
            .bannerWide(UPDATED_BANNER_WIDE)
            .bannerWideContentType(UPDATED_BANNER_WIDE_CONTENT_TYPE)
            .circle(UPDATED_CIRCLE)
            .circleContentType(UPDATED_CIRCLE_CONTENT_TYPE)
            .sharpened(UPDATED_SHARPENED)
            .sharpenedContentType(UPDATED_SHARPENED_CONTENT_TYPE)
            .square(UPDATED_SQUARE)
            .squareContentType(UPDATED_SQUARE_CONTENT_TYPE)
            .watermark(UPDATED_WATERMARK)
            .watermarkContentType(UPDATED_WATERMARK_CONTENT_TYPE)
            .refId(UPDATED_REF_ID);
        return images;
    }

    @BeforeEach
    public void initTest() {
        imagesRepository.deleteAll();
        images = createEntity();
    }

    @Test
    public void createImages() throws Exception {
        int databaseSizeBeforeCreate = imagesRepository.findAll().size();
        // Create the Images
        ImagesDTO imagesDTO = imagesMapper.toDto(images);
        restImagesMockMvc.perform(post("/api/images").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(imagesDTO)))
            .andExpect(status().isCreated());

        // Validate the Images in the database
        List<Images> imagesList = imagesRepository.findAll();
        assertThat(imagesList).hasSize(databaseSizeBeforeCreate + 1);
        Images testImages = imagesList.get(imagesList.size() - 1);
        assertThat(testImages.getThumbnail()).isEqualTo(DEFAULT_THUMBNAIL);
        assertThat(testImages.getThumbnailContentType()).isEqualTo(DEFAULT_THUMBNAIL_CONTENT_TYPE);
        assertThat(testImages.getOriginal()).isEqualTo(DEFAULT_ORIGINAL);
        assertThat(testImages.getOriginalContentType()).isEqualTo(DEFAULT_ORIGINAL_CONTENT_TYPE);
        assertThat(testImages.getBannerTall()).isEqualTo(DEFAULT_BANNER_TALL);
        assertThat(testImages.getBannerTallContentType()).isEqualTo(DEFAULT_BANNER_TALL_CONTENT_TYPE);
        assertThat(testImages.getBannerWide()).isEqualTo(DEFAULT_BANNER_WIDE);
        assertThat(testImages.getBannerWideContentType()).isEqualTo(DEFAULT_BANNER_WIDE_CONTENT_TYPE);
        assertThat(testImages.getCircle()).isEqualTo(DEFAULT_CIRCLE);
        assertThat(testImages.getCircleContentType()).isEqualTo(DEFAULT_CIRCLE_CONTENT_TYPE);
        assertThat(testImages.getSharpened()).isEqualTo(DEFAULT_SHARPENED);
        assertThat(testImages.getSharpenedContentType()).isEqualTo(DEFAULT_SHARPENED_CONTENT_TYPE);
        assertThat(testImages.getSquare()).isEqualTo(DEFAULT_SQUARE);
        assertThat(testImages.getSquareContentType()).isEqualTo(DEFAULT_SQUARE_CONTENT_TYPE);
        assertThat(testImages.getWatermark()).isEqualTo(DEFAULT_WATERMARK);
        assertThat(testImages.getWatermarkContentType()).isEqualTo(DEFAULT_WATERMARK_CONTENT_TYPE);
        assertThat(testImages.getRefId()).isEqualTo(DEFAULT_REF_ID);
    }

    @Test
    public void createImagesWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = imagesRepository.findAll().size();

        // Create the Images with an existing ID
        images.setId("existing_id");
        ImagesDTO imagesDTO = imagesMapper.toDto(images);

        // An entity with an existing ID cannot be created, so this API call must fail
        restImagesMockMvc.perform(post("/api/images").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(imagesDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Images in the database
        List<Images> imagesList = imagesRepository.findAll();
        assertThat(imagesList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    public void getAllImages() throws Exception {
        // Initialize the database
        imagesRepository.save(images);

        // Get all the imagesList
        restImagesMockMvc.perform(get("/api/images?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(images.getId())))
            .andExpect(jsonPath("$.[*].thumbnailContentType").value(hasItem(DEFAULT_THUMBNAIL_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].thumbnail").value(hasItem(Base64Utils.encodeToString(DEFAULT_THUMBNAIL))))
            .andExpect(jsonPath("$.[*].originalContentType").value(hasItem(DEFAULT_ORIGINAL_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].original").value(hasItem(Base64Utils.encodeToString(DEFAULT_ORIGINAL))))
            .andExpect(jsonPath("$.[*].bannerTallContentType").value(hasItem(DEFAULT_BANNER_TALL_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].bannerTall").value(hasItem(Base64Utils.encodeToString(DEFAULT_BANNER_TALL))))
            .andExpect(jsonPath("$.[*].bannerWideContentType").value(hasItem(DEFAULT_BANNER_WIDE_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].bannerWide").value(hasItem(Base64Utils.encodeToString(DEFAULT_BANNER_WIDE))))
            .andExpect(jsonPath("$.[*].circleContentType").value(hasItem(DEFAULT_CIRCLE_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].circle").value(hasItem(Base64Utils.encodeToString(DEFAULT_CIRCLE))))
            .andExpect(jsonPath("$.[*].sharpenedContentType").value(hasItem(DEFAULT_SHARPENED_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].sharpened").value(hasItem(Base64Utils.encodeToString(DEFAULT_SHARPENED))))
            .andExpect(jsonPath("$.[*].squareContentType").value(hasItem(DEFAULT_SQUARE_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].square").value(hasItem(Base64Utils.encodeToString(DEFAULT_SQUARE))))
            .andExpect(jsonPath("$.[*].watermarkContentType").value(hasItem(DEFAULT_WATERMARK_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].watermark").value(hasItem(Base64Utils.encodeToString(DEFAULT_WATERMARK))))
            .andExpect(jsonPath("$.[*].refId").value(hasItem(DEFAULT_REF_ID.intValue())));
    }
    
    @Test
    public void getImages() throws Exception {
        // Initialize the database
        imagesRepository.save(images);

        // Get the images
        restImagesMockMvc.perform(get("/api/images/{id}", images.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(images.getId()))
            .andExpect(jsonPath("$.thumbnailContentType").value(DEFAULT_THUMBNAIL_CONTENT_TYPE))
            .andExpect(jsonPath("$.thumbnail").value(Base64Utils.encodeToString(DEFAULT_THUMBNAIL)))
            .andExpect(jsonPath("$.originalContentType").value(DEFAULT_ORIGINAL_CONTENT_TYPE))
            .andExpect(jsonPath("$.original").value(Base64Utils.encodeToString(DEFAULT_ORIGINAL)))
            .andExpect(jsonPath("$.bannerTallContentType").value(DEFAULT_BANNER_TALL_CONTENT_TYPE))
            .andExpect(jsonPath("$.bannerTall").value(Base64Utils.encodeToString(DEFAULT_BANNER_TALL)))
            .andExpect(jsonPath("$.bannerWideContentType").value(DEFAULT_BANNER_WIDE_CONTENT_TYPE))
            .andExpect(jsonPath("$.bannerWide").value(Base64Utils.encodeToString(DEFAULT_BANNER_WIDE)))
            .andExpect(jsonPath("$.circleContentType").value(DEFAULT_CIRCLE_CONTENT_TYPE))
            .andExpect(jsonPath("$.circle").value(Base64Utils.encodeToString(DEFAULT_CIRCLE)))
            .andExpect(jsonPath("$.sharpenedContentType").value(DEFAULT_SHARPENED_CONTENT_TYPE))
            .andExpect(jsonPath("$.sharpened").value(Base64Utils.encodeToString(DEFAULT_SHARPENED)))
            .andExpect(jsonPath("$.squareContentType").value(DEFAULT_SQUARE_CONTENT_TYPE))
            .andExpect(jsonPath("$.square").value(Base64Utils.encodeToString(DEFAULT_SQUARE)))
            .andExpect(jsonPath("$.watermarkContentType").value(DEFAULT_WATERMARK_CONTENT_TYPE))
            .andExpect(jsonPath("$.watermark").value(Base64Utils.encodeToString(DEFAULT_WATERMARK)))
            .andExpect(jsonPath("$.refId").value(DEFAULT_REF_ID.intValue()));
    }
    @Test
    public void getNonExistingImages() throws Exception {
        // Get the images
        restImagesMockMvc.perform(get("/api/images/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    public void updateImages() throws Exception {
        // Initialize the database
        imagesRepository.save(images);

        int databaseSizeBeforeUpdate = imagesRepository.findAll().size();

        // Update the images
        Images updatedImages = imagesRepository.findById(images.getId()).get();
        updatedImages
            .thumbnail(UPDATED_THUMBNAIL)
            .thumbnailContentType(UPDATED_THUMBNAIL_CONTENT_TYPE)
            .original(UPDATED_ORIGINAL)
            .originalContentType(UPDATED_ORIGINAL_CONTENT_TYPE)
            .bannerTall(UPDATED_BANNER_TALL)
            .bannerTallContentType(UPDATED_BANNER_TALL_CONTENT_TYPE)
            .bannerWide(UPDATED_BANNER_WIDE)
            .bannerWideContentType(UPDATED_BANNER_WIDE_CONTENT_TYPE)
            .circle(UPDATED_CIRCLE)
            .circleContentType(UPDATED_CIRCLE_CONTENT_TYPE)
            .sharpened(UPDATED_SHARPENED)
            .sharpenedContentType(UPDATED_SHARPENED_CONTENT_TYPE)
            .square(UPDATED_SQUARE)
            .squareContentType(UPDATED_SQUARE_CONTENT_TYPE)
            .watermark(UPDATED_WATERMARK)
            .watermarkContentType(UPDATED_WATERMARK_CONTENT_TYPE)
            .refId(UPDATED_REF_ID);
        ImagesDTO imagesDTO = imagesMapper.toDto(updatedImages);

        restImagesMockMvc.perform(put("/api/images").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(imagesDTO)))
            .andExpect(status().isOk());

        // Validate the Images in the database
        List<Images> imagesList = imagesRepository.findAll();
        assertThat(imagesList).hasSize(databaseSizeBeforeUpdate);
        Images testImages = imagesList.get(imagesList.size() - 1);
        assertThat(testImages.getThumbnail()).isEqualTo(UPDATED_THUMBNAIL);
        assertThat(testImages.getThumbnailContentType()).isEqualTo(UPDATED_THUMBNAIL_CONTENT_TYPE);
        assertThat(testImages.getOriginal()).isEqualTo(UPDATED_ORIGINAL);
        assertThat(testImages.getOriginalContentType()).isEqualTo(UPDATED_ORIGINAL_CONTENT_TYPE);
        assertThat(testImages.getBannerTall()).isEqualTo(UPDATED_BANNER_TALL);
        assertThat(testImages.getBannerTallContentType()).isEqualTo(UPDATED_BANNER_TALL_CONTENT_TYPE);
        assertThat(testImages.getBannerWide()).isEqualTo(UPDATED_BANNER_WIDE);
        assertThat(testImages.getBannerWideContentType()).isEqualTo(UPDATED_BANNER_WIDE_CONTENT_TYPE);
        assertThat(testImages.getCircle()).isEqualTo(UPDATED_CIRCLE);
        assertThat(testImages.getCircleContentType()).isEqualTo(UPDATED_CIRCLE_CONTENT_TYPE);
        assertThat(testImages.getSharpened()).isEqualTo(UPDATED_SHARPENED);
        assertThat(testImages.getSharpenedContentType()).isEqualTo(UPDATED_SHARPENED_CONTENT_TYPE);
        assertThat(testImages.getSquare()).isEqualTo(UPDATED_SQUARE);
        assertThat(testImages.getSquareContentType()).isEqualTo(UPDATED_SQUARE_CONTENT_TYPE);
        assertThat(testImages.getWatermark()).isEqualTo(UPDATED_WATERMARK);
        assertThat(testImages.getWatermarkContentType()).isEqualTo(UPDATED_WATERMARK_CONTENT_TYPE);
        assertThat(testImages.getRefId()).isEqualTo(UPDATED_REF_ID);
    }

    @Test
    public void updateNonExistingImages() throws Exception {
        int databaseSizeBeforeUpdate = imagesRepository.findAll().size();

        // Create the Images
        ImagesDTO imagesDTO = imagesMapper.toDto(images);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restImagesMockMvc.perform(put("/api/images").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(imagesDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Images in the database
        List<Images> imagesList = imagesRepository.findAll();
        assertThat(imagesList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    public void deleteImages() throws Exception {
        // Initialize the database
        imagesRepository.save(images);

        int databaseSizeBeforeDelete = imagesRepository.findAll().size();

        // Delete the images
        restImagesMockMvc.perform(delete("/api/images/{id}", images.getId()).with(csrf())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Images> imagesList = imagesRepository.findAll();
        assertThat(imagesList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
