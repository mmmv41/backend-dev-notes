package com.min.springdata.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping(value = {"/", "/main"})
    public String main() {
        return "main/main"; // main 폴더 하위에 있는 main.html 로 이동
    }
}
