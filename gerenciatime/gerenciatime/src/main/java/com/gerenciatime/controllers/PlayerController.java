package com.gerenciatime.controllers;


import com.gerenciatime.domain.Player.Player;
import com.gerenciatime.dtos.PlayerDTO;
import com.gerenciatime.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService service;

    @PostMapping
    public ResponseEntity<List<Player>> createPlayers(@RequestBody List<PlayerDTO> players) throws Exception {
        List<Player> newPlayers = new ArrayList<>();

        for (PlayerDTO playerDTO : players) {
            Player newPlayer = service.createPlayer(playerDTO); // Cria cada jogador a partir do DTO
            newPlayers.add(newPlayer); // Adiciona o jogador criado à lista
        }

        return new ResponseEntity<>(newPlayers, HttpStatus.CREATED); // Retorna a lista de jogadores criados
    }
    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers()
    {
        List<Player> players = this.service.getAllPlayers();
        return new ResponseEntity<>(players,HttpStatus.OK);
    }
 }
