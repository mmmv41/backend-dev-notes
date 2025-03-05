package com.min.section01.list.run;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표
         *   컬렉션 프레임워크에 대해 이해할 수 있다 (list 부터) */

        /* 설명
         *   모든 컬렉션은 제네릭 타입일 때 다이아몬드 연산자를 (<>) 생략하면 <Object>인 상태이다. */
        //ArrayList list = new ArrayList();
        List<Object> list1 = new ArrayList<>();     // List 계열은 다형성 적용 가능

        list1.add("apple");
        list1.add(123);
        list1.add(45.67);
        list1.add(new java.util.Date());
        //list1.add(2, 10);

        /* 설명
         *   모든 컬렉션은 toString()이 오버라이딩 되어 쉽게 출력해 볼 수 있다. */
        System.out.println("list1 = " + list1);
        System.out.println("첫번째 값: " + list1.get(0));
        System.out.println("두번째 값: " + list1.get(1));
        System.out.println("list에 담긴 데이터의 크기: " + list1.size());

        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }

        /* 설명
         *   배열보다 ArrayList가 좋은 점
         *   1. 미리 크기를 할당할 필요가 없다.
         *   2. 들어있는 값의 개수를 잘 파악할 수 있다. (size())
         *   3. 경우에 따라(제네릭 타입을 생략하면) 다양한 타입을 한번에 저장할 수 있다.
         *   4. 중간에 값을 추가 및 삭제가 용이하다.
         * */

        /* 설명 : 2번째 위치에 10을 끼워 넣기 */
        list1.add(1, 10);
        System.out.println("list1 = " + list1);

        list1.add(10);
        System.out.println("list1 = " + list1);

        /* 설명 : 원하는 위치의 값 수정*/
        list1.set(0, "banana");
        System.out.println("list1 = " + list1);

        /* 설명 : 원하는 위치의 값 제거(이후 요소들의 위치가 영향을 받음) */
        list1.remove(0);
        System.out.println("list1 = " + list1);
        System.out.println("처음 요소 제거 후 처음 요소: " + list1.get(0));

        /* 컬렉션 대신 배열로 중간에 값 추가 연습 */
        int[] intArr = new int[5];
        int num = 0;
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = ++num;
        }
        System.out.println(Arrays.toString(intArr));

        /* 설명 : 2번째 위치에 7을 추가해 (기존 배열 크기 + 1)이 되는 코드 작성 */
        int[] result = new int[intArr.length + 1];
        result[0] = intArr[0];
        result[1] = 7;
        for (int i = 2; i <= intArr.length; i++) {
            result[i] = intArr[i - 1];
        }
        System.arraycopy(intArr, 1, result, 2, 4);

        System.out.println(Arrays.toString(result));

        /* 설명 : ArrayList를 활용한 정렬*/
        /* 목차
         *   1. 문자열 데이터 정렬 (Feat. 오름차순)*/
        // 다형성 적용 -> LinkedList 여도 가능
        // 하위인 ArrayList 나 LinkedList 를 사용해도 가능
        /* 설명
         *   앞에 List 라고 쓴 이유 -> 다형성 적용 위해
         *   부모 코드로 작성하면 ArrayList에서 LinkedList로 바꿔도 문제가 생기지 않는다. (타입은닉화 기술)
         *  list의 코드인것 처럼 함 -> add 사용가능
         *  add는 ArrayList나 LinkedList를 사용하는지 모름 (타입은닉) */

        // List<String> stringList = new ArrayList<>();
        /* 설명
         *   내림차순 할 때는 LinkedList 로 변경 */
        List<String> stringList = new LinkedList<>();
        stringList.add("b");
        stringList.add("a");
        stringList.add("c");
        stringList.add("d");
        stringList.add("e");

        System.out.println("문자열 데이터: " + stringList);

        // 스트링의 기준대로 정렬
        // Collectios.sort는 정렬을 도와줄 뿐이다. -> 오름차순
        /* 설명
         *   실제로는 ArrayList 안에 있는 데이터만 String에 정의된 기준(오름차순) 대로 정렬 됨
         *  컬렉션을 통해 sort를 사용, 간단한 코드 작성 가능 */
        Collections.sort(stringList);
        System.out.println("정렬된 문자열 데이터: " + stringList);

        /* 목차
         *   1-1 문자열 데이터 내림차순 정렬*/
        /* 설명
         *   다루는 iterator와 해당 컬렉션의 제네릭 타입은 웬만하면 꼭 명시하기
         *   -> 다운캐스팅 방지(타입 안정성) */
        // 이중 연결 리스트 -> descendingIterator() 제공
        // StringTokeenizer 와 비슷하다.
        // 반복자
        // 내림차순의 순회를 할 수 있게 바꿔준다.

        /* 설명
         *   LinkedList를 사용해 간단하게 내림차순으로 변환 가능 */
        Iterator<String> iter = ((LinkedList<String>) stringList).descendingIterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());    // next 로 꺼내는 아이가 String이 된다. -> 제네릭 클래스 때문
        }
    }
}
