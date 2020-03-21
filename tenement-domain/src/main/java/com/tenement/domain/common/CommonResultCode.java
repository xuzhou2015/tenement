package com.tenement.domain.common;

import com.tenement.domain.dto.ResultCode;

/**
 * @author ：徐周
 * @date ：Created in 2019/12/20 20:28
 * @description：c
 */
public enum  CommonResultCode implements ResultCode {
    SUCCESS(1, "请求成功"),

    FAILURE(0, "服务器玩命加载中，请稍后重试"),

    ILLEGAL_REQ_PARAMETER(2, "非法的请求参数"),

    USER_REPETITION(4, "此用户名已存在"),

    DUPLICATE_KEY(3, "唯一校验失败,请检查是否存在同样的数据"),

    LONING(4, "请先登陆用户！");



    /**
     * 结果码
     */
    private int code;

    /**
     * 状态码
     */
    private int statusCode;

    /**
     * 结果消息
     */
    private String msg;

    CommonResultCode(int code, String msg) {
        this(code, -1, msg);
    }

    CommonResultCode(int code, int statusCode, String msg) {
        this.code = code;
        this.statusCode = statusCode;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public int getStatusCode() {
        return statusCode;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
