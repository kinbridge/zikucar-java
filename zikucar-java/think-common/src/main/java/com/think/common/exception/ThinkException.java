package com.think.common.exception;

/**
 * @author bridge
 * @Date 2021/10/16/12:39
 */
public class ThinkException extends RuntimeException {
    /**
     * 异常编码
     */
    private String code;

    public ThinkException( String code,String msg) {
        super(msg);
        this.code = code;
    }

    public ThinkException(String msg) {
        super(msg);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
