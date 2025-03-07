package com.min.viewresolver;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/*")   // / 로 시작하는 모든 경로를 받는다. 안적어도 됨.
public class MainController {

    /* memo : localhost:8080/ 과 localhost:8080/main 둘다 main.html 이 열리게 된다.  */
//    @RequestMapping("/")
//    public String defaultLocation() {
//        return "main";
//    }
//
//    @RequestMapping("/main")
//    public void main() {}

    @RequestMapping(value = {"/", "/main"})
    public String main() {
        return "main";
    }
}
