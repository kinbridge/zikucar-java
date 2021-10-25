package com.think.common.views;

import java.io.Serializable;

/**
 * @author Administrator
 */
public class Result<T> implements Serializable {

    private T data;
    private boolean success;
    private int code;
    private String message;

    public Result() {
    }

    private Result(boolean success, int code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    private Result(T data, boolean success, int code, String message) {
        this.data = data;
        this.success = success;
        this.code = code;
        this.message = message;
    }

    /**
     * 成功
     */
    public static <T> Result<T> success() {
        return new Result<T>(true, 200, "返回成功");
    }

    /**
     * 成功
     */
    public static <T> Result<T> success(T data) {
        return new Result<T>(data, true, 200, "返回成功");
    }
    /**
     * 成功
     */
    public static <T> Result<T> success(T data,String message) {
        return new Result<T>(data, true, 200, "返回成功");
    }


    /**
     * 失败
     */
    public static <T> Result<T> fail() {
        return new Result<T>(false, 500, "系统内部错误");
    }

    /**
     * 失败
     */
    public static <T> Result<T> fail(String message) {
        return new Result<T>(false, 500, message);
    }

    /**
     * 失败
     */
    public static <T> Result<T> fail(int code, String message) {
        return new Result<T>(false, code, message);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

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

