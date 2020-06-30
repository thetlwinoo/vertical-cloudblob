package com.vertical.cloudblob.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ImagesMapperTest {

    private ImagesMapper imagesMapper;

    @BeforeEach
    public void setUp() {
        imagesMapper = new ImagesMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        String id = "id1";
        assertThat(imagesMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(imagesMapper.fromId(null)).isNull();
    }
}
