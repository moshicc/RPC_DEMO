package com.zcc.zccrpc.server;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Method;

/**
 * 表示一个具体服务
 */
@Data
@AllArgsConstructor
public class ServiceInstance {
    //这个服务由哪个对象提供的
    private Object target;
    //这个对象的哪个方法暴露成一个服务
    private Method method;
}
