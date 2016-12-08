
public class Test1 {
	public String geta(){
		return "a";
	}
	public static void main(String[] args) {
		
		String a = parseDate("5");
		String begin ="";
		String end ="";
		if(a.contains(",")){
			 begin = a.substring(0,a.indexOf(","));
			 end = a.substring(a.indexOf(",")+1,a.length());
		}else{
			 begin = a.substring(0,a.length());
		}
		System.out.println(begin +" kkkk " + end);
	}
	private static String parseDate(String assetscale) {
		String a;
		switch(Integer.parseInt(assetscale)){
		case 1:
			a="0,100";
			break;
		case 2:
			a="100,200";
			break;
		case 3:
			a="200,500";
			break;
		case 4:
			a="500,1000";
			break;
		case 5:
			a="1000,3000";
			break;
		case 6:
			a="3000,10000";
			break;
		case 7:
			a="10000";
			break;
		default:
			a="0,10000";
			break;
		}
		return a;
	}
	
}
