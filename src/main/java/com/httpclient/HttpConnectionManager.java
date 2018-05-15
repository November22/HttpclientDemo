package com.httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.net.ssl.SSLContext;
import java.security.NoSuchAlgorithmException;

/**
 * @author sen.huang
 *         Date: 2018/5/9
 */
@Component
public class HttpConnectionManager {
    PoolingHttpClientConnectionManager clientConnectionManager = null;
    ConnectionKeepAliveStrategy keepAliveStrategy = null;
    @PostConstruct
    public void init(){
        //设置连接保存时间
        keepAliveStrategy = new DefaultConnectionKeepAliveStrategy(){
            @Override
            public long getKeepAliveDuration(
                    HttpResponse response,
                    HttpContext context) {
                long keepAlive = super.getKeepAliveDuration(response, context);
                if (keepAlive == -1) {
                    //如果服务器没有设置keep-alive这个参数，我们就把它设置成5秒
                    keepAlive = 5000;
                }
                return keepAlive;
            }
        };

        LayeredConnectionSocketFactory sslsf = null;
        try {
            sslsf = new SSLConnectionSocketFactory(SSLContext.getDefault());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder
                .<ConnectionSocketFactory>create()
                .register("https",sslsf)
                .register("http", new PlainConnectionSocketFactory())
                .build();
        clientConnectionManager =new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        clientConnectionManager.setMaxTotal(200);
        clientConnectionManager.setDefaultMaxPerRoute(20);

    }
    public CloseableHttpClient getHttpClient() {
        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(clientConnectionManager)
                .setKeepAliveStrategy(keepAliveStrategy)//设置默认的连接保存时间
                .build();

        /*CloseableHttpClient httpClient = HttpClients.createDefault();//如果不采用连接池就是这种方式获取连接*/
        return httpClient;
    }
}
