package com.min.section02.stream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Application3 {
    public static void main(String[] args) {

        /* 수업목표
         *   FileReader 를 이해하고 활용하기 */
        FileReader fr = null;
        try {
            fr = new FileReader("src/main/java/com/min/section02/stream/testOutputSteam.txt");
//            int readChar = fr.read();
//            System.out.println((char) readChar);

            int readChar = 0;
            // -1 이면 EndOfFile
            while ((readChar = fr.read()) != -1) {
                System.out.println((char) readChar);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
