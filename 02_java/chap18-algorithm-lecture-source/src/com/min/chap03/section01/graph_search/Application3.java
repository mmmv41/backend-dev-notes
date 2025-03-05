package com.min.chap03.section01.graph_search;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Application3 {

    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    static boolean[][] visit;
    static int[][] map;
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {1, -1, 0, 0};
    static int N, M;

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static Integer solution(String input) throws IOException {
        BufferedReader br = toBufferedReader(input);
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M];

        /* 설명 : 입력값이 공백 없이 이어서 들어옴에 따라 한 문자씩 뜯어서 int 배열(map)에 옮겨담는 반복문 */
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            char[] chArr = str.toCharArray();   // String char 배열로 바꾸는 메소드.
            for (int j = 0; j < chArr.length; j++) {
                map[i][j] = Character.getNumericValue(chArr[j]);    // 문자를 매칭되는 숫자로 바꾸는 메소드.
                // 공백이 없어서 StringTokenizer 로 자를 수 없다.
            }
        }

        /* 설명 : 시작과 동시에 첫 번째 칸 방문 체크 */
        visit[0][0] = true;

        bfs(0, 0);   // 도착지(우하단) 위치까지 bfs 가 돌아가며 알고리즘 진행

        return map[N - 1][M - 1];   // 마지막 칸 까지 가는 최적의 경로 수
    }

    // bfs 안에서는 y, x 로 바꿔줘야함.
    private static void bfs(int y, int x) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));

        while (!q.isEmpty()) {
            Node n = q.poll();

            for (int i = 0; i < 4; i++) {
                int curX = n.x + dirX[i];   // poll로 꺼낸 위치에서  x만킄 이동
                int curY = n.y + dirY[i];

                /* 설명 : 상하좌우를 둘러볼 때 미로 범위를 넘어가면 다른 방향을 보도록 한다. */
                if (curX < 0 || curY < 0 || curX >= M || curY >= N) {    // 이렇게 되면 안된다.
                    continue;
                }

                /* 설명 : 방문했거나 벽을 만나면 */
                if (visit[curY][curX] || map[curY][curX] == 0) {
                    continue;
                }

                q.offer(new Node(curX, curY));
                map[curY][curX] = map[n.y][n.x] + 1;  // 지나갈 때 마다 큰수를 남긴다. / 원래 나의 위치 ?

                System.out.println("curX: " + curX);
                System.out.println("curY: " + curY);
                System.out.println("map[curY][curX]: " + map[curY][curX]);

                // 쳐다본 방향을 방문할 것이다. 큐에 담고 다음갈 방향을 캐릭터에 담고 ...
                visit[curY][curX] = true;
            }
        }
    }
}
