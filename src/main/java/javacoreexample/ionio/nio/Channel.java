package javacoreexample.ionio.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;

public class Channel {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int nextNumber = 0;

        do {
            System.out.println("\nWhat do you want?\n1 - NIO basic;" +
                    "\n2 - transfer;" +
                    "\n3 - ; \n4 - ; " +
                    "\n5 - exit.");
            nextNumber = sc.nextInt();
            switch (nextNumber) {
                case 1:
                    nioDemo();
                    break;
                case 2:
                    transferDemo();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Have a good day");
                    break;
                default:
                    System.out.println("wrong choice");
            }

        }
        while (nextNumber != 5);
    }

    public static void nioDemo() throws IOException{
        FileInputStream fileInputStream = new FileInputStream("files\\fileChannel.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("files\\fileOutputChannel.txt");

        FileChannel inFileChannel = fileInputStream.getChannel();
        FileChannel outFileChannel = fileOutputStream.getChannel();

        ByteBuffer inByteBuffer = ByteBuffer.allocate(4096);
        ByteBuffer outByteBuffer = ByteBuffer.allocate(4096);

        int read = inFileChannel.read(inByteBuffer);

        while (read != -1) {
            inByteBuffer.flip();
            while (inByteBuffer.hasRemaining()) {
                byte getBytes = inByteBuffer.get();
                outByteBuffer.put(getBytes);
            }
            outByteBuffer.flip();
            outFileChannel.write(outByteBuffer);
            inByteBuffer.clear();
            outByteBuffer.clear();

        }

        fileInputStream.close();
        fileOutputStream.close();
    }


    public static void transferDemo() throws IOException{
        FileInputStream fileInputStream = new FileInputStream("files\\fileChannel.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("files\\fileOutputChannel.txt");

        FileChannel inFileChannel = fileInputStream.getChannel();
        FileChannel outFileChannel = fileOutputStream.getChannel();

        inFileChannel.transferTo(0,inFileChannel.size(),outFileChannel);
//        outFileChannel.transferFrom(inFileChannel,0, inFileChannel.size());

        fileInputStream.close();
        fileOutputStream.close();
    }
}
