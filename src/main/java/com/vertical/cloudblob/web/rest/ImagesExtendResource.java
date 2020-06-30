package com.vertical.cloudblob.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ImagesExtendResource controller
 */
@RestController
@RequestMapping("/api/images-extend")
public class ImagesExtendResource {

    private final Logger log = LoggerFactory.getLogger(ImagesExtendResource.class);

    /**
    * GET defaultAction
    */
    @GetMapping("/default-action")
    public String defaultAction() {
        return "defaultAction";
    }

}
