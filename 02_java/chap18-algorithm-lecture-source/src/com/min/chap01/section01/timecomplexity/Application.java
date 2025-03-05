package com.min.chap01.section01.timecomplexity;


import java.util.Arrays;

/* 수업목표 : 시간 복잡도를 이해할 수 있다. */
/* 설명 : 알고리즘 실행 시 입력 값이 증가함에 따라 연산이 걸리는 시간의 증가도를 나타낸다. */
public class Application {
    public static void main(String[] args) {

        int[] arr = new int[]{3, 1, 2, 15, 4, 9, 10, 7};
        //System.out.println(getfirst(arr));                // 1) 상수 시간 예제
        //System.out.println(binarySearch(arr, 9));         // 2) 로그 시간 예제
        System.out.println(Arrays.toString(reverse(arr)));  // 3) 선형 시간 예제
    }

    /* 설명 : 1) 상수 시간 O(1) */
    /* memo : 입력값의 크기와 상관 없이 항상 일정한 시간이 걸리는 알고리즘
        크기가 증가함에 따라 찾는 시간이 증가하지 않으면(시간이 동일하면) -> 상수시간 */

    private static int getfirst(int[] arr) {
        return arr[0];
    }

    /* 설명 : 2) 로그 시간 O(log n) 절반의 시간이 걸림 */
    /* memo :  입력값이 증가함에 따라 처리 시간이 로그만큼 증가하는 알고리즘
     *   이진 탐색은 매 단계마다 탐색 범위를 절반으로 줄이므로 매우 효율적임. O(log n)에 해당
     *   단, 정렬이 선행 되어야 한다. (Arrays.sort 사용 -> 오름차순) */

    private static int binarySearch(int[] arr, int target) {
        /* 설명 : 초기 세팅 (배열을 오름차순 정렬하고 시작)
         *   작은 값부터 오게 해야함. */
        Arrays.sort(arr);   // 정렬을 먼저 해줘야한다. 퀵 정렬로 nlogn 시간 만큼이 소요된다(지금은 고려하지 x)

        /* 설명 : 배열의 처음과 끝을 지칭하는 위치(인덱스)를 담은 변수 두개(두 개의 포인터) */
        int left = 0, right = arr.length - 1;   // , 를 사용해 같은 자료형은 한줄로 작성할 수 있다.
        while (left <= right) {
            int mid = left + (right - left) / 2; // 배열의 길이가 짝수일 때는 중앙에서 하나 앞 (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /* 설명 : 3) 선형 시간 O(n) */
    /* memo : 입력값이 증가함에 따라 처리 시간이 선형적으로 증가하는 알고리즘.
     *   배열의 모든 요소를 한 번씩 순회해야 하므로 배열이 크기에 비례하는 시간이 필요하다. */
    private static int[] reverse(int[] arr) {
        int[] reversed = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            reversed[arr.length - 1 - i] = arr[i];
        }
        return reversed;
    }

    /* 설명 : 4) 지수 시간 O(2^n) */
    /* memo : 입력값이 증가함에 따라 시간이 기하급수적으로 증가하는 알고리즘.
     *   재귀적으로 두 번씩 자신을 호출하므로 매우 비효율적인 시간복잡도 가짐.  */

    private static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        // 재귀 호출
        return fibonacci(n - 1) + fibonacci(n - 2); // 자신의 앞인 n-1 과 자신의 두개 앞인 n-2 를 더한다.
    }
}
