package com.vertical.cloudblob.web.rest;

import com.vertical.cloudblob.CloudblobApp;
import com.vertical.cloudblob.config.TestSecurityConfiguration;
import com.vertical.cloudblob.service.ImagesExtendService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * Test class for the ImagesExtendResource REST controller.
 *
 * @see ImagesExtendResource
 */
@SpringBootTest(classes = {CloudblobApp.class, TestSecurityConfiguration.class})
public class ImagesExtendResourceIT {

    private MockMvc restMockMvc;
    private final ImagesExtendService imagesExtendService;

    public ImagesExtendResourceIT(ImagesExtendService imagesExtendService) {
        this.imagesExtendService = imagesExtendService;
    }

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        ImagesExtendResource imagesExtendResource = new ImagesExtendResource(imagesExtendService);
        restMockMvc = MockMvcBuilders
            .standaloneSetup(imagesExtendResource)
            .build();
    }

    /**
     * Test defaultAction
     */
    @Test
    public void testDefaultAction() throws Exception {
        restMockMvc.perform(get("/api/images-extend/default-action"))
            .andExpect(status().isOk());
    }
}
