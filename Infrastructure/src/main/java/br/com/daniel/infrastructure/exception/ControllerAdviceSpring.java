package br.com.daniel.infrastructure.exception;

import br.com.daniel.core.exception.BadRequestException;
import br.com.daniel.core.exception.InternalServerErrorException;
import br.com.daniel.core.exception.NotFoundException;
import br.com.daniel.core.exception.enums.ErrorCodeEnum;
import br.com.daniel.infrastructure.dto.response.BaseResponse;
import br.com.daniel.infrastructure.dto.response.ErrorResponse;
import br.com.daniel.infrastructure.dto.response.ValidationError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.stream.Collectors;

@ControllerAdvice
public class ControllerAdviceSpring {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BaseResponse<String>> handleBadRequestException(BadRequestException ex, WebRequest request) {
        ErrorResponse error = new ErrorResponse(ex.getMessage(), ex.getCode(), null);

        return new ResponseEntity<>(BaseResponse.<String>builder().success(false).error(error).build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<BaseResponse<String>> handleNotFoundException(NotFoundException ex, WebRequest request) {
        ErrorResponse error = new ErrorResponse(ex.getMessage(), ex.getCode(), null);
        return new ResponseEntity<>(BaseResponse.<String>builder().success(false).error(error).build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<BaseResponse<String>> handleInternalServerError(InternalServerErrorException ex, WebRequest request) {
        ErrorResponse error = new ErrorResponse(ex.getMessage(), ex.getCode(), null);
        return new ResponseEntity<>(BaseResponse.<String>builder().success(false).error(error).build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<BaseResponse<String>> handleIllegalStateException(IllegalStateException ex, WebRequest request) {
        ErrorResponse error = new ErrorResponse(ex.getMessage(), "SomeErrorCode", null);
        ;
        return new ResponseEntity<>(BaseResponse.<String>builder().success(false).error(error).build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponse<ValidationError>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {
        ErrorResponse error = new ErrorResponse(
                ErrorCodeEnum.TT0003.getMessage(),
                ErrorCodeEnum.TT0003.getCode(),
                ex.getBindingResult().getFieldErrors().stream()
                        .map(fieldError -> new ValidationError(fieldError.getField(), fieldError.getDefaultMessage()))
                        .collect(Collectors.toList())
        );
        ;
        return new ResponseEntity<>(BaseResponse.<ValidationError>builder().success(false).error(error).build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<BaseResponse<String>> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex, WebRequest request) {
        ErrorResponse error = new ErrorResponse(ErrorCodeEnum.TT0004.getMessage(), ErrorCodeEnum.TT0004.getCode(), null);
        return new ResponseEntity<>(BaseResponse.<String>builder().success(false).error(error).build(), HttpStatus.BAD_REQUEST);
    }


}
