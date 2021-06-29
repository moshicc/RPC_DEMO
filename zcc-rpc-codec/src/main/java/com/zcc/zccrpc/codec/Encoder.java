package com.zcc.zccrpc.codec;

/**
 * 序列化：把对象转成二进制数组
 */
public interface Encoder {
    byte[] encode(Object object);
}
