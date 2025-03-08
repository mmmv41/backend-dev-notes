package com.min.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/* memo : @Component 계열이므로 bean 이 된다. */
/* memo : @RequestMapping 을 사용하기 위해서는 @Controller 가 있어야한다.  */
@Controller
public class MethodMappingController {
    /* memo : invoke 시켜서 메소드를 실행  */
    /* memo : request 요청이 들어오면 (request method 상관 x(get, post 등 상관 x)) 이 메소드를 실행시킨다. */
    /* 설명 : 핸들러 메소드를 매핑한다. */
//    @RequestMapping(value = "/menu/regist")
//    @RequestMapping(value = "/menu/regist", method = RequestMethod.GET)
//    /* 설명 : 핸들러 메소드 라고 부른다. */
//    public String registMenu(Model model) { // 스프링부트에서 쓰는 request 주머니 같은 것 -> 재료를 담아서 프론트에 넘김
//        /* 설명 : Model 은 SSR 에서 쓰는 것으로 응답할 페이지의 재료가 된다. */
//        System.out.println("/menu/regist 경로의 GET 요청 받아보기");
//
//        model.addAttribute("message", "신규 메뉴 등록용 핸들러 메소드 호출됨...");
//
//        /* 설명 : 핸들러 메소드에서 변환한 String 은 응답 값이 아닌 view(html 파일 이름) 가 된다. */
//        return "mappingResult"; // 반환하는 문자열 = 페이지의 이름 (view 의 이름)
//    }
//
//    @RequestMapping(value = "/menu/regist", method = RequestMethod.POST)
//    public String modifyMenu(Model model) {
//        model.addAttribute("message", "POST 메뉴 방식의 메뉴 수정용 핸들러 메소드 호출됨...");
//
//        return "mappingResult";
//    }

    @GetMapping("/menu/regist")
    public String getDeleteMenu(Model model) {
        model.addAttribute("message", "GET 방식의 메뉴 삭제용 핸들러 메소드 호출됨...");

        return "mappingResult";
    }

    @PostMapping("/menu/regist")
    public String postDeleteMenu(Model model) {
        model.addAttribute("message", "POST 방식의 메뉴 삭제용 핸들러 메소드 호출됨...");

        return "mappingResult";
    }
}
