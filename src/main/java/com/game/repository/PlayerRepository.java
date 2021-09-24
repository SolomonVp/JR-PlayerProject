package com.game.repository;

import com.game.entity.Player;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository                                                    // наследуемся от CRUDRepository или JPARepository, чтобы получить необходимые методы. Далее реализуем PlayerService.
public interface PlayerRepository extends CrudRepository<Player, Long> {

}
