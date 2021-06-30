package com.zcc.zccrpc.server;


import com.zcc.zccrpc.Request;
import com.zcc.zccrpc.ServiceDescriptor;
import com.zcc.zccrpc.common.utils.ReflectionUtils;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 管理rpc暴露的服务
 * 一个注册服务的方法
 * 一个查找服务的方法
 */
@Slf4j
public class ServiceManager {
    //注册服务的服务放到map中,k:服务的描述，v:一个service具体的实现
    private Map<ServiceDescriptor, ServiceInstance> services;

    public ServiceManager() {
        this.services = new ConcurrentHashMap<>();
    }

    //注册方法 ，args: 自定一个接口, 服务具体的提供者.
    // 第一个参数是一个接口的class，第二参数是这个接口具体实现的子类的对象.用泛型T两者关联起来
    public <T> void register(Class<T> interfaceClass, T bean) {
        //step1：把接口中所有的方法扫描出来
        Method[] methods = ReflectionUtils.getPublicMethods(interfaceClass);
        //step2：扫描出来的方法 和bean绑定起来 形成一个ServiceInstance
        for (Method method : methods) {
            ServiceInstance sis = new ServiceInstance(bean, method);
            ServiceDescriptor sdp = ServiceDescriptor.from(interfaceClass, method);
            //step3: 把ServiceInstance 放到map中 (用ServiceDescriptor生成key)
            services.put(sdp, sis);
            log.info("register service :{} {}", sdp.getClazz(), sdp.getMethod());
        }
    }
    //查找
    public ServiceInstance lookup(Request request) {
        ServiceDescriptor sdp = request.getService();
        //用ServiceDescriptor 的equls 方法来判断的，所以要重写equls
        return services.get(sdp);
    }
}
