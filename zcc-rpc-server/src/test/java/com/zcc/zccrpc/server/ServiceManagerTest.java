package com.zcc.zccrpc.server;

import com.zcc.zccrpc.Request;
import com.zcc.zccrpc.ServiceDescriptor;
import com.zcc.zccrpc.common.utils.ReflectionUtils;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.assertNotNull;

public class ServiceManagerTest {
    ServiceManager sm;

    //在测试之前调用这个方法
    @Before
    public void init(){
        sm = new ServiceManager();

        // step2： sm注册进服务
        TestInterface bean = new TestClass();
        sm.register(TestInterface.class, bean);
    }

    //第一个参数是一个接口的class，第二参数是这个接口具体实现的子类的对象.
    @Test
    public void register() {
        TestInterface bean = new TestClass();
        sm.register(TestInterface.class, bean);
    }

    @Test
    public void lookup() {
        Method method = ReflectionUtils.getPublicMethods(TestInterface.class)[0];
        ServiceDescriptor sdp = ServiceDescriptor.from(TestInterface.class, method);
        //step1：构建request对象
        Request request = new Request();
        request.setService(sdp);
        // step2： sm注册进服务
        ServiceInstance instance = sm.lookup(request);
        assertNotNull(instance);


    }
}