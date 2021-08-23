package com.caurgk.studylog.web;

import com.caurgk.studylog.services.studylog.StudyLogService;
import com.caurgk.studylog.web.dto.StudyLogDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class StudyLogController {

    private final StudyLogService studyLogService;

    @GetMapping("/")
    public String index() {
        return "Spring application status is OK";
    }

    @GetMapping("/list")
    public List<StudyLogDto> list() {
        return studyLogService.findAll();
    }
}
