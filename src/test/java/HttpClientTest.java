import com.httpclient.HttpConnectionManager;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthSchemeProvider;
import org.apache.http.auth.AuthSchemeRegistry;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.AuthState;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.config.Lookup;
import org.apache.http.config.Registry;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.auth.BasicSchemeFactory;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.InputStream;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sen.huang
 *         Date: 2018/5/10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ="classpath:applicationContext-test.xml")
public class HttpClientTest {

    @Autowired
    private HttpConnectionManager connectionManager;

    @Test
    public void testAuth() throws Exception{
        CloseableHttpClient httpclient = HttpClients.createDefault();

        //凭证provider
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY,
                new UsernamePasswordCredentials("November22", "az18380461088"));
        //设置认证方案
//        Lookup<AuthSchemeProvider> authRegistry = <...>
        //认证缓存
        AuthCache authCache = new BasicAuthCache();
        HttpClientContext clientContext = HttpClientContext.create();
        clientContext.setAuthCache(authCache);
        clientContext.setCredentialsProvider(credentialsProvider);
//        clientContext.setAuthSchemeRegistry(lookup);

        HttpGet httpget = new HttpGet("https://blog.csdn.net");
        CloseableHttpResponse response1 = httpclient.execute(httpget, clientContext);
        AuthState proxyAuthState = clientContext.getProxyAuthState();
        System.out.println("Proxy auth state: " + proxyAuthState.getState());
        System.out.println("Proxy auth scheme: " + proxyAuthState.getAuthScheme());
        System.out.println("Proxy auth credentials: " + proxyAuthState.getCredentials());
        AuthState targetAuthState = clientContext.getTargetAuthState();
        System.out.println("Target auth state: " + targetAuthState.getState());
        System.out.println("Target auth scheme: " + targetAuthState.getAuthScheme());
        System.out.println("Target auth credentials: " + targetAuthState.getCredentials());

    }

    @Test
    public void testConnectionTime2() throws Exception{
        System.out.println("开始了");
        List<String> urls = new ArrayList<String>();
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");

        long start = System.currentTimeMillis();
        for(String url:urls){
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet get = new HttpGet(url);
            httpClient.execute(get);
            get.releaseConnection();
        }
        long end = System.currentTimeMillis();
        System.out.println("nopool"+(end-start));
    }

    @Test
    public void testConnectionTimePool() throws Exception{
        List<String> urls = new ArrayList<String>();
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");
        urls.add("https://blog.csdn.net/zhuwukai/article/details/78644484");

        long start = System.currentTimeMillis();
        for(String url:urls){
            CloseableHttpClient httpClient = connectionManager.getHttpClient();
            HttpGet get = new HttpGet(url);
            httpClient.execute(get);
            get.releaseConnection();
        }
        long end = System.currentTimeMillis();
        System.out.println("pool"+(end-start));
    }

    @Test
    public void testRedirect() throws Exception{
        BasicHttpContext basicHttpContext = new BasicHttpContext();
        HttpClientContext clientContext = HttpClientContext.adapt(basicHttpContext);
        CloseableHttpClient httpClient = connectionManager.getHttpClient();
        HttpGet get = new HttpGet("https://blog.csdn.net/zhuwukai/article/details/78644484");
        CloseableHttpResponse response = httpClient.execute(get,clientContext);
        URI resolve = URIUtils.resolve(get.getURI(),
                clientContext.getTargetHost(),
                clientContext.getRedirectLocations());
        System.out.println(resolve.toASCIIString());
    }

    @Test
    public void testForm() throws Exception{
        BasicHttpContext basicHttpContext = new BasicHttpContext();
        HttpClientContext context = HttpClientContext.adapt(basicHttpContext);

        CloseableHttpClient httpClient = connectionManager.getHttpClient();
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add( new BasicNameValuePair("username","November22"));
        params.add( new BasicNameValuePair("password","az18380461088"));
        UrlEncodedFormEntity encodedFormEntity = new UrlEncodedFormEntity(params, "UTF-8");
        HttpPost post = new HttpPost("https://passport.csdn.net/account/verify;jsessionid=430FDDAAD3308555726AC7045DE82458.tomcat1");
        post.setEntity(encodedFormEntity);
        CloseableHttpResponse response = httpClient.execute(post,context);
        post.abort();
        System.out.println(response.getAllHeaders());
        System.out.println(response.getEntity());
        System.out.println(context.getAuthCache());
        CloseableHttpClient httpClient2 = connectionManager.getHttpClient();
        HttpPost post2 = new HttpPost("https://passport.csdn.net/account/verify");
        CloseableHttpResponse response2 = httpClient2.execute(post2,context);
    }

    @Test
    public void testBufferedEntity() throws Exception{
        CloseableHttpClient httpClient = connectionManager.getHttpClient();
        HttpGet get = new HttpGet("https://blog.csdn.net/zhuwukai/article/details/78644484");
        CloseableHttpResponse response = httpClient.execute(get);
        HttpEntity entity = response.getEntity();
        BufferedHttpEntity bufferedHttpEntity = new BufferedHttpEntity(entity);
        byte[] bytes = EntityUtils.toByteArray(bufferedHttpEntity);//传入两次entity会报错，stream is closed
        byte[] bytes1 = EntityUtils.toByteArray(bufferedHttpEntity);
        System.out.println(bytes.length);
        System.out.println(bytes1.length);
    }

    @Test
    public void testHttpEntiy() throws Exception{
        CloseableHttpClient httpClient = connectionManager.getHttpClient();
        HttpGet get = new HttpGet("https://blog.csdn.net/zhuwukai/article/details/78644484");
        CloseableHttpResponse response = httpClient.execute(get);
        HttpEntity entity = response.getEntity();
        System.out.println(entity.getContentType());
        System.out.println(entity.getContentEncoding());
        System.out.println(entity.getContentLength());
        System.out.println(entity.getContent());
    }

    @Test
    public void testURIBuilder() throws Exception{
        //URI便捷工具
        URI uri = new URIBuilder()
                .setScheme("https")
                .setHost("www.baidu.com")
                .setPath("/baidu")
                .setParameter("tn", "monline_3_dg")
                .setParameter("ie", "utf-8")
                .setParameter("wd", "httpclient+易踪")
                .build();
        HttpPost post = new HttpPost(uri);
        System.out.println(post.getURI());
        CloseableHttpClient httpClient = connectionManager.getHttpClient();
        CloseableHttpResponse response = httpClient.execute(post);
        //获取响应信息
        System.out.println(response.getProtocolVersion());
        System.out.println(response.getStatusLine().getStatusCode());
    }

    @Test
    public void testHttpClient() throws Exception{
        CloseableHttpClient httpClient = connectionManager.getHttpClient();
        HttpGet get = new HttpGet("https://blog.csdn.net/zhuwukai/article/details/78644484");
        CloseableHttpResponse response = httpClient.execute(get);
        String string = EntityUtils.toString(response.getEntity());

    }



}
