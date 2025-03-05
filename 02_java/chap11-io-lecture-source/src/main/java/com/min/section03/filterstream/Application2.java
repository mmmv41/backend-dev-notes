package com.min.section03.filterstream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Application2 {
    public static void main(String[] args) {
        /* 수업목표
         *   표준입출력(콘솔과의 입출력)을 이해하고 활용할 수 있다. */
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        // 보조2(보조1(기반스트림)) 형태
        // System.in : 콘솔로 입력을 받기 위한 stream
        // InputStreamReader : inputstream 을 reader로 바꿔주는 역할 -> 바꾸면 버퍼드 리더 사용가능 -> 쓰는 이유 한글이 안깨지게 한글자씩 읽어오기 위함

        System.out.print("문자열 입력 : "); // System.out : 콘솔로 출력을 내보내는 기반스트림
        try {
            String input = br.readLine();
            System.out.println("input = " + input);
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

        BufferedWriter bw = null;
        OutputStreamWriter osw = null;
        osw = new OutputStreamWriter(System.out);
        bw = new BufferedWriter(osw);

        try {
            bw.write("println이 좋은 거구나 ~");
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

    }
}
