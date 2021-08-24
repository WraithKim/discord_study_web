package com.caurgk.studylog.web;

import com.caurgk.studylog.domains.studylog.StudyLog;
import com.caurgk.studylog.domains.studylog.StudyLogRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class IndexControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private StudyLogRepository studyLogRepository;

    @AfterEach
    public void tearDown() {
        studyLogRepository.deleteAll();
    }

    @Test
    public void testLoadMainPage() {
        String body = restTemplate.getForObject("/", String.class);
        assertThat(body).contains("랜선 각자 코딩 스터디 기록");
    }

    @Test
    public void testStudyLogList() {
        StudyLog expected = StudyLog.builder()
                .startTime(LocalDateTime.now())
                .endTime(LocalDateTime.now())
                .userId(123456789)
                .build();
        studyLogRepository.save(expected);
        String body = restTemplate.getForObject("/", String.class);
        assertThat(body).contains(String.valueOf(expected.getUserId()));
    }
}
