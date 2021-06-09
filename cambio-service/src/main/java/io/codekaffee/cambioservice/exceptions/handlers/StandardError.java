package io.codekaffee.cambioservice.exceptions.handlers;

public class StandardError {
    private String msg;
    private Integer statusCode;

    public StandardError(String msg, Integer statusCode) {
        this.msg = msg;
        this.statusCode = statusCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
}
