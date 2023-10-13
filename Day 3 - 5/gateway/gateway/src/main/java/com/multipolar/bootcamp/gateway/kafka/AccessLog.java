package com.multipolar.bootcamp.gateway.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AccessLog implements Serializable {
    //private String method;
    //private String status;
    //private String message;

    //private String requestMethod;
    //private String requestUri;
    //private Integer responseStatusCode;
    //private LocalDateTime timeStamp = LocalDateTime.now();
    //private String content;
    private String httpMethod;
    private String requestUri;
    private Integer responseStatusCode;
    private String content;
    private String clientIP;
    private String userAgent;
    private LocalDateTime timeStamp = LocalDateTime.now();
}
