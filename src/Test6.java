import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test6 {
	public static void main(String[] args) {
		Map<String,Object> m = new HashMap<String,Object>();
		m.put("a", 3);
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		list.add(m);
		m.put("a", 5);
		 for(Map<String,Object> ms:list){
	        	//对理财跟进特殊处理
			 System.out.println(ms);
		 }
	}
}
