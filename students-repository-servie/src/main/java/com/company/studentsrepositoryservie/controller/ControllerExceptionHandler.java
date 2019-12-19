package com.company.studentsrepositoryservie.controller;

import com.company.studentsrepositoryservie.exception.NotFoundException;
import org.springframework.hateoas.mediatype.vnderrors.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(value = IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<VndErrors> outOfRangeException(IllegalArgumentException e, WebRequest webRequest) {
        VndErrors vndErrors = new VndErrors(webRequest.toString(), e.getMessage());
        return new ResponseEntity<>(vndErrors, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<VndErrors> recordValidationError(MethodArgumentNotValidException e, WebRequest webRequest) {
        List<VndErrors.VndError> vndErrorList = e.getBindingResult().getFieldErrors().stream()
                .map(error -> new VndErrors.VndError(webRequest.toString(), error.getDefaultMessage()))
                .collect(Collectors.toList());
        VndErrors vndErrors = new VndErrors(vndErrorList);
        return new ResponseEntity<>(vndErrors, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(value = {NotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<VndErrors> notFoundException(NotFoundException e, WebRequest request) {
        VndErrors error = new VndErrors(request.toString(), "Not found : " + e.getMessage());
        ResponseEntity<VndErrors> responseEntity = new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        return responseEntity;
    }
}
