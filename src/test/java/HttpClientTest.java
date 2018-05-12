import com.httpclient.HttpConnectionManager;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.URI;

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
    public void testURIBuilder() throws Exception{
        URI uri = new URIBuilder()
                .setScheme("https")
                .setHost("www.baidu.com")
                .setPath("baidu")
                .setParameter("tn", "monline_3_dg")
                .setParameter("ie", "utf-8")
                .setParameter("wd", "httpclient+易踪")
                .build();
        HttpPost post = new HttpPost(uri);
        System.out.println(post.getURI());
    }

    @Test
    public void testHttpClient() throws Exception{
        CloseableHttpClient httpClient = connectionManager.getHttpClient();
        HttpGet get = new HttpGet("https://blog.csdn.net/zhuwukai/article/details/78644484");
        CloseableHttpResponse response = httpClient.execute(get);
        String string = EntityUtils.toString(response.getEntity());

    }



}
