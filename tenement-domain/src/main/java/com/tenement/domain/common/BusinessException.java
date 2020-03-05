package com.tenement.domain.common;

import com.tenement.domain.dto.ResultCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ：徐周
 * @date ：Created in 2019/12/20 20:18
 * @description：d
 */
@Setter
@Getter
public class BusinessException extends RuntimeException{
    /**
     * 响应码
     */
    private int rsCode;

    /**
     * 字符响应吗
     */
    private String rsCodeString;

    /**
     * 状态码
     */
    private int statusCode;

    /**
     * 响应消息
     */
    private String rsMsg;

    /**
     * 响应扩展信息
     */
    private String rsExtend;

    public BusinessException() {
        super();
    }

    public BusinessException(String msg) {
        super(msg);
    }

    public BusinessException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(ResultCode resultCode) {
        this(resultCode.getCode(), resultCode.getStatusCode(), resultCode.getMsg());
    }

    public BusinessException(ResultCode resultCode, Throwable cause) {
        this(resultCode.getCode(), resultCode.getStatusCode(), resultCode.getMsg(), cause);
    }
    public BusinessException(int rsCode, int statucCode, String rsMsg) {
        super("biz exception([" + rsCode + "," + statucCode + "]" + rsMsg + ")");
        this.rsCode = rsCode;
        this.statusCode = statucCode;
        this.rsMsg = rsMsg;
    }

    public BusinessException(int rsCode, int statucCode, String rsMsg, Throwable cause) {
        super("biz exception([" + rsCode + "," + statucCode + "]" + rsMsg + "):" + cause.getMessage(), cause);
        this.rsCode = rsCode;
        this.statusCode = statucCode;
        this.rsMsg = rsMsg;
    }
}
