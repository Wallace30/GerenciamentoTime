package com.gerenciatime.repositories;

import com.gerenciatime.domain.Championship.Campeonato;
import com.gerenciatime.dtos.ChampionshipDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChampionshipRepository extends JpaRepository<Campeonato,Long> {
    Optional<Campeonato> findByName(String name);
}
