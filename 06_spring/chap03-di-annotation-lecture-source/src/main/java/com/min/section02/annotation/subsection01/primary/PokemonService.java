package com.min.section02.annotation.subsection01.primary;

import com.min.section02.annotation.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/* memo : PokemonService 는 Pokemon 객체를 직접 생성하지 않는다. -> 스프링 컨테이너가 객체를 자동으로 주입.
 *   PokemonService는 어떤 Pokemon이 사용될지 알 필요 x, 확장성 높아짐. */
@Service("pokemonServicePrimary")
public class PokemonService {

    private Pokemon pokemon;

    @Autowired      // 생성자 주입은 @Autowired 생략 가능
    public PokemonService(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void pokemonAttack() {
        pokemon.attack();
    }
}
