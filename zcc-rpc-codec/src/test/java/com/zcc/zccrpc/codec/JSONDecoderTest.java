package com.zcc.zccrpc.codec;

import org.junit.Test;

import static org.junit.Assert.*;

public class JSONDecoderTest {

    @Test
    public void decode() {
        JSONEncoder encoder = new JSONEncoder();
        TestBean bean = new TestBean();
        bean.setName("zcc");
        bean.setAge(25);
        byte[] bytes = encoder.encode(bean);

        JSONDecoder decoder = new JSONDecoder();
        TestBean testBean = decoder.decode(bytes, TestBean.class);
        assertEquals(bean.getName(), testBean.getName());
        System.out.println(testBean.toString());
    }
}