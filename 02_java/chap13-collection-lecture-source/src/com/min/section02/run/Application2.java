package com.min.section02.run;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Application2 {
    public static void main(String[] args) {
        /* 수업목표 : LinkedHashSet 에 대해 이해하고 활용하기 */
        /* 설명
         *   LinkedHashSet 은 저장 당시의 순서를 유지하는 특성을 가지고 있다.
         *   (중복 제거 + 순서 유지) */

        Set<String> lSet = new LinkedHashSet<>();
        lSet.add("a");
        lSet.add("a");  // 중복 제거
        lSet.add("b");
        lSet.add("c");
        lSet.add("d");
        lSet.add("e");
        System.out.println("lSet = " + lSet);

        Iterator<String> iter = lSet.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
