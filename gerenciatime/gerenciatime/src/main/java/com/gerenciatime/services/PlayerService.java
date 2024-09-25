package com.gerenciatime.services;

import com.gerenciatime.domain.Player.Player;
import com.gerenciatime.dtos.PlayerDTO;
import com.gerenciatime.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository repository;

    public Player createPlayer(PlayerDTO player) throws Exception {
        Player newPlayer = new Player(player);
        this.savePlayer(newPlayer);
        return newPlayer;
    }

    public void savePlayer(Player player) {
        this.repository.save(player);
    }

    public Player findPlayerById(Long id) throws Exception {
        return this.repository.findPlayerById(id).orElseThrow(() -> new Exception("Player não encontrado"));
    }

    public List<Player> getAllPlayers() {
        return this.repository.findAll();
    }

    public void deletePlayer(Long id) {
        Player player = this.repository.findPlayerById(id)
                .orElseThrow(() -> new RuntimeException("Player não encontrado"));
        this.repository.deleteById(id);
    }
}
