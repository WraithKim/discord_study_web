package com.caurgk.studylog.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudyLogController {

    @GetMapping("/")
    public String index() {
        return "Spring application status is OK";
    }
}
