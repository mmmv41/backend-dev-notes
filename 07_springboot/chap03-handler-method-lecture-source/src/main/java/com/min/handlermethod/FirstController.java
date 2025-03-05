package com.min.handlermethod;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {

    /* 설명 : 핸들러 메소드에서 반환형이 없을 경우 요청 경롤를 반환한다. (view의 경로 및 이름) */
    @GetMapping("/regist")
    public void regist() {
        /* memo : 반환이 안된 것이 아님, 경로가 반환된 것. */
    }
    //    public String regist() {
//        return "/first/regist";
//    } 원래는 이렇게 적었지만, return 문을 포함하지 않아도 된다.

    /* 설명 : request 는 사용자의 입력값(parameter)를 담는 용도로 사용,
     *   Model은 백엔드에서 동적 페이지를 만들 때 사용하는 용도 */
    @PostMapping("regist")  // /를 붙이지 않아도 된다.
    public String registMenu(HttpServletRequest request, Model model) {
        String name = request.getParameter("name");
        System.out.println("name = " + name);

        int price = Integer.parseInt(request.getParameter("price"));
        System.out.println("price = " + price);

        int categoryCode = Integer.parseInt(request.getParameter("categoryCode"));
        System.out.println("categoryCode = " + categoryCode);

        String message = name + "을(를) 신규 메뉴 목록의" + categoryCode + "번 카테고리에 "
                + price + "원으로 등록하였습니다 !!";

        model.addAttribute("message", message);

        return "first/messagePrinter";
    }

    @GetMapping("modify")
    public void modify() {
    }

    /* 설명 :
     *   request 의 parameter 로 넘어오는 값 들의 key 값과 일치하는 변수명(어노테이션 생략 가능) 을 작성하고 @RequestParam
     *   어노테이션을 적용하면 알아서 값을 꺼내고 해당 매개변수와 자료형에 맞게 변환까지 해준다(가능한 경우만)
     *
     * 설명 :
     *  1. defaultValue : 사용자의 입력 값이 없거나("") 아니면 request의 parameter 키 값과 일치하지 않는
     *                    매개변수 사용 시 매개변수가 가질 기본 default 값을 작성한다.
     *  2. name : request parameter 의 키 값과 다른 매개변수 명을 사용하고 싶을 때 request parameter 의
     *                    키 값을 작성한다. */

    @PostMapping("modify1")
    public String modify1(Model model,
                          @RequestParam(name = "name") String modifyName,
//                          @RequestParam(name = "modifyPrice") int modifyPrice)
                          int modifyPrice) {
        // 넘어온 parameter 의 키값과 핸들러 메소드의 매개변수 이름이 같으면 생략 가능.

        String message = modifyName + "메뉴의 가격을 " + modifyPrice + "로 변경하였습니다.";
        model.addAttribute("message", message);

        return "first/messagePrinter";
    }

    @PostMapping("modify2")
    public String modify2(Model model,
                          @RequestParam Map<String, String> parameterMap) {

        String modifyName = parameterMap.get("name");
        int modifyPrice = Integer.parseInt(parameterMap.get("modifyPrice"));

        String message = modifyName + "메뉴의 가격을 " + modifyPrice + "로 변경하였습니다.";
        model.addAttribute("message", message);

        return "first/messagePrinter";
    }

    @GetMapping("search")
    public void search() {
    }

    /* 설명 :
     *   핸들러 메소드에 우리가 작성한 클래스(bean X) 를 매개변수로 작성하면 스프링이 객체를 만들어 주고(기본 생성자)
     *   setter 로 값도 주입해 준다.
     *   이러한 클래스의 객체를 '커멘드 객체' 라고 한다.
     *   (커멘드 객체는 기본 생성자와 setter 가 필수 */

    /* 설명 :
     *   @ModelAttribute 어노테이션을 활용하면 커멘드 객체를 모델에 attribute 로 담아주며 이후 view 의 재료로
     *   사용할 수 있다. (키 값 작성 유무에 따라 화면에서 활용하는 방법이 다르다) */
    @PostMapping("search")
    public String searchMenu(@ModelAttribute(name = "menu") MenuDTO menu) {
        System.out.println("menu = " + menu);

        return "first/searchResult";
    }
}