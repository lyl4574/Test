import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Test6 {
	public static void main(String[] args) throws IOException, InterruptedException {
		Map<String,Object> m = new HashMap<String,Object>();
		m.put("a", 3);
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		list.add(m);
		m.put("a", 5);
		 for(Map<String,Object> ms:list){
	        	//对理财跟进特殊处理
			 System.out.println(ms);
		 }
		 System.out.println(UUID.randomUUID());
		 BufferedReader br = null;
		 int i=1;
		 BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\a.txt"));
	
		 while (i!=0){
		  br =new BufferedReader(new InputStreamReader(System.in));
		  
		  String in = br.readLine();
		  Thread.sleep(1000);
			 bw.write(in);
			 bw.flush();
		 }
		 
		
		
	}
	
}
