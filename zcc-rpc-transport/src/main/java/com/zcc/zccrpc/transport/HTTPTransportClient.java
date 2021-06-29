package com.zcc.zccrpc.transport;

import com.zcc.zccrpc.Peer;

import java.io.InputStream;

/**
 * 实现
 */
public class HTTPTransportClient implements TransportClient {
    @Override
    public void connect(Peer peer) {

    }

    @Override
    public InputStream write(InputStream data) {
        return null;
    }

    @Override
    public void close() {

    }
}
