package com.min.chap05.section01.tree;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* 수업목표 : 트리(Tree) 알고리즘을 활용하는 예제 이해하기 */
/* 설명
 *   그래프에서 계층적인 구조를 나타내기 위해 최상위 노드인 루트 (root) 노드에서 시작하여
 *   하위 노드들로 분기하는 방식으로 구성된 알고리즘 (일반적으로 이진트리만 다루게 된다) */
public class Application1 {

    // n+1 부터 사용. 0번은 사용하지 않는다.
    static int N;
    static int[] parent;
    static boolean[] isVisit;
    static StringTokenizer st;
    static List<Integer>[] list;  // int 값이 들어갈 수 있는 ArrayList
    static StringBuilder sb = new StringBuilder();

    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    public static String solution(String input) throws IOException {
        BufferedReader br = toBufferedReader(input);
        sb.delete(0, sb.length());      // 알고리즘과는 무관. 테스트 코드 환경이기 때문에 앞선 내용 삭제. sb를 한번 사용하고 리셋해줘야 한다.

        N = Integer.parseInt(br.readLine());

        isVisit = new boolean[N + 1];
        list = new ArrayList[N + 1];
        parent = new int[N + 1];

        /* 설명 : 각각의 노드(인덱스 번호와 일치) 들이 ArrayList 를 하나씩 가지도록 초기화 */
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        /* 설명 : N-1개 줄에 걸쳐서 각 노드들 정보 입력 */
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        dfs(1);

        for (int i = 1; i <= N; i++) {
            sb.append(parent[i]);
            sb.append(" ");
        }
        return sb.toString();
    }

    private static void dfs(int i) {
        isVisit[i] = true;

        for (int node : parent) {
            if (!isVisit[node]) {
                parent[i] = node;
            }
        }
    }
}
