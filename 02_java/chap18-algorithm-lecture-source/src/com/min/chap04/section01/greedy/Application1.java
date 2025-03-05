package com.min.chap04.section01.greedy;

public class Application1 {

    public static int solution(int n) { // nkg 이 넘어올 때 몇개의 봉지면 될까?

        /* 설명 : 5kg 봉지 또는 3kg 봉지로 가져갈 수 있는 최소 봉지의 수 */
        int count = 0;
        while (n > 0) {
            if (n % 5 == 0) {   // n 이 15 일 때 -> 15 / 5 로 5kg 봉지 3개만 있으면 됨.
                return n / 5 + count;
            } else {
                n -= 3;
                count++;

                if (n == 0) {   // 마지막에 3kg 봉지로 해결한 경우
                    break;
                }
                if (n < 0) {    // 5kg 또는 3kg 으로 해결할 수 없는 경우
                    return -1;
                }
            }
        }

        return count;
    }
}
