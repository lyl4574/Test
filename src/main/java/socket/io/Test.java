package socket.io;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException {
//        byteReadWrite();
        stringReadWrite();
    }

    /**
     * 字节流读取，每次读取1kb；
     * @throws IOException
     */
    public static void byteReadWrite()throws IOException {
        InputStream fis =  new FileInputStream("D:\\ss.txt");
        OutputStream fos = new FileOutputStream("D:\\target.txt");
        byte[] bytes = new byte[1024];
        while (fis.read(bytes) != -1) {
            fos.write(bytes);
        }
        fos.flush();
        fis.close();
        fos.close();
    }

    /**
     * 字符流读取，每次读取1k字符；乱码
     * @throws IOException
     */
    public static void stringReadWrite()throws IOException {
        Reader reader =  new FileReader("D:\\ss.txt");
        Writer writer = new FileWriter("D:\\target.txt");
        char[] chars = new char[1024];
        while (reader.read(chars) != -1) {
            writer.write(chars);
        }
        writer.flush();
        writer.close();
        reader.close();
    }
}
