package com.zcc.zccrpc.transport;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 处理网络请求的handler
 */
public interface RequestHandler {
    //args： 1.输入 2.输出数据
    void onRequest(InputStream recive, OutputStream outStream);
}
