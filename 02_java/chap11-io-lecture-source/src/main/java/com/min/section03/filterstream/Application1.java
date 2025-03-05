package com.min.section03.filterstream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Application1 {

    public static void main(String[] args) {
        /* 수업목표
         *   BufferedWriter 와 BufferedReader 에 대해 이해하고 사용할 수 있다.*/
        /* 설명
         *   내부적으로 버퍼를 활용해서 입출력 성능을 향상 시킨다.
         *   추가적인 메서드가 제공된다. */

        /* 설명
         *   1. FileWriter 객체 생성 : 지정한 경로에 파일을 생성하고, 해당 파일에 데이터를 쓸 수 있도록
         *      지정한 경로에 파일이 없으면 생성, 경로가 존재하지 않으면 FileNotFoundException이 발생할 수 있다.
         *  2. BufferedWriter 래핑 : 내부적으로 버퍼를 활용하여 입출력 속도를 최적화하는 역할
         */
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(
                    new FileWriter(
                            "src/main/java/com/min/section03/filterstream/testBuffered.txt"));
            bw.write("눈이\n");
            bw.write("하늘에서\n");
            bw.write("내려오네\n");

            /* 설명 : 내부적으로 버퍼가 다 차지 않으면 출력으로 내보내지지 않는데, flush()를 호출해야 버퍼가 비워진다. */
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        BufferedReader br = null;
        try {
            br = new BufferedReader(
                    new FileReader("src/main/java/com/min/section03/filterstream/testBuffered.txt"));
//            String str = br.readLine(); // 문자열로 내보내고 한줄씩 읽는다
//            System.out.println(str);
            String str = "";
            while ((str = br.readLine()) != null) {
                System.out.println("str = " + str);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
