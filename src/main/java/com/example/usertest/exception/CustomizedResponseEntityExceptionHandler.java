package com.example.usertest.exception;

import com.example.usertest.exception.httpstatus.BadRequestException;
import com.example.usertest.exception.httpstatus.UnexpectedException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Get and custom validation from controller
     *
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        CustomErrorResponse errors = this
                .setError(ex.getBindingResult().getFieldError().getDefaultMessage(), null, HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity(errors, HttpStatus.BAD_REQUEST);
    }

    /**
     * --------------------------------------------------------------------------------------
     * Bad Request ---------------------------------------------------------------------------
     *
     * @Status 400
     * @Return Errors
     */
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<CustomErrorResponse> handleBadRequest(BadRequestException ex) {
        CustomErrorResponse errors = this
                .setError(ex.getMessage(), ex.getData(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    /**
     * --------------------------------------------------------------------------------------
     * Unexpected Error ---------------------------------------------------------------------------
     *
     * @Status 500
     * @Return Errors
     */
    @ExceptionHandler(UnexpectedException.class)
    public ResponseEntity<CustomErrorResponse> handleUnexpected(UnexpectedException ex) {
        CustomErrorResponse errors = this
                .setError(ex.getMessage(), ex.getData(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    private CustomErrorResponse setError(String message, Object data, int httpStatusValue) {
        CustomErrorResponse errors = new CustomErrorResponse();
        errors.setTimestamp(LocalDateTime.now());
        errors.setMessage(message);
        errors.setStatus(httpStatusValue);
        errors.setData(data);

        return errors;
    }
}
