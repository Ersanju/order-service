package com.homekart.order_service.exception;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {

    private String message;
    private Integer status;
    private LocalDateTime timestamp;
    
}
