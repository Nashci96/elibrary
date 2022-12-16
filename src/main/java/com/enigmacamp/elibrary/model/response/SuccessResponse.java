package com.enigmacamp.elibrary.model.response;

import org.springframework.http.HttpStatus;

public class SuccessResponse<T> extends CommonResponse {
    T data;

    public SuccessResponse(String messsage,T data){
        super.setCode("OO");
        super.setMessage(messsage);
        super.setStatus(HttpStatus.OK.name());
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
