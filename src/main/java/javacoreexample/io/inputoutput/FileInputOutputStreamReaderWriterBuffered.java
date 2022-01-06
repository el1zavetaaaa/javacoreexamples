package javacoreexample.io.inputoutput;

import java.io.*;
import java.util.Scanner;

public class FileInputOutputStreamReaderWriterBuffered {
    private static final String fileInputStreamAddress = "files\\fileInput.txt";
    private static final String fileOutputStreamAddress = "files\\fileOutput.txt";

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int nextNumber = 0;

        do {
            System.out.println("\nWhat do you want?\n1 - input and output streams;" +
                    "\n2 - reader and writer;" +
                    "\n3 - buffered reader and print writer; \n4 - encode bytes to String ; " +
                    "\n5 - exit.");
            nextNumber = sc.nextInt();
            switch (nextNumber) {
                case 1:
                    inputOutputStream();
                    break;
                case 2:
                    readerWriter();
                    break;
                case 3:
                    bufferedWriter();
                    break;
                case 4:
                    encodedDemo();
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

    private static void inputOutputStream() {
        try (FileInputStream fileInputStream = new FileInputStream(fileInputStreamAddress);
             FileOutputStream fileOutputStream = new FileOutputStream(fileOutputStreamAddress);) {
            int c;
            while (((c = fileInputStream.read()) != -1)) {
                fileOutputStream.write(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File are successfully worked!");
        }
    }

    private static void readerWriter() throws IOException {
        FileReader inputFile = null;
        FileWriter outputFile = null;

        try {
            inputFile = new FileReader(fileInputStreamAddress);
            outputFile = new FileWriter(fileOutputStreamAddress);
            int c;

            while ((c = inputFile.read()) != -1) {
                outputFile.write(c);
            }
        } finally {
            if (inputFile != null) {
                inputFile.close();
            }
            if (outputFile != null) {
                outputFile.close();
            }
            System.out.println("File are successfully worked!");
        }
    }

    private static void bufferedWriter() throws IOException {
        BufferedReader inputStream = null;
        PrintWriter outputWriter = null;

        try {
            inputStream = new BufferedReader(new FileReader(fileInputStreamAddress));
            outputWriter = new PrintWriter(new FileWriter(fileOutputStreamAddress));
            int c;

            while ((c = inputStream.read()) != -1) {
                outputWriter.write(c);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputWriter != null) {
                outputWriter.close();
            }
            System.out.println("File are successfully worked!");
        }
    }

    private static void encodedDemo() throws IOException {
        FileInputStream fis = new FileInputStream(fileInputStreamAddress);
        Reader fr = new InputStreamReader(fis, "utf-8");
        BufferedReader br = new BufferedReader(fr);

        String line = br.readLine();
        while (line != null) {
            System.out.println(line);
            line = br.readLine();
        }
        fis.close();
        fr.close();
        br.close();

    }
}
