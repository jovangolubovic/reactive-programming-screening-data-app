package com.reactive.screeningdata.repository;

import com.reactive.screeningdata.entity.ScreeningTask;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ScreeningTaskRepository extends ReactiveCrudRepository<ScreeningTask, Long> {

    Mono<ScreeningTask> findByResultId(Long resultId);

}
