package com.reactive.screeningdata.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.Objects;

@Table
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class ScreeningTask {

    @Id
    private Long id;
    private Long resultId;
    private String assignedTo;
    private String status;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScreeningTask that = (ScreeningTask) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(resultId, that.resultId)) return false;
        if (!Objects.equals(assignedTo, that.assignedTo)) return false;
        return Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (resultId != null ? resultId.hashCode() : 0);
        result = 31 * result + (assignedTo != null ? assignedTo.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
