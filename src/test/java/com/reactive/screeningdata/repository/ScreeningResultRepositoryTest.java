package com.reactive.screeningdata.repository;

import com.reactive.screeningdata.entity.ScreeningResult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ActiveProfiles("local")
@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext
public class ScreeningResultRepositoryTest {

    @Autowired ScreeningResultRepository screeningResultRepository;

    @Test
    void testFindAllData(){
        Flux<ScreeningResult> screeningResultsList = screeningResultRepository.findAll();
        assertTrue(screeningResultsList.toStream().findAny().isPresent());
    }

}
