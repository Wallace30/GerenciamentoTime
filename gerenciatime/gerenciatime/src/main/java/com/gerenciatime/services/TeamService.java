package com.gerenciatime.services;

import com.gerenciatime.domain.Player.Player;
import com.gerenciatime.domain.Team.Team;
import com.gerenciatime.domain.Trainner.Trainer;
import com.gerenciatime.dtos.TeamDTO;
import com.gerenciatime.repositories.PlayerRepository;
import com.gerenciatime.repositories.TeamRepository;
import com.gerenciatime.repositories.TrainnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private TrainnerRepository trainerRepository;
    @Autowired
    private PlayerRepository playerRepository;


    // Criação de um novo time
    public Team createTeam(TeamDTO teamDTO) throws Exception {
        Trainer treinador = trainerRepository.findById(teamDTO.treinadorId())
                .orElseThrow(() -> new RuntimeException("Treinador não encontrado"));

        List<Player> jogadores = playerRepository.findAllById(teamDTO.jogadorIds());

        Team newTeam = new Team();
        newTeam.setName(teamDTO.name());
        newTeam.setStadium(teamDTO.stadium());
        newTeam.setDatafundacao(teamDTO.datafundacao());
        newTeam.setTreinador(treinador);
        newTeam.setJogadores(jogadores);

        this.saveTeam(newTeam);
        return newTeam;
    }


    // Método para verificar números duplicados de camisa
    private void verificarNumeroCamisaDuplicado(List<Player> jogadores) {
        jogadores.stream()
                .map(Player::getNumerocamisa)
                .distinct()
                .forEach(numero -> {
                    long count = jogadores.stream()
                            .filter(player -> player.getNumerocamisa() == numero)
                            .count();
                    if (count > 1) {
                        throw new RuntimeException("Existem jogadores com o mesmo número de camisa: " + numero);
                    }
                });
    }

    // Salvar um time
    public void saveTeam(Team team) {
        this.teamRepository.save(team);
    }

    // Buscar um time pelo ID
    public Team findTeamById(Long id) throws Exception {
        return this.teamRepository.findById(id).orElseThrow(() -> new Exception("Time não encontrado"));
    }

    // Listar todos os times
    public List<Team> getAllTeams() {
        return this.teamRepository.findAll();
    }
    // Deletar um time
    public void deleteTeam(Long id) {
        Team team = this.teamRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Time não encontrado"));
        this.teamRepository.deleteById(id);
    }
}

