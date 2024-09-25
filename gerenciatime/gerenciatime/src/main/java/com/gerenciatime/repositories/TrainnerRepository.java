package com.gerenciatime.repositories;

import com.gerenciatime.domain.Player.Player;
import com.gerenciatime.domain.Trainner.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrainnerRepository extends JpaRepository<Trainer,Long>{
    Optional<Trainer> findTrainerById(Long id);
}
