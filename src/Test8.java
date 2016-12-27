import java.util.Properties;
import java.util.Set;

public class Test8 {
	public static void main(String[] args) {
//		Properties p1 = new Properties();
//		p1.setProperty("name", "liyunlong");
		Properties p = System.getProperties();
		Set<Object> set = p.keySet();
		for(Object o :set){
			System.out.println(o.toString() + "|" + System.getProperty(o.toString()));
		}
		
	}
}
