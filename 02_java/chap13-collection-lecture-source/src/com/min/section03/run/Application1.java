package com.min.section03.run;

import com.min.section01.list.dto.BookDTO;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표 : Map 의 자료구조에 대해 이해하고 HashMap을 이용하기 */
        /* 설명
         *   key, value 두가지를 써야한다. */
        Map<Object, Object> hMap = new HashMap<>();
        hMap.put(new String("one"), new java.util.Date());
        hMap.put(12, "red apple");
        hMap.put(33, 123);

        /* 설명 : Map은 key를 통해 value를 찾는 것이 기본적이며 key는 객체의 동등 비교(e, h)를 통해 확인된다. */
        // key 값은 동등 비교가 가능해야한다. String에는 equals()와 hashCode()가 구현되어있으므로 동등 비교가 가능하다.
        System.out.println("키가 \"one\"인 value 값: " + hMap.get(new String("one"))); // key 값을 통해 value를 출력한다.
        System.out.println(hMap);   // map은 key와 value가 한 세트인 중괄호 형태로 출력된다. 순서가 보장되지 않는다.

        /* 목차 1. key가 중복되는 경우 */
        /* 설명
         *   e, h 가 오버라이딩 되어있지 않은 클래스는 동등 비교가 불가능하다.
         *   BookDTO에 equals()와 hashCode()를 오버라이딩 해주면 한가지 값만 나온다. -> key 값은 중복 되지 않는다.
         *  직접 만든 객체도 key로 사용할 수 있으며, 이때 해당 객체는 e, h 가 반드시 오버라이딩 되어야 한다. */
        hMap.put(new BookDTO(1, "홍길동전", "허균", 50000), 1);
        hMap.put(new BookDTO(1, "홍길동전", "허균", 50000), 4); // 기존 키의 값이 덮어쓰기 된다.
        System.out.println("BookDTO 객체를 활용한 key와 value 쌍을 두개 추가 후 : " + hMap);

        /* 목차 2. value가 중복되는 경우 */
        hMap.put(44, 123);
        System.out.println("value가 중복되는 key와 value 쌍을 추가 후: " + hMap);

        /* 설명 : Map 을 활용 해보기 */
        Map<String, String> hMap2 = new HashMap<>();
        hMap2.put("one", "java 17");
        hMap2.put("two", "mariaDB 10");
        hMap2.put("three", "servlet/jsp");
        hMap2.put("four", "springboot 3.9");
        hMap2.put("five", "vue");

        System.out.println("hMap2 = " + hMap2);

        /* 설명 : Map에 담긴 값을 순회해서 확인하는 방법
         *   key를 set으로 바꾸어 iterator 를 돌린다. */
        /* 목차 1. keySet()을 활용해 key를 Set으로 바꾸고 iterator를 돌리는 방법 */
        Set<String> keys = hMap2.keySet();
        Iterator<String> iter = keys.iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            System.out.println("key = " + key);
        }
        System.out.println();
        /* 목차 2. entrySet()을 활용하는 방법
         *   entry key와 value를 동시에 set으로 바꾼다. */
        // Set<Entry> 의 형태이다. Entry는 key와 value의 쌍
        Set<Map.Entry<String, String>> set = hMap2.entrySet();
        Iterator<Map.Entry<String, String>> iter2 = set.iterator();
        while (iter2.hasNext()) {
            // Entry 인터페이스는 Map 안에 있고, Map을 통해서만 접근 가능. -> Map.Entry 라고 작성해야한다.
            Map.Entry<String, String> entry = iter2.next();
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
        }
    }
}
