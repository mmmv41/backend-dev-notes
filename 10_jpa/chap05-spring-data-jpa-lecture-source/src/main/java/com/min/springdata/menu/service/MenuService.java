package com.min.springdata.menu.service;

import com.min.springdata.menu.dto.CategoryDTO;
import com.min.springdata.menu.dto.MenuDTO;
import com.min.springdata.menu.entity.Category;
import com.min.springdata.menu.entity.Menu;
import com.min.springdata.menu.repository.CategoryRepository;
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
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class MenuService {

    private final MenuRepository menuRepository;
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;

    /* memo : 의존성 주입 (생성자 주입) */
    @Autowired
    public MenuService(MenuRepository menuRepository, ModelMapper modelMapper, CategoryRepository categoryRepository) {
        this.menuRepository = menuRepository;
        this.modelMapper = modelMapper;
        this.categoryRepository = categoryRepository;
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

    public List<MenuDTO> findMenuPrice(int menuPrice) {
        // 직접 만든 메소드 사용 (menuPrice 보다 큰 메뉴를 고르는 where 문이 들어있는 메소드)
        List<Menu> menus = menuRepository.findByMenuPriceGreaterThan(menuPrice);

        return menus.stream()
                .map(menu -> modelMapper.map(menu, MenuDTO.class))
                .collect(Collectors.toList());
    }

    /* 설명 : 5. jpql 및 native sql 활용 */
    // 카테고리 엔티티로 조회해야 하기 때문에, CategoryRepository 생성 해야함.
    public List<CategoryDTO> findAllCategory() {

        List<Category> categories = categoryRepository.findAllCategories();

        return categories.stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .collect(Collectors.toList());
    }

    /* 설명 : 6. 추가하기  */
    // DTO -> Entity
    @Transactional
    public void registMenu(MenuDTO newMenu) {
        menuRepository.save(modelMapper.map(newMenu, Menu.class));
        // 영속성 컨텍스트에 담겼다가 커밋 시점에 날아간다.
    }
}
