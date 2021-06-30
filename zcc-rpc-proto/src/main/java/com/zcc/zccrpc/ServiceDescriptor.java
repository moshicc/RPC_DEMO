package com.zcc.zccrpc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 表示服务
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDescriptor {
    //服务的对象
    private String clazz;
    //服务的方法
    private String method;
    //服务的返回值类型
    private String returnType;
    //服务的参数类型
    private String[] parameterType;

    public static ServiceDescriptor from(Class clazz, Method method) {
        ServiceDescriptor sdp = new ServiceDescriptor();
        sdp.setClazz(clazz.getName());
        sdp.setMethod(method.getName());
        sdp.setReturnType(method.getReturnType().getName());

        Class<?>[] types = method.getParameterTypes();
        String[] parameterType = new String[types.length];
       // parameterType = Arrays.stream(types).toArray(String[] :: new);
        for (int i = 0; i < types.length; i++) {
            parameterType[i] = types[i].getName();
        }
        sdp.setParameterType(parameterType);

        return sdp;
    }

    //step1 :  因为用equls方法比较，所以重equls方法
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        //这个情况排除完了，说明两个类型肯定相同
        if (o == null || getClass() != o.getClass()) return false;
        //所以可以强转
        ServiceDescriptor that = (ServiceDescriptor) o;

        //简单判断两个字符串是否相同
        return this.toString().equals(that.toString());


    }
    //step2：因为equls比较时用到hashCode
    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public String toString() {
        return "ServiceDescriptor{" +
                "clazz='" + clazz + '\'' +
                ", method='" + method + '\'' +
                ", returnType='" + returnType + '\'' +
                ", parameterType=" + Arrays.toString(parameterType) +
                '}';
    }
}
