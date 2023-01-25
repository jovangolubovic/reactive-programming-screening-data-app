package com.reactive.screeningdata.controller;

import com.reactive.screeningdata.model.ScreeningResultDto;
import com.reactive.screeningdata.service.ScreeningResultService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.TEXT_EVENT_STREAM_VALUE;

@RestController
@RequestMapping(value = "/screening-results")
@RequiredArgsConstructor
@Slf4j
public class ScreeningResultController {

    private final ScreeningResultService screeningResultService;

    @GetMapping(produces = TEXT_EVENT_STREAM_VALUE)
    public Flux<ScreeningResultDto> getAllData() {

        return screeningResultService.findAllData();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ScreeningResultDto> saveScreeningResultData(@RequestBody ScreeningResultDto screeningResultDto) {
        return screeningResultService.saveScreeningResultData(screeningResultDto);
    }


    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<ScreeningResultDto> updateScreeningResultData(@RequestBody ScreeningResultDto screeningResultDto) {
        return screeningResultService.updateScreeningResultData(screeningResultDto);
    }


    @DeleteMapping("/{id}")
    public Mono<Void> deleteScreeningResultData(@PathVariable("id") Long id) {
        return screeningResultService.deleteScreeningResultData(id);
    }
}
