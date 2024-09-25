package com.gerenciatime.controllers;

import com.gerenciatime.domain.Team.Team;
import com.gerenciatime.dtos.TeamDTO;
import com.gerenciatime.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    // Criar um novo time
    @PostMapping
    public ResponseEntity<Team> createTeam(@RequestBody TeamDTO teamDTO) {
        try {
            Team newTeam = teamService.createTeam(teamDTO);
            return ResponseEntity.ok(newTeam);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);  // Retorna erro 400 caso haja problemas
        }
    }

    // Buscar um time pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Team> findTeamById(@PathVariable Long id) {
        try {
            Team team = teamService.findTeamById(id);
            return ResponseEntity.ok(team);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();  // Retorna erro 404 se o time não for encontrado
        }
    }

    // Listar todos os times
    @GetMapping
    public ResponseEntity<List<Team>> getAllTeams() {
        List<Team> teams = teamService.getAllTeams();
        return ResponseEntity.ok(teams);
    }


    // Deletar um time pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable Long id) {
        try {
            teamService.deleteTeam(id);
            return ResponseEntity.noContent().build();  // Retorna status 204 ao deletar com sucesso
        } catch (Exception e) {
            return ResponseEntity.notFound().build();  // Retorna erro 404 se o time não for encontrado
        }
    }
}
