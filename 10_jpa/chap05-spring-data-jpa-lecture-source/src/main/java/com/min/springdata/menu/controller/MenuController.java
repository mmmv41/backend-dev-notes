package com.min.springdata.menu.controller;

import com.min.springdata.common.Pagination;
import com.min.springdata.common.PagingButtonInfo;
import com.min.springdata.menu.dto.MenuDTO;
import com.min.springdata.menu.repository.MenuRepository;
import com.min.springdata.menu.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
@Slf4j
public class MenuController {
    /* memo : final 붙이는 이유? : 한 번 주입된 의존성을 변경할 수 없도록 만들기 위해 */
    private final MenuService menuService;  // MenuService 클래스의 bean 을 받을 준비 완료됨.
    private final MenuRepository menuRepository;

    /* 설명 : Logger 를 활용한 로그 생성 이유 ?
     *   1. println 보다 성능적으로 우수함.
     *   2. 외부 리소스 파일로 따로 저장 및 송출이 가능.
     *   3. 로그 레벨에 따른 확인이 가능하다 (개발 : debug, 서비스 : info) */

//    Logger logger = LoggerFactory.getLogger(MenuController.class);
//    Logger logger = LoggerFactory.getLogger(getClass());

    /* memo : final 이기 때문에, 생성자 주입을 통해 초기화 해주는 과정 */
    @Autowired
    public MenuController(MenuService menuService, MenuRepository menuRepository) {
        this.menuService = menuService;
        this.menuRepository = menuRepository;
    }

    @GetMapping("/{menuCode}")  // 이름이 같으면
    public String findMenuByCode(@PathVariable("menuCode") int menuCode, Model model) {  // 반환형이 달라도 여기에 담아준다.
//        System.out.println("menuCode = " + menuCode);
//        logger.debug("menuCode = {}", menuCode);

        log.debug("menuCode = {}", menuCode);

        MenuDTO menu = menuService.findMenuByCode(menuCode);

        model.addAttribute("menu", menu);

        return "menu/detail";
    }

//    /* 설명 : 페이징 처리 전 */
//    @GetMapping("/list")
//    public String findMenuList(Model model) {
//        List<MenuDTO> menuList = menuService.findMenuList();
//
//        model.addAttribute("menuList", menuList);
//
//        return "menu/list";
//    }

    /* 설명 : 페이징 처리 후
     *   */
    @GetMapping("/list")
    public String findMenuList(@PageableDefault Pageable pageable, Model model) {
        log.debug("pageable = {}", pageable);

        Page<MenuDTO> menuList = menuService.findMenuList(pageable);

        /* memo : 페이지와 관련된 추가 정보를 getter 를 이용해 사용할 수 있다.  */
        log.debug("조회한 내용 목록 : {}", menuList.getContent());
        log.debug("총 페이지 수 : {}", menuList.getTotalPages());
        log.debug("총 메뉴 수 : {}", menuList.getTotalElements());
        log.debug("해당 페이지에 표시 될 요소 수 : {}", menuList.getSize());
        log.debug("해당 페이지에 실제 요소 수  : {}", menuList.getNumberOfElements());
        log.debug("Page의 number가 처음이면 (첫 페이지면) : {}", menuList.isFirst());
        log.debug("Page의 number가 마지막이면 (마지막 페이지면) : {}", menuList.isLast());


        /* 설명 : Page 객체를 통해 PagingButtonInfo 추출 */
        PagingButtonInfo paging = Pagination.getPagingButtonInfo(menuList);

        model.addAttribute("menuList", menuList);
        model.addAttribute("paging", paging);

        return "menu/list";
    }
}
