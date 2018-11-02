package thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Task implements Runnable {
	int i;
	public Task(int i){
		this.i=i;
	}
	@Override
	public void run() {
		try {
//			Thread.sleep(i*100);
			long beginTime = System.currentTimeMillis();
//			System.out.println(Thread.currentThread().getName() + "开始执行");
			URL url = new URL("http://localhost:8081/oss-service/getSignedUrl?bucketName=dmdata-qa&objectName=tag%2F8713f86e42fa495c9b186b65aa1872d8.jpg");
			URLConnection conn = url.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while (-1!=in.read()) {
				System.out.println(in.readLine());
				in.readLine();
			}
			System.out.println(Thread.currentThread().getName()+ "耗时：" + (System.currentTimeMillis()-beginTime));
		} catch ( MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
