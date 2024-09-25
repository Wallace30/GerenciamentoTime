package com.gerenciatime.services;

import com.gerenciatime.domain.Player.Player;
import com.gerenciatime.domain.Trainner.Trainer;
import com.gerenciatime.dtos.TrainnerDTO;
import com.gerenciatime.repositories.PlayerRepository;
import com.gerenciatime.repositories.TrainnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainnerService {
    @Autowired
    private TrainnerRepository repository;
    public Trainer createTrainner(TrainnerDTO trainner)
    {
        Trainer newTrainer = new Trainer(trainner);
        this.saveTrainer(newTrainer);
        return newTrainer;
    }
    public void saveTrainer(Trainer trainer) {
        this.repository.save(trainer);
    }
    public List<Trainer> getAllUsers() {
        return this.repository.findAll();
    }
    public Trainer findTrainerById(Long id) throws Exception {
        return this.repository.findTrainerById(id).orElseThrow(() -> new Exception("Treinador não encontrado"));
    }
}
