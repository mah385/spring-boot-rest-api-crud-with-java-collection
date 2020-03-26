package com.mah.ui.model.response;

import java.time.LocalDateTime;

public class ExceptionMessage {
    private String message;
    private LocalDateTime timestamp;

    public ExceptionMessage() {
    }

    public ExceptionMessage(String message, LocalDateTime timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "ExceptionMessage{" +
                "message='" + message + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

}
