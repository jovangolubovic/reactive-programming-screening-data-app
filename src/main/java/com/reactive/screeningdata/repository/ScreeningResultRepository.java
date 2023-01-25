package com.reactive.screeningdata.repository;

import com.reactive.screeningdata.entity.ScreeningResult;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreeningResultRepository extends ReactiveCrudRepository<ScreeningResult, Long> {

}
