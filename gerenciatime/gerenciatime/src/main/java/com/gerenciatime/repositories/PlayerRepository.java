package com.gerenciatime.repositories;

import com.gerenciatime.domain.Player.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player,Long> {
    Optional<Player> findPlayerById(Long id);
    Optional<Player> findPlayerByNumerocamisa(int numerocamisa);
}
