package com.zcc.zccrpc.codec;

import com.alibaba.fastjson.JSON;

/**
 * 基于json的序列化是实现
 */
public class JSONEncoder implements Encoder {
    @Override
    public byte[] encode(Object object) {
        //把一个对象 转成json字符串的byte数组
        return JSON.toJSONBytes(object);
    }
}
