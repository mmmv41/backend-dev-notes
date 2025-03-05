package com.min.chap04.section01.greedy;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Application2 {

    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    public static int solution(String input) throws IOException {
        BufferedReader br = toBufferedReader(input);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 동전 종류의 개수
        int K = Integer.parseInt(st.nextToken());   // 계산할 금액

        int[] coin = new int[N];                    // 동전의 종류들을 담을 배열
        for (int i = 0; i < coin.length; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;

        // 여기서 0부터 시작하지 않고, n-1 부터 시작하는 것이 -> 그리디 알고리즘 ! (가장 큰 동전부터 시작하는 것이 최적의 해답이다)
        for (int i = N - 1; i >= 0; i++) {
            if (coin[i] <= K) {

                /* memo : 현재의 동전 종류로 최대 지불할 수 있는 금액 */
                count += K / coin[i];   // 문제를 해결하기 위한 동전이 2개 이상일 경우 감안 (누적)

                /* memo : 큰 금액의 도엊ㄴ으로 처리하고 남은 금액을 K에 대입 (다음 동전 단위를 위해) */
                K %= coin[i];
            }

            /* 설명 : 1원까지 있어 else 는 고려하지 않는다(실제 문제도 가진 동전으로 해결할 수 있는 K원이 주어진다. */
        }

        return count;
    }
}
