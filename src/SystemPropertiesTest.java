import java.util.Properties;
import java.util.Set;

public class SystemPropertiesTest {
	public static void main(String[] args) {
//		Properties p1 = new Properties();
//		p1.setProperty("name", "liyunlong");
		Properties p = System.getProperties();
		Set<Object> set = p.keySet();
		for(Object o :set){
			System.out.println(o.toString() + "|" + System.getProperty(o.toString()));
		}
		System.out.println(Runtime.getRuntime().maxMemory()/1024.0/1024);
		System.out.println(Runtime.getRuntime().freeMemory()/1024.0/1024);
		System.out.println(Runtime.getRuntime().totalMemory()/1024.0/1024);
	}
}
