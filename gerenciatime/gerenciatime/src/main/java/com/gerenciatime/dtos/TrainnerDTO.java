package com.gerenciatime.dtos;

import com.gerenciatime.domain.Trainner.TrainerType;

import java.util.Date;

public record TrainnerDTO(String name, Date datanasc, TrainerType tipotreina) {
}
