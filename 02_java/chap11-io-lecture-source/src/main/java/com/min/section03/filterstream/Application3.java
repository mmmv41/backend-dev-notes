package com.min.section03.filterstream;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Application3 {
    public static void main(String[] args) {

        /* 수업목표
         *   데이터 타입 입출력 보조 스트림을 이해하고 활용할 수 있다.*/
        /* 설명
         *   int, char 등 데이터 단위로 쏠 수 있다.
         *   읽을 때 썼던 데이터 타입의 순서대로 출력해야 한다. */
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(
                    new FileOutputStream("src/main/java/com/min/section03/filterstream/testData.txt"));
            dos.writeUTF("홍길동");
            dos.writeInt(20);
            dos.writeChar('A');

            dos.writeUTF("유관순");
            dos.writeInt(16);
            dos.writeChar('A');

            dos.writeUTF("강감찬");
            dos.writeInt(38);
            dos.writeChar('A');


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (dos != null) {
                    dos.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
