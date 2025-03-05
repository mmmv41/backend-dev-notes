package com.min.common;

import lombok.*;

// @Data //만 쓰면 밑의 어노테이션을 다 안써도된다. 하지만 성능이나 메모리가 저하될 수 있다. (왼쪽 상단의 structure 열어서 확인 가능)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class MemberDTO {
    private int sequence;
    private String id;
    private String pwd;
    private String name;
}
