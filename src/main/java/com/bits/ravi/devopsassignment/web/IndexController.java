package com.bits.ravi.devopsassignment.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @GetMapping
    public String index() {
        return "Hello DevOps World !" +
                "<br/>" +
                "Changes for Assignment Task #6 !";
    }
}
