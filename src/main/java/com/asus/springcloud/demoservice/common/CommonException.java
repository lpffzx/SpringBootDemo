package com.asus.springcloud.demoservice.common;

import com.asus.springcloud.demoservice.constant.Constants;

/**
 * @author kevinli
 * @date 2018/1/22
 */
public class CommonException extends Exception {
    private Integer code = Constants.ERROR_CODE;

    public CommonException() {
        super();
    }

    public CommonException(CommonErrorMessage message) {
        super(message.getMsg());
        this.code = message.getCode();
    }

    public CommonException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public CommonException(Throwable cause) {
        super(cause);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
