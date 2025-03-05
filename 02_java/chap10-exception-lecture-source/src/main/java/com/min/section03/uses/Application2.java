package com.min.section03.uses;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Application2 {
    public static void main(String[] args) {

        /* 수업목표
         *   try-with-resource 구문을 이해하고 활용하기 (finally 안씀) */
        try (BufferedReader reader = new BufferedReader(new FileReader("test.dat"))) {

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
