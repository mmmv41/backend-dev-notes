package com.min.section06.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Application1 {
    public static void main(String[] args) {
        /* 수업목표
         *   time 패키지에서 제공하는 클래스들의 사용 방법을 이해할 수 있다. */
        LocalTime timeNow = LocalTime.now();
        LocalTime timeNow2 = LocalTime.of(14, 33, 20);
        System.out.println("timeNow = " + timeNow);
        System.out.println("timeNow2 = " + timeNow2);

        LocalDate dateNow = LocalDate.now();
        LocalDate dateOf = LocalDate.of(2025, 2, 5);    // month에 -1을 해줄 필요가 없다.
        System.out.println("dateNow = " + dateNow);
        System.out.println("dateOf = " + dateOf);

        LocalDateTime dateTimeNow = LocalDateTime.now();
        LocalDateTime dateTimeOf = LocalDateTime.of(2025, 2, 5, 14, 20);    // month에 -1을 해줄 필요가 없다.
        System.out.println("dateTimeNow = " + dateTimeNow);
        System.out.println("dateTimeOf = " + dateTimeOf);

        ZonedDateTime zonedDateTimeNow = ZonedDateTime.now();
        ZonedDateTime zonedDateTimeOf = ZonedDateTime.of(dateOf, timeNow2, ZoneId.of("Asia/Seoul"));
        System.out.println("zonedDateTimeNow = " + zonedDateTimeNow);
        System.out.println("zonedDateTimeOf = " + zonedDateTimeOf);

    }
}
