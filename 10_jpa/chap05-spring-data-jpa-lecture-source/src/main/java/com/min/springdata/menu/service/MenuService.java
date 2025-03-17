package com.min.springdata.menu.service;

import com.min.springdata.menu.dto.MenuDTO;
import com.min.springdata.menu.entity.Menu;
import com.min.springdata.menu.repository.MenuRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MenuService {

    private final MenuRepository menuRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public MenuService(MenuRepository menuRepository, ModelMapper modelMapper) {
        this.menuRepository = menuRepository;
        this.modelMapper = modelMapper;
    }

    /* 설명 : 1. findById() */
    public MenuDTO findMenuByCode(int menuCode) {

//        Menu menu = menuRepository.findById(menuCode).get();
        Menu menu = menuRepository.findById(menuCode).orElseThrow(IllegalArgumentException::new);
        log.debug("menu: {}", menu);

        return modelMapper.map(menu, MenuDTO.class);
    }

    /* 설명 : 2. findAll() (페이징 처리 전) */
    public List<MenuDTO> findMenuList() {
        // 페이지네이션을 구현하기 전 정렬 기준 작성 (descending -> 최근에 작성한게 제일 상단에 뜨게 된다)
        List<Menu> menus = menuRepository.findAll(Sort.by("menuCode").descending()); // 다중행 조회

        return menus.stream()
                .map(menu -> modelMapper.map(menu, MenuDTO.class))
                .collect(Collectors.toList());
    }

    /* 설명. 3. findAll() (페이징 처리 후) */
    public Page<MenuDTO> findMenuList(@PageableDefault Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("menuCode").descending());
        Page<Menu> menuList = menuRepository.findAll(pageable);  // pageable 을 활용한 findAll 메소드 사용 (JpaRepository 에서 제공)

        return menuList.map(menu -> modelMapper.map(menu, MenuDTO.class));
    }

}
