package com.etel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/me")
    public String me(){
        logger.info("Executed me()");
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        return name;
    }
}
