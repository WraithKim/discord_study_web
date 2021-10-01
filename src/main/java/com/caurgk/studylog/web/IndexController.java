package com.caurgk.studylog.web;

import com.caurgk.studylog.services.studylog.StudyLogService;
import com.caurgk.studylog.web.dto.StudyLogDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final StudyLogService studyLogService;

    @GetMapping("/")
    public String index(Model model, Authentication authentication) {
        List<StudyLogDto> studyLogDtoList = studyLogService.findAll();

        model.addAttribute("studyLogs", studyLogDtoList);
        if (authentication != null)
        {
            String userName = authentication.getName();
            model.addAttribute("userName", userName);
        }

        return "index";
    }
}
