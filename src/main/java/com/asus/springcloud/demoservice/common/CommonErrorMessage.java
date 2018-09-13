package com.asus.springcloud.demoservice.common;

/**
 * @author kevinli
 * @date 2018/1/22
 */
public class CommonErrorMessage {
    /**
     * 通用
     */
    public static final CommonErrorMessage MISS_PARAMETER_ERR = new CommonErrorMessage("缺少参数！", -101);

    private String msg;
    private int code;

    public CommonErrorMessage(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }
}
