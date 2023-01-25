package com.reactive.screeningdata.service;

import com.reactive.screeningdata.entity.ScreeningTask;
import com.reactive.screeningdata.mapper.ScreeningTaskMapper;
import com.reactive.screeningdata.model.ScreeningTaskDto;
import com.reactive.screeningdata.repository.ScreeningTaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ScreeningTaskServiceImpl implements ScreeningTaskService {

    private final ScreeningTaskRepository screeningTaskRepository;

    private final ScreeningTaskMapper screeningTaskMapper;

    @Override
    public Flux<ScreeningTaskDto> findAllScreeningTasks() {
        return screeningTaskRepository.findAll()
                .map(screeningTaskMapper::screeningTaskToScreeningTaskDto);
    }

    @Override
    public Mono<ScreeningTaskDto> saveScreeningTask(ScreeningTaskDto screeningTaskDto) {
        ScreeningTask screeningTask = screeningTaskMapper.screeningTaskDtoToScreeningTask(screeningTaskDto);
        return screeningTaskRepository.save(screeningTask).map(screeningTaskMapper::screeningTaskToScreeningTaskDto);
    }

    @Override
    public Mono<ScreeningTaskDto> updateScreeningTask(ScreeningTaskDto screeningTaskDto) {
        ScreeningTask screeningTask = screeningTaskMapper.screeningTaskDtoToScreeningTask(screeningTaskDto);
        return screeningTaskRepository.save(screeningTask).map(screeningTaskMapper::screeningTaskToScreeningTaskDto);
    }

    @Override
    public Mono<Void> deleteScreeningTask(Long id) {
        return screeningTaskRepository.deleteById(id);
    }
}
