package com.min.section02.run;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Application3 {
    public static void main(String[] args) {

        /* 수업목표 : TreeSet에 대해 이해하고 활용할 수 있다. */
        /* 설명 : Tree 구조를 활용해 중복 제거 + 정렬을 해준다. */
        Set<String> tSet = new TreeSet<>();
        tSet.add("a");
        tSet.add("a");
        tSet.add("b");
        tSet.add("c");
        tSet.add("d");
        tSet.add("e");
        System.out.println("tSet = " + tSet);

        Iterator<String> iter = tSet.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        /* 설명 : 로또 번호 발생기(보너스 번호 추출 제외)
         *   1부터 45까지 중복되지 않고 오름차순 정렬된 6개의 값 추출하기 */
        Set<Integer> lotto = new TreeSet<>();

        while (lotto.size() < 6) {
            lotto.add((int) (Math.random() * 45 + 1));  // Math.random 함수를 통해 45개의 번호, 1부터 시작.
        }
        System.out.println("lotto = " + lotto);

        /* 설명 : 배열을 활용한 TreeSet 과 같은 기능을 하는 알고리즘 구현해보기 */
        int[] arr = new int[6];
        for (int i = 0; i < arr.length; i++) {  // 2. 다시 i++을 하여 arr[3]을 다시 뽑는다.
            arr[i] = (int) (Math.random() * 45 + 1);
            // 이전에 생성된 값과 비교
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    i--; // 1. i가 3일 때, i-- 으로 2를 만든후
                    break;
                }
            }
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
