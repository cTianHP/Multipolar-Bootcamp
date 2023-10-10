package com.multipolar.bootcamp.crud.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor //bikin constructror dng parameter
@NoArgsConstructor //bikin constructror tanpa parameter
@ToString
@EqualsAndHashCode //methods yang menjamin keunikan object
@Document //mapping dari object menjadi document di collection
public class Todo implements Serializable {
    //field
    @Id //annotation untuk jadi  primary key
    private String id; //disebut juga java bin

    @NotEmpty(message = "Task cannot be empty")
    private String task;

    private String description;
    private LocalDateTime dueDate;
    private Status status;
    private Priority priority;
    private List<String> tags;
}
