import java.io.*;

public class FileWrite {
  public static void main(String[] args) {
    try {
      RandomAccessFile raf = new RandomAccessFile("hello.txt", "rw");
      raf.writeBytes("Hello, world!\n");
      raf.close();
    } 
    catch (IOException e) {
      e.printStackTrace();
    }
  }
}