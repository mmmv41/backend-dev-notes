package com.min.section02.annotation.subsection01.primary;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        /* memo : 스프링 컨테이너 생성. */
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.min.section02");
        // section02 패키지를 스캔 -> @Component 가 붙은 클래스들을 bean 으로 등록

        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println("beanName = " + beanName);
        }

        /* memo : 필요한 빈을 가져옴. */
        PokemonService pokemonService =
                context.getBean("pokemonServicePrimary", PokemonService.class);

        pokemonService.pokemonAttack();
    }
}