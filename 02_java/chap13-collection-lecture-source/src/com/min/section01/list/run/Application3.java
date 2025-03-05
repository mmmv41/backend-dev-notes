package com.min.section01.list.run;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Application3 {
    public static void main(String[] args) {

        /* 수업목표 : List 계열을 출력하는 4가지 방법 */
        // List<String> list = new Vector<>() // 동기화 처리가 내부적으로 일어난다. -> 느리다.
        // List<String> list = new ArrayList<>();
        List<String> list = new LinkedList<>();

        list.add("apple");
        list.add("banana");
        list.add("orange");
        list.add("mango");
        list.add("grape");

        /* 설명 : 1. toString() 활용하기
         *   가로로 밖에 볼 수 없다. */
        System.out.println(list);

        /* 설명 : 2. for 문 활용하기 */
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        /* 설명 : 3. for-each 문 활용하기 */
        for (String s : list) {
            System.out.println(s);
        }

        /* 설명 : 4. iterator 활용하기 */
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        /* 설명 : 1번 인덱스(두 번째) 의 과일 수정 */
        // ArrayList가 더 빠름
        list.set(1, "pineapple");
        System.out.println("2번째 요소 수정 후: " + list);

        /* 설명 : list 가 관리하는 요소 제거 */
        /* 설명 : 3번째 요소 제거 */
        // LinkedList가 더 빠름 (중간 값 추가, 제거 할 때 더 빠르다) -> 이유를 아는게 더 중요하다
        list.remove(2);
        System.out.println("3번째 요소 제거 후: " + list);

        list.clear();
        System.out.println("모든 요소 제거 후: " + list);


        /* 설명 : clear()와 null의 차이 알기 */
        /* 설명
         *   ArrayList가 저장하는 데이터를 지운다. -> isEmpty() 시 true 반환 (객체는 있는데 내부의 데이터가 없는 경우)
         *   객체는 있는데 조회가 안되면 isEmpty()로 확인할 수 있다.*/
        list.clear();

        /* 설명
         *   null : 저장공간 마저 사라지게 한다. -> 실행 시 NullPointerException 발생
         *   null을 대입하면 이후 list를 활용하는 곳에서는 NullPointerException 발생*/
//        list = null;

        /* 설명 : 모든 요소가 제거 된 후 */
        System.out.println("isEmpty: " + list.isEmpty());


    }
}
