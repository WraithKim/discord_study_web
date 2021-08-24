package com.caurgk.studylog.web.dto;

import com.caurgk.studylog.domains.studylog.StudyLog;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class StudyLogDto {
    private long id;
    private int userId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public StudyLogDto(StudyLog studyLog) {
        this.id = studyLog.getId();
        this.userId = studyLog.getUserId();
        this.startTime = studyLog.getStartTime();
        this.endTime = studyLog.getEndTime();
    }

    public StudyLog toEntity() {
        return StudyLog.builder()
                .id(id)
                .userId(userId)
                .startTime(startTime)
                .endTime(endTime)
                .build();
    }
}
