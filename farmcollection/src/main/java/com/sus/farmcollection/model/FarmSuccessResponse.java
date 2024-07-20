package com.sus.farmcollection.model;

/**
 * This is a Farm success response which needs to returned during api successful
 * consumption.
 */
public class FarmSuccessResponse {

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    

}
