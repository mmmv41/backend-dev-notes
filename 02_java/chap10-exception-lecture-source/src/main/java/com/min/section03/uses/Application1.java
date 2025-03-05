package com.min.section03.uses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표
         *   예외처리를 많이 사용하는 io 패키지와 관련된 try-catch 구문을 이해할 수 있다. */
        /* 설명
         *   예외 처리를 가장 많이 사용하게 되는 상황(io 패키지 관련)에서 try-catch 구문을 실제 상황과 유사하게 연습해보자
         *   (입출력 관련 구문을 하나하나 신경쓰기 보다는 전체 흐름과 구조에 신경쓰기) */

        /* 설명
         *   프로젝트 바로 아래 경로에 test.dat 파일이 있다면 그걸 인지한 File 객체를 생성해 절대 경로를 출력한다.
         *   객체를 통해 파일과의 연결통로를 만들 예정*/
        System.out.println(new File("test.dat").getAbsolutePath()); // 파일 객체를 생성한다.

        // 속도 향상 및 추가 메서드
        // 이미 예외가 정의되어 있으므로 반드시 처리해줘야함
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader("test.dat"));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {

            /* 설명
             *   예외처리 구문과 상관없이 반드시 수행해야 하는 경우 finally에 작성하는데
             *   보통 사용한 자원(resource)를 반납하는 용도로 사용하게 된다. */
            try {
                if (br != null) {

                    /* 설명
                     *   입출력에서 사용한 스트림(통로)를 닫아주는 용도의 메서드이다.
                     *   스트림이 없을 때(null)를 고려하고 IOExcepion을 처리해야 제대로 쓸 수 있다 */
                    br.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
