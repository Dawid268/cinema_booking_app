package com.cinema_booking.booking.exception;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

        @ExceptionHandler(RoomNotFindException.class)
        public ResponseEntity<Object> handleCityNotFoundException(
                        RoomNotFindException roomException, WebRequest request) {

                ErrorMessage message = new ErrorMessage(
                                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                                new Date(),
                                roomException.getMessage());
                return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }

        @ExceptionHandler(MethodArgumentTypeMismatchException.class)
        public ResponseEntity<ErrorMessage> handleTypeMismatch(MethodArgumentTypeMismatchException exception,
                        WebRequest request) {

                ErrorMessage message = new ErrorMessage(
                                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                                new Date(),
                                String.format("'%name' should be a valid '%type'",
                                                exception.getName(), exception.getRequiredType().getSimpleName()));

                return new ResponseEntity<ErrorMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        @Override
        protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                        HttpHeaders headers, HttpStatus status, WebRequest request) {
                List<String> validationList = ex.getBindingResult().getFieldErrors().stream()
                                .map(fieldError -> fieldError.getDefaultMessage()).collect(Collectors.toList());
                ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date(),
                                validationList);
                return new ResponseEntity<>(error, status);
        }

        @Override
        protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                        HttpHeaders headers, HttpStatus status, WebRequest request) {
                ErrorMessage message = new ErrorMessage(
                                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                                new Date(),
                                ex.getMessage());
                return new ResponseEntity<>(message, status);
        }
}
