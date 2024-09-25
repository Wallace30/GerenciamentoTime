package com.gerenciatime.dtos;

import com.gerenciatime.domain.Team.Team;

import java.util.List;

public record ChampionshipDTO(String name, List<Team> times) {
}
