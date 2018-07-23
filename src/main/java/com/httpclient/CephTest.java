package com.httpclient;

import org.apache.http.client.methods.HttpHead;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;

/**
 * @author sen.huang
 * @date 2018/7/23.
 */
public class CephTest {
    private static final String SERVICE = "http://qargwapi.tc.yp:30231";
    private static final String KEY = "Basic cb4db4f3ea353a111a7b8379341a8de8c24e6d90f34e56f3c183a07734b0086503044eea0c672f14df1358a78b730472ef5e0b5a0c20b6cbb78b9300c56676889ea1e9fde8f5d7658bcdfa4b4a653734";
    public static final String BUCKETS = "/api/v1/storage/buckets";

    public static void main(String[] args) throws Exception {
        int i = 1;
        do {
            String infoUrl = SERVICE + "/api/v1/storage/buckets/#bucket#/files/#file#"
                    .replace("#bucket#","fxyeepay-cbp-devfile")
                    .replace("#file#","boss/template/java_pid39924_Leak_Suspects.zip");
            String baiduUrl = "https://www.baidu.com/";
            CloseableHttpClient client = HttpClients.createDefault();
            HttpHead httpHead = new HttpHead(baiduUrl);
            httpHead.addHeader(new BasicHeader("Authorization", KEY));
            client.execute(httpHead);
            client.getConnectionManager().shutdown();
            System.out.println("执行测试["+i+"]");
            i++;
        } while (i<400);
    }
}
