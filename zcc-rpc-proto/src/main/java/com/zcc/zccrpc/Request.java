package com.zcc.zccrpc;

import lombok.Data;

/**
 * 请求
 */
@Data
public class Request {
    //请求的服务
    private SerivceDescriptor service;
    //调用传的参数
    private Object[] parameters;
}
