package http;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.alibaba.fastjson.JSONReader;
import com.alibaba.fastjson.parser.DefaultJSONParser;

public class MyHttpClient {

	public static final String AppID = "wx5e2b92eadde582c5";
	public static final String AppSecret = "f97094955553bdd922a19dcf66f12311";

	public interface HttpClientCallback {
		void callback(int code, String msg, Object obj);
	}

	public static void main(String[] args) {
		doAccessTokenUpdate(null);
	}

	/**
	 * https请求方式: GET
	 * https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
	 */
	public static void doAccessTokenUpdate(final HttpClientCallback callback) {

		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				String updateAccessTokenUrl = "https://api.weixin.qq.com/cgi-bin/token"
						+ "?grant_type=client_credential" + "&appid=" + AppID + "&secret=" + AppSecret;

				// updateAccessTokenUrl =
				// "http://47.104.29.233/MyWebProject/msg?key=hello_world";
				try {

					HttpClient client = HttpClients.createDefault();
					HttpGet httpGet = new HttpGet(updateAccessTokenUrl);

					HttpResponse response = client.execute(httpGet);

					HttpEntity entity = response.getEntity();

					System.out.println("code :" + response.getStatusLine().getStatusCode());

					long len = entity.getContentLength();
					System.out.println("len :" + len);
					String result = EntityUtils.toString(entity, "UTF-8");

					System.out.println("result :" + result);

					JSONReader jsonReader = new JSONReader(new DefaultJSONParser(result));

					AccessTokenBean obj = jsonReader.readObject(AccessTokenBean.class);// 根据
																						// java
																						// bean
																						// 来解析
					String begin_int = obj.getAccess_token();
					String end_int = obj.getExpires_in();
					System.out.println("begin_int:" + begin_int + ", end_int" + end_int);
					jsonReader.close();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();

	}

	public static Map<String, String> parseXml(InputStream inputStream) throws IOException, DocumentException {
		// 将解析结果存储在HashMap中
		Map<String, String> map = new HashMap<String, String>();
		// 从request中取得输入流
		// 读取输入流
		SAXReader reader = new SAXReader();
		Document document = reader.read(inputStream);
		// 得到xml根元素
		Element root = document.getRootElement();
		// 得到根元素的所有子节点
		List<Element> elementList = root.elements();

		// 遍历所有子节点
		for (Element e : elementList) {
			System.out.println(e.getName() + " | " + e.getText());
			map.put(e.getName(), e.getText());
		}

		// 释放资源
		inputStream.close();
		inputStream = null;
		return map;
	}

}
