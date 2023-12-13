package com.fangfei.springboot.Response;




public class ResponseOrMessage <T> extends ApiResult {
    T body;

    public ResponseOrMessage(T body) {
       this.body = body;
    }

    public ResponseOrMessage(String error){
        this.message = error;
    }
}
