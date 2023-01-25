package com.reactive.screeningdata.controller;

import com.reactive.screeningdata.TestConfig;
import com.reactive.screeningdata.mapper.ScreeningResultMapper;
import com.reactive.screeningdata.model.ScreeningResultDto;
import com.reactive.screeningdata.repository.ScreeningResultRepository;
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
class ScreeningResultControllerIntegrationTest {

    private static final String URI = "/screening-results";

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private ScreeningResultRepository screeningResultRepository;

    @Autowired
    private ScreeningResultMapper screeningResultMapper;


    @Test
    void getAllData() {

        webTestClient.get()
                .uri(URI)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(ScreeningResultDto.class)
                .value(screeningResults -> assertTrue(screeningResults.size() > 0));
    }

    @Test
    void saveScreeningResultData() {

        ScreeningResultDto screeningResultDto = TestUtil.createScreeningResultDto();

        webTestClient.post()
                .uri(URI)
                .bodyValue(screeningResultDto)
                .exchange()
                .expectStatus().isCreated()
                .expectHeader().valueEquals("Content-Type", "application/json")
                .expectBody(ScreeningResultDto.class)
                .value(screeningResult -> assertEquals(screeningResult.getOperator(), screeningResultDto.getOperator()));

    }

    @Test
    void updateScreeningResultData() {

        ScreeningResultDto screeningResultDto = screeningResultMapper
                .screeningResultToScreeningResultDto(screeningResultRepository.findById(1l).block());

        screeningResultDto.setOperator("Operator Test UPDATED");

        ScreeningResultDto updated = screeningResultMapper
                .screeningResultToScreeningResultDto(screeningResultRepository
                        .save(screeningResultMapper
                                .screeningResultDtoToScreeningResult(screeningResultDto)).block());

        assertNotNull(updated);

        webTestClient.put()
                .uri(URI)
                .bodyValue(screeningResultDto)
                .exchange()
                .expectStatus().isNoContent();

        ScreeningResultDto screeningResultDtoUpdated = screeningResultMapper
                .screeningResultToScreeningResultDto(screeningResultRepository
                        .findById(screeningResultDto.getId()).block());

        assertNotNull(screeningResultDtoUpdated);
        assertEquals(screeningResultDto.getOperator(), screeningResultDtoUpdated.getOperator());
        System.out.println(screeningResultDtoUpdated.getOperator());
    }

    @Test
    void deleteScreeningResultData() {

        ScreeningResultDto screeningResultDto = screeningResultMapper
                .screeningResultToScreeningResultDto(screeningResultRepository.findById(1l).block());

        System.out.println(screeningResultDto.getOperator());

        webTestClient.delete()
                .uri(URI + "/1")
                .exchange()
                .expectStatus().isOk();

        ScreeningResultDto screeningResultDtoDeleted = screeningResultMapper
                .screeningResultToScreeningResultDto(screeningResultRepository.findById(1l).block());

        assertNull(screeningResultDtoDeleted);
    }
}