package com.zcc.zccrpc.codec;

import org.junit.Test;

import static org.junit.Assert.*;

public class JSONEncoderTest {

    @Test
    public void encode() {
        JSONEncoder encoder = new JSONEncoder();
        TestBean bean = new TestBean();
        bean.setName("zcc");
        bean.setAge(25);
        byte[] bytes = encoder.encode(bean);
        assertNotNull(bytes);

    }
}