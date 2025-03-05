package com.min.chap02.section01.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

/* 수업목표 : 1) 버블 정렬을 이해할 수 있다. */
/* 설명 : 정렬 알고리즘
 *   데이터를 특정 순서대로 배열하는데 사용한다 (일반적으로는 배열의 정렬을 뜻함) */

/* 설명 : 1) 버블 정렬 (Bubble Sort)
 *   두 인접한 데이터의 크기를 비교해 정렬하는 방법
 *   버블의 모든 요소에 대해 반복하면서, 각 반복마다 가장 큰(작은) 요소가 배열의 끝으로 "버블링(이동)" 된다.
 *   시간 복잡도는 O(n^2) 이라 효율적이지는 않다.*/
public class Application1 {
    /* 문제.
     *  내용
     *   : N개의 정수가 주어졌을 때, 버블 정렬 알고리즘을 사용하여 오름차순으로 정렬하는 프로그램을 작성하시오.
     *  입력
     *   - 첫 번째 줄에 자연수 N(1 <= N <= 100)이 주어진다.
     *   - 두 번째 줄에 N개의 정수가 공백으로 구분되어 입력된다. 각 정수는 -10^9 이상, 10^9 이하이다.
     *  출력
     *   - 오름차순으로 정렬된 수열을 공백으로 구분하여 출력한다.
     *
     *  문제
     *   예시 입력 1
     *     - 7
     *       34 23 5 24 1 9 12
     *   예시 출력 1
     *     - 1 5 9 12 23 24 34
     *
     *  문제.
     *   예시 입력 2
     *     - 6
     *       40 47 38 8 33 35
     *   예시 출력 2
     *     - 8 33 35 38 40 47
     * */
    public static void main(String[] args) {

        /* 설명. 입력 데이터 받기 */
//        Scanner sc = new Scanner(System.in);
//        int length = sc.nextInt();
//        int[] arr = new int[length];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = sc.nextInt();          // 공백 전까지 파싱해 문자열 -> int형으로 변환 작업까지 완료
//        }

        /* memo : try with resource 사용 */
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            int length = Integer.parseInt(br.readLine()); // 입력 한줄씩을 받을 수 있다. 입력 받은 String 값을 int 형으로 바꾼다

            /* 설명 : 1) split 활용 -> String 배열 형태로 나온다. */
//            String[] strArr = br.readLine().split(" ");   // 정규 표현식을 해석하기 때문에 StringTokenizer 보다 시간이 좀 더 걸림
//            int[] arr = new int[length];
//            for (int i = 0; i < strArr.length; i++) {
//                arr[i] = Integer.parseInt(strArr[i]);
//            }

            /* 설명 : 2) StringTokenizer 활용 */
//            StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 공백을 기준으로 토큰 단위로 자른다.
//            int[] arr = new int[st.countTokens()];  // countTokens()라는 메소드 사용 가능
//            int index = 0;
//            while (st.hasMoreTokens()) {
//                arr[index] = Integer.parseInt(st.nextToken());
//            }
//
//            System.out.println("length = " + length);
//            System.out.println("arr = " + Arrays.toString(arr));

            /* 설명 : 3) Stream 활용
             *   람다식을 int Stream 형태로 바꾼다. */
            IntStream intSteam = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt);   // .mapToInt(x -> Integer.parseInt(x);
            int[] arr = intSteam.toArray();

            solution(length, arr);

            System.out.println("length = " + length);
            System.out.println("arr = " + Arrays.toString(arr));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* 설명 : 넘어온 데이터를 이용해 버블 정렬 알고리즘 작성 시작
     *   return 안하는 이유 -> call by reference 의 개념 ??? 이거 다시 공부 */
    public static void solution(int length, int[] arr) {
        for (int i = 0; i < length - 1; i++) {
            System.out.println((i + 1) + "번째 순회: " + Arrays.toString(arr));
            for (int j = 0; j < length - 1; j++) {
                //if(arr[j] < arr[j + 1]) {     // 내림차순
                if (arr[j] > arr[j + 1]) {  // 오름차순. 왼쪽이 오른쪽보다 크면 위치를 바꾼다.
                    /* 설명 : j번째와 그 다음인 (j+1) 번째의 위치를 서로 바꾼다. (swap) */
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
