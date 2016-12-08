
public class Test2 {
public static void main(String[] args) {
	String path="financing/sendBargain/32895/10.00/";
	String a = path.replaceAll("\\d+", "{seqno}");
	System.out.println(a);
}
}
