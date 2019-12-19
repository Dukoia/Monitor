package com.dukoia.microservice.monitor.enums;

/**
 * @author Dukoia
 * @createTime 2019/12/9 11:05
 */
public enum ResultCode {

    SUCCESS(200,"请求成功"),
    FAILED(400,"请求失败");

    private Integer code;

    private String message;

    ResultCode(Integer code, String message){
        this.code = code;
        this.message = message;
    }
    public Integer code(){
        return this.code;
    }
    public String message(){
        return this.message;
    }
}
