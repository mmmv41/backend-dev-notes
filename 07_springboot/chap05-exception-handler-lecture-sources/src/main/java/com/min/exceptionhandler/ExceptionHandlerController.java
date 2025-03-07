package com.min.exceptionhandler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/* memo : main -> 이 클래스 -> MainController -> main.html 경로로 이동하게 */
@Controller
@RequestMapping("/*")
public class ExceptionHandlerController {
    @GetMapping("simple-null")
    public String simpleNullPointerExceptionTest() {
        if(true){
            throw new NullPointerException();
        }
        return "/";
    }

    @GetMapping("simple-user")
    public String userExceptionTest() throws MemberRegistException{
        if(true){
            throw new MemberRegistException("당신은 안돼요");
        }
        return "/";
    }

    @GetMapping("annotation-null")
    public String nullPointerExceptionHandlerTest() {
        String str = null;
        str.charAt(0);

        return "/";
    }

    @ExceptionHandler(NullPointerException.class)
    public String nullPointerExceptionHandler() {
        System.out.println("이 Controller 에서 NullPointer 예외 발생 시 여기 오는지 확인");

        return "error/default";
    }

    @GetMapping("annotation-user")
    public String userExceptionHandlerTest() throws MemberRegistException {
        if(true){
            throw new MemberRegistException("당신은 안됨");
        }

        return "/";
    }

    @ExceptionHandler(MemberRegistException.class)
    public String userExceptionHandler(Model model) {
        System.out.println("이 Controller에서 MemberRegist 예외 발생 시 여기 오는지 확인");

        model.addAttribute("exceptionMessage","안됨");

        return "error/default";
    }
}
