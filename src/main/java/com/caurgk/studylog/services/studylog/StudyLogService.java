package com.caurgk.studylog.services.studylog;

import com.caurgk.studylog.domains.studylog.StudyLog;
import com.caurgk.studylog.domains.studylog.StudyLogRepository;
import com.caurgk.studylog.web.dto.StudyLogDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StudyLogService {

    private final StudyLogRepository studyLogRepository;

    public List<StudyLogDto> findAll() {
        List<StudyLog> studyLogs = studyLogRepository.findAll();
        return studyLogs.stream().map(StudyLogDto::new).collect(Collectors.toList());
    }
}
