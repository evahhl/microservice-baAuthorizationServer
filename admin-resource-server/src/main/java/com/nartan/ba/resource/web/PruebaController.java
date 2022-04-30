package com.nartan.ba.resource.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

@RestController
@RequestMapping(value = "/test")
public class PruebaController {

    private static final Logger logger = LoggerFactory.getLogger(PruebaController.class);

    @GetMapping
    public String find() {
        logger.info("Foo created");

        return "Hola";
    }
}
