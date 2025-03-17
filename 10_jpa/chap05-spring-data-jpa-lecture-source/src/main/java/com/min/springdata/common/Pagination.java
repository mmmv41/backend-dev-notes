package com.min.springdata.common;

import org.springframework.data.domain.Page;

/* 설명 : 버튼을 만들기 위한 로직
 *   Page 타입이 넘어오면 PagingButtonInfo 를 paging 기능 모듈*/
public class Pagination {
    public static PagingButtonInfo getPagingButtonInfo(Page page) {
        // 인덱스 개념 -> 실제 페이지 번호의 개념으로 다시 변경 (service 에서 -1 된 것을 다시 +1 해서 반환해주는 작업)
        int currentPage = page.getNumber() + 1; // 3페이지를 눌렀을 때, getNumber()은 2 이므로 다시 3으로 반환하기
        int defaultButtonCount = 10;            // 한 페이지에 보일 버튼 최대 개수
        int startPage;                          // 한 페이지에 보여질 첫 버튼
        int endPage;                            // 한 페이지에 보여질 마지막 버튼

        /* memo : 사용자가 12 페이지를 눌렀을 때, startPage : 11, endPage : 20가 되게 구현
         *   ex) 10 -> 1 / 20 -> 11
         *   ceil : 올림
         *   1 ~ 10, 11 ~ 20 이렇게 진행되게 작성됨. 그냥 외우는거 추천 */
        startPage = ((int) Math.ceil((double) currentPage / defaultButtonCount) - 1)
                * defaultButtonCount + 1;   // 11부터 20까지는 한 페이지
        endPage = startPage + defaultButtonCount - 1;

        if (page.getTotalPages() < endPage) {   // totalPage 가 마지막 페이지보다 작으면 (총 15페이지이면, 마지막 페이지인 20보다 작다)
            endPage = page.getTotalPages();     // totalPage 가 마지막 페이지 버튼이 된다.
        }

        if (page.getTotalPages() == 0) {    // 아예 화면에 보일 내용이 없으면 (1페이지도 없다면)
            endPage = startPage;            // startPage 와 endPage 가 같다 (1페이지만 표시)
        }

        return new PagingButtonInfo(currentPage, startPage, endPage);
    }
}
