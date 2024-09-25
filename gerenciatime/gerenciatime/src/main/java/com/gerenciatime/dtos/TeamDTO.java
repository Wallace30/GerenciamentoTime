package com.gerenciatime.dtos;

import com.gerenciatime.domain.Player.Player;
import com.gerenciatime.domain.Trainner.Trainer;

import java.util.Date;
import java.util.List;

public record TeamDTO(String name, String stadium, Date datafundacao, Long treinadorId, List<Long> jogadorIds) {
}
