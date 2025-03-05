package com.min.section02.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표
         *   FileInputStream 를 이해할 수 있다. */
        FileInputStream fis = null;

        // 파일이 없을때의 예외 처리 (FilNotFoundException)
        try {
            fis = new FileInputStream("src/main/java/com/min/section02/stream/testInputStream.txt");
//            System.out.println((char) fis.read()); // 1바이트씩 읽어서 -> int 형으로 반환
//            System.out.println((char) fis.read());
//            System.out.println((char) fis.read());
//            System.out.println((char) fis.read());
//            System.out.println((char) fis.read());

            /* 설명
             *  반복횟수를 셀 필요없이 반환값을 이용하여 EOF(End Of File)를 처리할 수 있다.
             */
            int input = 0;
            while ((input = fis.read()) != -1) {
                System.out.println((char) fis.read());
            }
        } catch (FileNotFoundException e) {
            System.out.println("파일 경로 잘 확인할 것");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fis != null) {
                    fis.close();  // 리소스 낭비 방지
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
