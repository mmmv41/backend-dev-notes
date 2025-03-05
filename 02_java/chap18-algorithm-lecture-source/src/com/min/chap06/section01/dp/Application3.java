package com.min.chap06.section01.dp;

public class Application3 {

    public static Integer[] dp = new Integer[101];      // null 을 활용하기 위해 Integer 사용

    public static Integer solution(int n) {

        // 인덱스 번호와 넘어온 값을 일치 시킨다.
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        return padovan(n);
    }

    private static int padovan(int n) {

        // 점화식을 이용해 재귀로 만들기
        /* 설명 : 재귀 호출에 의한 stackoverflow를 막기 위해
            null이 아닌 값을 만날 때까지만 재귀 호출함(값이 비워져 있으면 점화식으로 채운다) */
        // dp[n]이 null 이면 ? -> dp[1] ~ [3]까지는 1로 채워져있기 때문에, 그 이후의 숫자부터 계산하겠다 라는 뜻
        if (dp[n] == null) {
            dp[n] = dp[n - 2] + dp[n - 3];    // n 앞부분의 dp를 채움
        }
        return dp[n];
    }
}
