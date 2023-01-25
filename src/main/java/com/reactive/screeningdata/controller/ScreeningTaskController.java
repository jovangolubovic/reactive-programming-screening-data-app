package com.reactive.screeningdata.controller;

import com.reactive.screeningdata.model.ScreeningTaskDto;
import com.reactive.screeningdata.service.ScreeningTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/screening-task")
@RequiredArgsConstructor
public class ScreeningTaskController {

    private final ScreeningTaskService screeningTaskService;

    @GetMapping
    public Flux<ScreeningTaskDto> findAllScreeningTasks() {
        return screeningTaskService.findAllScreeningTasks();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ScreeningTaskDto> saveScreeningTask(@RequestBody ScreeningTaskDto screeningTaskDto) {
        return screeningTaskService.saveScreeningTask(screeningTaskDto);
    }


    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<ScreeningTaskDto> updateScreeningTask(@RequestBody ScreeningTaskDto screeningTaskDto) {
        return screeningTaskService.updateScreeningTask(screeningTaskDto);
    }


    @DeleteMapping("/{id}")
    public Mono<Void> deleteScreeningTask(@PathVariable("id") Long id) {
        return screeningTaskService.deleteScreeningTask(id);
    }

}
