package com.gerenciatime.controllers;

import com.gerenciatime.domain.Championship.Campeonato;
import com.gerenciatime.dtos.ChampionshipDTO;
import com.gerenciatime.services.ChampionshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/championships")
 public class ChampionshipController {

    @Autowired
    private ChampionshipService championshipService;

    // Criar um novo campeonato
    @PostMapping
    public ResponseEntity<Campeonato> createChampionship(@RequestBody ChampionshipDTO championshipDTO) {
        try {
            Campeonato createdChampionship = championshipService.createChampionship(championshipDTO);
            return new ResponseEntity<>(createdChampionship, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // Buscar um campeonato pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Campeonato> getChampionshipById(@PathVariable Long id) {
        try {
            Campeonato championship = championshipService.findChampionshipById(id);
            return new ResponseEntity<>(championship, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Listar todos os campeonatos
    @GetMapping
    public ResponseEntity<List<Campeonato>> getAllChampionships() {
        List<Campeonato> championships = championshipService.getAllChampionships();
        return new ResponseEntity<>(championships, HttpStatus.OK);
    }

    // Atualizar um campeonato
    @PutMapping("/{id}")
    public ResponseEntity<Campeonato> updateChampionship(@PathVariable Long id, @RequestBody ChampionshipDTO championshipDTO) {
        try {
            Campeonato updatedChampionship = championshipService.updateChampionship(id, championshipDTO);
            return new ResponseEntity<>(updatedChampionship, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Deletar um campeonato
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChampionship(@PathVariable Long id) {
        try {
            championshipService.deleteChampionship(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
