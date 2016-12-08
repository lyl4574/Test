

import java.io.IOException;
import java.io.PrintWriter;  
public class Test5 {  
    public static void main(String[] args) throws IOException {  
        System.out.println("请输入：");  
        int i = 0;  
        while(i!=-1){//读取输入流中的字节直到流的末尾返回1  
            i = System.in.read();  
            System.out.println(i);  
        }  
//       PrintWriter pw = new PrintWriter("D:/a.txt");
    }  
} 
