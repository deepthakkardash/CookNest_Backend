package com.cooknest.cooknest.in.exception;


import com.cooknest.cooknest.in.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
//import com.cooknest.cooknest.in.exception.MethodArgumentNotValidException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<ApiResponse<String>> handleAlreadyExist(AlreadyExistsException ex)
    {
        ApiResponse<String> res=new ApiResponse<>().error(ex.getMessage(),"USER_EXISTS");
        return  ResponseEntity.status(HttpStatus.CONFLICT).body(res);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<List<String>>> handleValidationError(MethodArgumentNotValidException ex)
    {
        List<String> errors=new ArrayList<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> errors.add(error.getField()+":"+error.getDefaultMessage()));

        ApiResponse<List<String>> response = ApiResponse.error("validation Failed","VALIDATION_ERROR");
        response.setErrors(errors);

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiResponse<String>> handleUserNotFoundException(UserNotFoundException ex)
    {
        ApiResponse<String> res=new ApiResponse<>().error(ex.getMessage(), "NOT_FOUND");
        return ResponseEntity.badRequest().body(res);
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<ApiResponse<String>> handleInvalidException(InvalidCredentialsException ex)
    {
        ApiResponse<String> response=new ApiResponse<>().error(ex.getMessage(),"INVALID");
        return ResponseEntity.badRequest().body(response);
    }


    @ExceptionHandler(DishNotFoundException.class)
    public ResponseEntity<ApiResponse<String>> handleDishnotFoundException(DishNotFoundException ex)
    {
        ApiResponse<String> response=new ApiResponse<>().error(ex.getMessage(), "NOT_FOUND");
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ApiResponse<String>> handleCategoryNotFoundException(CategoryNotFoundException ex)
    {
        ApiResponse<String> response=new ApiResponse<>().error(ex.getMessage(),"NOT_FOUND");
        return ResponseEntity.badRequest().body(response);
    }
}
