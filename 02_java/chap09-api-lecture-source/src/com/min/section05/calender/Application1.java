package com.min.section05.calender;

import java.text.SimpleDateFormat;
import java.util.Date;
// import java.sql.Date; // sql은 Date의 자손

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표
         *   java.util.Date 클래스 사용법을 이해하고 활용할 수 있다. */
        //java.util.Date today = new java.util.Date();  //import java.util.Date;을 통해 간단하게 작성 가능
        Date today = new Date();
        System.out.println("today = " + today);

        System.out.println("long 타입 시간: " + today.getTime());
        System.out.println("long 타입 시간을 활용한 Date: " + new java.util.Date(0L));
        System.out.println("long 타입 시간을 활용한 Date2: " + new java.util.Date(today.getTime()));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String todayFormat = sdf.format(today);
        System.out.println("todayFormat = " + todayFormat);

        /* 설명
         *   java.util.Date -> java.sql.Date (DB에 맞는 포맷으로 바꿀 때 */
        Date today2 = new Date();
        //java.sql.Date sqlDate = new java.sql.Date(today2.getTime());
        Date sqlDate = new Date(today2.getTime());

        /* 설명
         *   java.sql.Date -> java.util.Date
         *   다형성이 적용됨. java.sql.Date은 java.util.Date의 자손이다. */
        java.util.Date today3 = sqlDate;

    }
}
