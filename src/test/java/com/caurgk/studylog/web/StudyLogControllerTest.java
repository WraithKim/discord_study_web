package com.caurgk.studylog.web;

import com.caurgk.studylog.domains.studylog.StudyLog;
import com.caurgk.studylog.domains.studylog.StudyLogRepository;
import com.caurgk.studylog.web.dto.StudyLogDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudyLogControllerTest {

    @Autowired
    private TestRestTemplate template;

    @Autowired
    private StudyLogRepository studyLogRepository;

    @AfterEach
    public void tearDown() throws Exception {
        studyLogRepository.deleteAll();
    }

    @Test
    public void getIndex() throws Exception {
        ResponseEntity<String> response = template.getForEntity("/", String.class);
        assertThat(response.getBody()).isEqualTo("Spring application status is OK");
    }

    @Test
    public void getList() throws Exception {
        // given
        StudyLog expected = StudyLog.builder()
                .id(1L)
                .userId(1)
                .startTime(LocalDateTime.now())
                .endTime(LocalDateTime.now())
                .build();
        studyLogRepository.save(expected);

        // when
        ResponseEntity<List<StudyLogDto>> response = template.exchange("/list", HttpMethod.GET, null, new ParameterizedTypeReference<List<StudyLogDto>>(){});

        // then
        StudyLog actual = response.getBody().get(0).toEntity();
        assertThat(actual).isEqualTo(expected);
    }
}
