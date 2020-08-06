package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResultData<T> {

    private int code;

    private String msg;

    private T data;

    public static <T> ResultData ok(String msg, T data){
        return new ResultData(HttpStatus.OK.value(), msg, data);
    }

    public static <T> ResultData fail(String msg, T data){
        return new ResultData(HttpStatus.BAD_REQUEST.value(), msg, data);
    }

}
