package com.multipolar.bootcamp.loggingproduct.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Document(collection = "access-log-product")
public class AccessLog implements Serializable {
    @Id
    private String id;
    private String requestMethod;
    private String requestUri;
    private Integer responseStatusCode;
    private LocalDateTime timeStamp = LocalDateTime.now();
    private String content;
}
