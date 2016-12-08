import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test3 {
public static void main(String[] args) {
	String follow = "sss,liyunlong";
	String loginname = "liyunlong";
//	follow =	follow.substring(1, follow.length());
//	follow = follow.replace(loginname, "");
//	if(follow.charAt(follow.length()-1)==','){
//		follow = follow.substring(0, follow.length()-1);
//	}
	ArrayList<String> followList =new ArrayList( Arrays.asList(follow.split(",")));
	if(followList.size()>0 && followList.contains(loginname)){
		followList.remove(loginname);
	}
	System.out.println(follow);
}
}
