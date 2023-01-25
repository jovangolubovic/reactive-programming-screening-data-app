package com.reactive.screeningdata.service;

import com.reactive.screeningdata.mapper.ScreeningResultMapper;
import com.reactive.screeningdata.model.ScreeningResultDto;
import com.reactive.screeningdata.repository.ScreeningResultRepository;
import com.reactive.screeningdata.repository.ScreeningTaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class ScreeningResultServiceImpl implements ScreeningResultService {

    private final ScreeningResultRepository screeningResultRepository;
    private final ScreeningTaskRepository screeningTaskRepository;

    private final ScreeningResultMapper screeningResultMapper;


    @Override
    public Flux<ScreeningResultDto> findAllData() {
        return screeningResultRepository.findAll()
                .map(screeningResultMapper::screeningResultToScreeningResultDto)
                .flatMap(screeningResultDto -> screeningTaskRepository.findByResultId(screeningResultDto.getId())
                        .doOnSuccess(screeningResultDto::setScreeningTask)
                        .thenReturn(screeningResultDto));
    }

    @Override
    public Mono<ScreeningResultDto> saveScreeningResultData(ScreeningResultDto screeningResultDto) {

        return screeningResultRepository
                .save(screeningResultMapper.screeningResultDtoToScreeningResult(screeningResultDto))
                .map(screeningResultMapper::screeningResultToScreeningResultDto);


    }

    @Override
    public Mono<ScreeningResultDto> updateScreeningResultData(ScreeningResultDto screeningResultDto) {

        return screeningResultRepository
                .save(screeningResultMapper.screeningResultDtoToScreeningResult(screeningResultDto))
                .map(screeningResultMapper::screeningResultToScreeningResultDto);
    }

    @Override
    public Mono<Void> deleteScreeningResultData(Long id) {
        return screeningResultRepository.deleteById(id);
    }
}
