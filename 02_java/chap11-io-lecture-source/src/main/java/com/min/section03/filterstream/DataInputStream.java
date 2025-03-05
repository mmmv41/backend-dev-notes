//package com.min.section03.filestream;
//
//import java.io.EOFException;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//
//public class DataInputStream {
//    public static void main(String[] args) {
//
//        DataInputStream dis = null;
//
//        try {
//            dis = new DataInputStream(
//                    new FileInputStream("src/main/java/com/ohgiraffers/section03/filterstream/testData.txt"));
//            while (true) {
//
//                /* 설명
//                 *   출력했던 데이터 단위를 지켜서 입력해야 온전히 데이터를 읽어들일 수 있다. */
//                System.out.println(dis.readUTF());
//                System.out.println(dis.readInt());
//                System.out.println(dis.readChar());
//            }
//        } catch (EOFException e) {
//
//            /* 설명
//             *   data 단위 입출력은 EOF를 EOFException 처리를 통해 확인하고 처리할 수 있다. */
//            System.out.println("데이터 파일 읽기 완료!");
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } finally {
//            try {
//                if (dis != null) {
//                    dis.close();
//                }
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//}
