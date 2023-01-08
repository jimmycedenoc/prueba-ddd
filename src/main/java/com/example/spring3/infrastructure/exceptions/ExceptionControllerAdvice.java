package com.example.spring3.infrastructure.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionControllerAdvice {
  @ExceptionHandler({RuntimeException.class})
  public ProblemDetail onError(RuntimeException ex, HttpServletRequest request) {
    log.error(request.getMethod().concat(" ").concat(request.getRequestURI()));
    log.error(ex.getMessage());
    return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
  }
}
