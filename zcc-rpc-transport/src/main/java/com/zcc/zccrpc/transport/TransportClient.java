package com.zcc.zccrpc.transport;

import com.zcc.zccrpc.Peer;

import java.io.InputStream;

/**
 * client连接
 * 1. 创建连接
 * 2. 发送数据，并且等待响应
 * 3. 关闭连接
 */
public interface TransportClient {
    //创建连接
    void connect(Peer peer);
    //写数据,等待响应
    InputStream write(InputStream data);
    //关闭连接
    void close();

}
