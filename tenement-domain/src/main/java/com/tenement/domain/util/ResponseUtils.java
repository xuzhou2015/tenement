package com.tenement.domain.util;

import com.tenement.domain.common.CommonResultCode;
import com.tenement.domain.common.Response;
import com.tenement.domain.dto.ResultCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：徐周
 * @date ：Created in 2019/12/20 20:27
 * @description：cc
 */
public class ResponseUtils {
    public static Response createSuccess() {
        return create(CommonResultCode.SUCCESS);
    }

    public static <T> Response<T> createSuccess(T data) {
        return create(CommonResultCode.SUCCESS, data);
    }

    public static <T> Response<List<T>> createSuccessList(List<T> data) {
        Response<List<T>> resp = new Response<>();
        resp.setCode(CommonResultCode.SUCCESS.getCode());
        resp.setMsg(CommonResultCode.SUCCESS.getMsg());
        resp.setData(data == null ? new ArrayList<>() : data);
        return resp;
    }


    public static Response createFailure() {
        return create(CommonResultCode.FAILURE);
    }


    public static Response create(ResultCode resultCode) {
        return create(resultCode.getCode(), resultCode.getMsg());
    }

    public static <T> Response<T> create(ResultCode resultCode, T data) {
        return create(resultCode.getCode(), resultCode.getMsg(), data);
    }

    public static Response create(int code, String msg) {
        return create(code, msg, null);
    }

    public static <T> Response<T> create(int code, String msg, T data) {
        Response<T> resp = new Response<>();
        resp.setCode(code);
        resp.setMsg(msg);
        resp.setData(data);
        return resp;
    }
}
