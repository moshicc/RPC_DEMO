package com.zcc.zccrpc.codec;

/**
 * 反序列化：把二进制数组转成对象
 */
public interface Decoder {
    <T> T decode(byte[] bytes,Class<T> clazz);
}
