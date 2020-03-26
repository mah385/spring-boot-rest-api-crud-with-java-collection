package com.mah.exceptions;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//@RestControllerAdvice //Note: when @RestControllerAdvice is enable then @Valid is not working, need to find out why
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    //To handle general exception (All Exceptions) and print complete exception stack trace
    /*@ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception e, WebRequest webRequest) {
        return new ResponseEntity<>(e, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }*/

    //To handle general exception (All Exceptions) and print exact exception message
    /*@ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyExceptionImproper(Exception e, WebRequest webRequest) {
        ExceptionMessage exceptionMessage = new ExceptionMessage(e.getLocalizedMessage(), LocalDateTime.now());
        return new ResponseEntity<>(exceptionMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }*/

    //To handle general exception (All Exceptions) and print exact exception message
    /*@ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyExceptionProper(Exception e, WebRequest webRequest) {
        String localizedMessage = e.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = e.toString();
        }
        ExceptionMessage exceptionMessage = new ExceptionMessage(localizedMessage, LocalDateTime.now());
        return new ResponseEntity<>(exceptionMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }*/

    //To handle specific exception (Single Exception) and print exact exception message
    /*@ExceptionHandler(value = {NullPointerException.class})
    public ResponseEntity<Object> handleNullPointerException(NullPointerException e, WebRequest webRequest) {
        String localizedMessage = e.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = e.toString();
        }
        ExceptionMessage exceptionMessage = new ExceptionMessage(localizedMessage, LocalDateTime.now());
        return new ResponseEntity<>(exceptionMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }*/

    //To handle own exception (Single Exception) and print exact exception message
    /*@ExceptionHandler(value = {UserServiceException.class})
    public ResponseEntity<Object> handleUserServiceException(UserServiceException e, WebRequest webRequest) {
        String localizedMessage = e.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = e.toString();
        }
        ExceptionMessage exceptionMessage = new ExceptionMessage(localizedMessage, LocalDateTime.now());
        return new ResponseEntity<>(exceptionMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }*/

    //To handle multiple exception (Multiple Exception) in other words set of exceptions and print exact exception message
    /*@ExceptionHandler(value = {NullPointerException.class, UserServiceException.class})
    public ResponseEntity<Object> handleMultipleException(Exception e, WebRequest webRequest) {
        String localizedMessage = e.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = e.toString();
        }
        ExceptionMessage exceptionMessage = new ExceptionMessage(localizedMessage, LocalDateTime.now());
        return new ResponseEntity<>(exceptionMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }*/

}
