package com.prunny.auth.exception;

import com.prunny.auth.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<?> AlreadyExistsException(AlreadyExistsException ex) {
        return new ResponseEntity<>(new ApiResponse<>(ex.getMessage(), false), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(PasswordIncorrect.class)
    public ResponseEntity<?> PasswordIncorrect(PasswordIncorrect ex) {
        return new ResponseEntity<>(new ApiResponse<>((ex.getMessage()),false), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<?> UsernameNotFoundException(UsernameNotFoundException ex) {
        return new ResponseEntity<>(new ApiResponse<>((ex.getMessage()),false), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AuthenticationFailedException.class)
    public ResponseEntity<?> AuthenticationFailedException(AuthenticationFailedException ex) {
        return new ResponseEntity<>(new ApiResponse<>((ex.getMessage()),false), HttpStatus.NOT_FOUND);
    }

}
