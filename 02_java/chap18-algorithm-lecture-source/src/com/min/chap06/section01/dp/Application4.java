package com.min.chap06.section01.dp;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Application4 {

    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    public static Integer solution(String input) throws IOException {
        BufferedReader br = toBufferedReader(input);

        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n + 1][n + 1];
        int[][] p = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {      // 각 층의 개수만큼 토큰이 들어있으므로
                p[i][j] = Integer.parseInt(st.nextToken());
            }
            System.out.println("p[i] = " + Arrays.toString(p[i]));
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                /* 설명 : dp 배열의 한층 위의 좌상단/우상단 값 중 큰 값과 자신의 값을 더한다. */
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j] + p[i][j]);
            }
        }

        /* 설명 : 마지막 층 (n층)에 있는 1차원 배열에서 가장 큰 값 추출 */
        int max_ans = 0;
        for (int i = 1; i <= n; i++) {
            if (max_ans < dp[n][i]) {
                max_ans = dp[n][i];
            }
        }
        return 0;
    }
}
