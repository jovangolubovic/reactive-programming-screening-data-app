package com.reactive.screeningdata.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDateTime;

@Table
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class ScreeningTaskDto {

    @Id
    private Long id;
    private Long resultId;
    private String assignedTo;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
