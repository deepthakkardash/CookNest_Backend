package com.cooknest.cooknest.in;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.bind.validation.ValidationErrors;

import java.util.List;

@Data
@AllArgsConstructor
//@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    private boolean success;
    private String message;
    private T data;

    private String errorCode;
    private List<String> errors;

    public ApiResponse(){}

    public static <T> ApiResponse<T> success(String message, T data)
    {
        ApiResponse<T> res=new ApiResponse<>();
        res.success=true;
        res.message=message;
        res.data=data;

        return res;
    }

    public static <T> ApiResponse<T> error(String message, String errorCode)
    {
        ApiResponse<T> res=new ApiResponse<>();
        res.success=false;
        res.message=message;
        res.errorCode=errorCode;

        return res;
    }
}
