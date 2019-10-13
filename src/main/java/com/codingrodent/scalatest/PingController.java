package com.codingrodent.scalatest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    private final MessageService service;

    @Autowired
    PingController(MessageService service) {
        this.service = service;
    }

    @RequestMapping("/ping")
    public String index() {
        return service.getMessage();
    }

}
