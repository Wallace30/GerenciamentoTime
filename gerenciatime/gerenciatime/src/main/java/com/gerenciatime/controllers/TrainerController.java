package com.gerenciatime.controllers;

import com.gerenciatime.domain.Player.Player;
import com.gerenciatime.domain.Trainner.Trainer;
import com.gerenciatime.dtos.PlayerDTO;
import com.gerenciatime.dtos.TrainnerDTO;
import com.gerenciatime.services.TrainnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trainers")
public class TrainerController {
    @Autowired
    private TrainnerService trainerservice;

    @PostMapping
    public ResponseEntity<Trainer> createPlayer(@RequestBody TrainnerDTO trainer) throws Exception {
        Trainer newTrainner = trainerservice.createTrainner(trainer);
        return new ResponseEntity<>(newTrainner, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Trainer>> getAllPlayers()
    {
        List<Trainer> trainers = this.trainerservice.getAllUsers();
        return new ResponseEntity<>(trainers,HttpStatus.OK);
    }
}
