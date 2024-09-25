package com.gerenciatime.dtos;

import com.gerenciatime.domain.Player.PlayerType;

import java.util.Date;

public record PlayerDTO(String name, Date datanasc, int numerocamisa, PlayerType tipoplayer) {

}
