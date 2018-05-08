package com.httpclient;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @author sen.huang
 * @date 2018/5/8.
 */
public class HttpTest {
    public static void main(String[] args) throws Exception {
        HttpGet get = new HttpGet("https://blog.csdn.net/zhuwukai/article/details/78644484");
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = httpClient.execute(get);
        String s = EntityUtils.toString(response.getEntity());
        System.out.println(s);
    }
}
