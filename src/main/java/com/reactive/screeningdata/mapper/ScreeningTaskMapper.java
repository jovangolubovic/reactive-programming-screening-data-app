package com.reactive.screeningdata.mapper;

import com.reactive.screeningdata.entity.ScreeningTask;
import com.reactive.screeningdata.model.ScreeningTaskDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ScreeningTaskMapper {

    ScreeningTaskDto screeningTaskToScreeningTaskDto(ScreeningTask screeningTask);

    ScreeningTask screeningTaskDtoToScreeningTask(ScreeningTaskDto screeningTaskDto);
}
