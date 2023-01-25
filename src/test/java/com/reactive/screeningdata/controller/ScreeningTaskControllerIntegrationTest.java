package com.reactive.screeningdata.controller;

import com.reactive.screeningdata.TestConfig;
import com.reactive.screeningdata.mapper.ScreeningResultMapper;
import com.reactive.screeningdata.mapper.ScreeningTaskMapper;
import com.reactive.screeningdata.model.ScreeningResultDto;
import com.reactive.screeningdata.model.ScreeningTaskDto;
import com.reactive.screeningdata.repository.ScreeningResultRepository;
import com.reactive.screeningdata.repository.ScreeningTaskRepository;
import com.reactive.screeningdata.util.TestUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
@Import(TestConfig.class)
class ScreeningTaskControllerIntegrationTest {


    private static final String URI = "/screening-task";

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private ScreeningTaskRepository screeningTaskRepository;

    @Autowired
    private ScreeningTaskMapper screeningTaskMapper;


    @Test
    void findAllScreeningTasks() {

        webTestClient.get()
                .uri(URI)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(ScreeningTaskDto.class)
                .value(screeningTask -> assertTrue(screeningTask.size() > 0));

    }

    @Test
    void saveScreeningTask() {

        ScreeningTaskDto screeningTaskDto = TestUtil.createScreeningTaskDto();

        webTestClient.post()
                .uri(URI)
                .bodyValue(screeningTaskDto)
                .exchange()
                .expectStatus().isCreated()
                .expectHeader().valueEquals("Content-Type", "application/json")
                .expectBody(ScreeningTaskDto.class)
                .value(screeningTask -> assertEquals(screeningTask.getAssignedTo(), screeningTaskDto.getAssignedTo()));

    }

    @Test
    void updateScreeningTask() {

        ScreeningTaskDto screeningTaskDto = screeningTaskMapper
                .screeningTaskToScreeningTaskDto(screeningTaskRepository.findById(1l).block());

        screeningTaskDto.setAssignedTo("Assigned To Test UPDATED");

        ScreeningTaskDto updated = screeningTaskMapper
                .screeningTaskToScreeningTaskDto(screeningTaskRepository
                        .save(screeningTaskMapper
                                .screeningTaskDtoToScreeningTask(screeningTaskDto)).block());

        assertNotNull(updated);

        webTestClient.put()
                .uri(URI)
                .bodyValue(screeningTaskDto)
                .exchange()
                .expectStatus().isNoContent();

        ScreeningTaskDto screeningTaskDtoUpdated = screeningTaskMapper
                .screeningTaskToScreeningTaskDto(screeningTaskRepository
                        .findById(screeningTaskDto.getId()).block());

        assertNotNull(screeningTaskDtoUpdated);
        assertEquals(screeningTaskDto.getAssignedTo(), screeningTaskDtoUpdated.getAssignedTo());
        System.out.println(screeningTaskDtoUpdated.getAssignedTo());

    }

    @Test
    void deleteScreeningTask() {

        ScreeningTaskDto screeningTaskDto = screeningTaskMapper
                .screeningTaskToScreeningTaskDto(screeningTaskRepository.findById(1l).block());

        System.out.println(screeningTaskDto.getAssignedTo());

        webTestClient.delete()
                .uri(URI + "/1")
                .exchange()
                .expectStatus().isOk();

        ScreeningTaskDto screeningTaskDtoDeleted = screeningTaskMapper
                .screeningTaskToScreeningTaskDto(screeningTaskRepository.findById(1l).block());

        assertNull(screeningTaskDtoDeleted);

    }
}