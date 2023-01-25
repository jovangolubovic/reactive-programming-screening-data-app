package com.reactive.screeningdata.mapper;

import com.reactive.screeningdata.entity.ScreeningResult;
import com.reactive.screeningdata.model.ScreeningResultDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, unmappedTargetPolicy = ReportingPolicy.WARN)
public interface ScreeningResultMapper {

    ScreeningResultDto screeningResultToScreeningResultDto(ScreeningResult screeningResult);

    ScreeningResult screeningResultDtoToScreeningResult(ScreeningResultDto screeningResultDto);
}
