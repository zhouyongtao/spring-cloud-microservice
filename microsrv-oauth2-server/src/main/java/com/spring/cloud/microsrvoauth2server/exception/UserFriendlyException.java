package com.spring.cloud.microsrvoauth2server.exception;

import lombok.Data;

import java.io.Serializable;

/**
 * 自定义异常
 *
 * @author： irving
 * @date： 2018/9/19 14:17
 * @version: v1.0
 */
@Data
public class UserFriendlyException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;

    private String msg;

    private Integer code;

    public UserFriendlyException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public UserFriendlyException(Integer code, String message) {
        super(message);
        this.code = code;
    }


    public UserFriendlyException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public UserFriendlyException(int code, String msg) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public UserFriendlyException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }
}
