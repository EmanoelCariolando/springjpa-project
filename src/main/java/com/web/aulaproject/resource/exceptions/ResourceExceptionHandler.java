package com.web.aulaproject.resource.exceptions;

import com.web.aulaproject.service.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
      String error = "Resource not Found";
         HttpStatus status = HttpStatus.NOT_FOUND;
         StandardError err = new StandardError(error,e.getMessage(),request.getRequestURI(), status.value() ,Instant.now());
         return ResponseEntity.status(status).body(err);
  }
}
