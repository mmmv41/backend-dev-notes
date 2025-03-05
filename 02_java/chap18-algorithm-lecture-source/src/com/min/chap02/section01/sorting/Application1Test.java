package com.min.chap02.section01.sorting;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/* memo : 테스트 케이스 작성 */
class Application1Test {
    private static int input1, input2;
    private static int[] act1, act2;
    private static int[] exp1, exp2;

    @BeforeAll
    public static void set() {

        /* 설명 : 예시 1) */
        input1 = 7;
        act1 = new int[]{34, 23, 5, 24, 1, 9, 12};    // 실제 값
        exp1 = new int[]{1, 5, 9, 12, 23, 24, 34};    // 기대 값

        /* 설명 : 예시 2) */
        input2 = 6;
        act2 = new int[]{40, 47, 38, 8, 33, 35};
        exp2 = new int[]{8, 33, 35, 38, 40, 47};
    }

    public static Stream<Arguments> provideAscendingSource() {
        return Stream.of(
                Arguments.of(input1, act1, exp1),
                Arguments.of(input2, act2, exp2)
        );
    }

    @DisplayName("버블 정렬 테스트")
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)    // 1초안에 동작하면.
    @ParameterizedTest  // 재생하면 이것만 동작한다. solution 메소드만 동작.
    @MethodSource("provideAscendingSource") // stream에 있는 argument 별로 돌린다.
    public void bubbleSort(int length, int[] actual, int[] expected) {
        Application1.solution(length, actual); // 콜바이 레퍼런스 후 정렬 됨
        Assertions.assertArrayEquals(expected, actual); // 정렬 된 배열과 정렬 되었으면 좋겠는 배열이 같은지 확인
    }
}