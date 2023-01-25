package com.reactive.screeningdata.service;

import com.reactive.screeningdata.entity.ScreeningResult;
import com.reactive.screeningdata.model.ScreeningResultDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ScreeningResultService {

    public Flux<ScreeningResultDto> findAllData();

    Mono<ScreeningResultDto> saveScreeningResultData(ScreeningResultDto screeningResultDto);

    Mono<ScreeningResultDto> updateScreeningResultData(ScreeningResultDto screeningResultDto);

    Mono<Void> deleteScreeningResultData(Long id);
}
