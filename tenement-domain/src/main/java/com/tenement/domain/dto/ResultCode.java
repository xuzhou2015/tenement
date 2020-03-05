package com.tenement.domain.dto;

public interface ResultCode {
    /**
     * 获取结果码
     * @return
     */
    int getCode();

    /**
     * 获取状态码
     * @return
     */
    int getStatusCode();

    /**
     * 获取MSG
     * @return
     */
    String getMsg();
}
