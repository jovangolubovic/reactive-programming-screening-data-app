package com.reactive.screeningdata.service;

import com.reactive.screeningdata.model.ScreeningTaskDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ScreeningTaskService {

    Flux<ScreeningTaskDto> findAllScreeningTasks();

    Mono<ScreeningTaskDto> saveScreeningTask(ScreeningTaskDto screeningTaskDto);

    Mono<ScreeningTaskDto> updateScreeningTask(ScreeningTaskDto screeningTaskDto);

    Mono<Void> deleteScreeningTask(Long id);
}
