package com.kevcompany.employeeManager.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class HttpResponse {
    private int httpStatusCode;
    private HttpStatus httpStatus;
    private String reason;
    private String message;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy hh:mm:ss")
    private LocalDateTime timestamp;

    public HttpResponse(int httpStatusCode, HttpStatus httpStatus, String reason, String message) {
        this.httpStatusCode = httpStatusCode;
        this.httpStatus = httpStatus;
        this.reason = reason;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public int getHttpStatusCode() { return httpStatusCode; }
    public HttpStatus getHttpStatus() { return httpStatus; }
    public String getReason() { return reason; }
    public String getMessage() { return message; }
    public LocalDateTime getTimestamp() { return timestamp; }
}
