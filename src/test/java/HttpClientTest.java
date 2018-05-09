import com.httpclient.HttpConnectionManager;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author sen.huang
 *         Date: 2018/5/10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "applicationContext-test.xml")
public class HttpClientTest {

    @Autowired
    private HttpConnectionManager connectionManager;

    @Test
    public void testHttpClient() throws Exception{
        CloseableHttpClient httpClient = connectionManager.getHttpClient();
        HttpGet get = new HttpGet("https://blog.csdn.net/zhuwukai/article/details/78644484");
        CloseableHttpResponse response = httpClient.execute(get);
        String string = EntityUtils.toString(response.getEntity());
        System.out.printf(string);
    }

}
