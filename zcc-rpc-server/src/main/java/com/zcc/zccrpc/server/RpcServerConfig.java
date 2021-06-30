package com.zcc.zccrpc.server;

import com.zcc.zccrpc.codec.Decoder;
import com.zcc.zccrpc.codec.Encoder;
import com.zcc.zccrpc.codec.JSONDecoder;
import com.zcc.zccrpc.codec.JSONEncoder;
import com.zcc.zccrpc.transport.HttpTransportServer;
import com.zcc.zccrpc.transport.TransportServer;
import lombok.Data;

/**
 * server配置
 */
@Data
public class RpcServerConfig {
    //使用的网络模块
    private Class<? extends TransportServer> transportClass = HttpTransportServer.class;
    //使用哪个序列化实现
    private Class<? extends Encoder> encoderClass = JSONEncoder.class;
    private Class<? extends Decoder> decoderClass = JSONDecoder.class;
    //baseServer启动之后监听什么端口
    private int port = 3000;
}
