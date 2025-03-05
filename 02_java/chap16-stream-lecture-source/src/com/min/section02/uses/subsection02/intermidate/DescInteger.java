package com.min.section02.uses.subsection02.intermidate;

import java.util.Comparator;

public class DescInteger implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1; // 오토 언박싱이 발생함.
//        return -(o1 - o2);
    }
}
