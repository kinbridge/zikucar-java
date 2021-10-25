package com.think.common.enums;

/**
 * @author bridge
 * @Date 2021/10/16/12:30
 */
public enum ThinkErrorEnum {

    PARAMS_IS_NULL("PARAMS_IS_NULL","参数为空"),
    INCONSISTENT_PWD("INCONSISTENT_PWD","输入密码不一致"),
    PWD_IS_NULL("PWD_IS_NULL","密码为空"),
    USER_PWD_OR_IS_NULL("USER_PWD_IS_NULL","用户名或者密码为空"),
    UIN_IS_NULL("UIN_IS_NULL","用户账号为空"),
    USER_ERROR("USER_ERROR","用户名错误"),
    OLD_PWD_ERROR("OLD_PWD_ERROR","旧密码错误"),
    PWD_ERROR("PWD_ERROR","密码错误"),
    FILE_IS_NULL("FILE_IS_NULL"," 文件为空"),
    USER_INVALID("USER_ERROR","用户已失效"),
    ;

    /**
     *  编码
     */
    private String code;
    /**
     *  错误信息
     */
    private String msg;

    ThinkErrorEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
