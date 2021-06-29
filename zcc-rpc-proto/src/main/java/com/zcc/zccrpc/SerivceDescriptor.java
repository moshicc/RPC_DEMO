package com.zcc.zccrpc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 表示服务
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SerivceDescriptor {
    //服务的对象
    private String clazz;
    //服务的方法
    private String method;
    //服务的返回值类型
    private String returnType;
    //服务的参数类型
    private String[] parameterType;
}
