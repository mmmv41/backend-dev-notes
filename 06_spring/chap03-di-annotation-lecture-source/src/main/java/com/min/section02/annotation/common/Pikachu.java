package com.min.section02.annotation.common;

import org.springframework.stereotype.Component;

@Component
public class Pikachu implements Pokemon {
    @Override
    public void attack() {
        System.out.println("피카츄 백만볼트⚡");
    }
}