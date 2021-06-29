package com.zcc.zccrpc.transport;

/**
 * server功能
 * 1. 启动、监听端口
 * 2. 等待网络客户端连接，接受请求，处理。(接受请求的接受的是个InputStream ，byte数据流，需要抽象成一个handler，让用模块的人来实现)
 * 3. 关闭监听
 */
public interface TransportServer {
    //在server初始化的时候 传入request
    void init(int port, RequestHandler handler);

    //启动
    void start();



    //关闭
    void stop();
}
