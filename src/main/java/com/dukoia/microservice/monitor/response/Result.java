package com.dukoia.microservice.monitor.response;

import com.dukoia.microservice.monitor.enums.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Dukoia
 * @createTime 2019/12/9 10:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> implements Serializable {

    private Integer code;

    private String message;

    private T data;

    public Result(ResultCode resultCode, T data){
        this.code = resultCode.code();
        this.message = resultCode.message();
        this.data = data;
    }
    public Result(ResultCode resultCode){
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

    public static Result failed(){
        return new Result(ResultCode.FAILED);
    }
}
