package com.gerenciatime.services;

import com.gerenciatime.domain.Championship.Campeonato;
import com.gerenciatime.dtos.ChampionshipDTO;
import com.gerenciatime.repositories.ChampionshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChampionshipService {

    @Autowired
    private ChampionshipRepository championshipRepository;

    // Criar um novo campeonato
    public Campeonato createChampionship(ChampionshipDTO championshipDTO) throws Exception {
        // Verifica se o nome do campeonato já existe
        championshipRepository.findByName(championshipDTO.name()).ifPresent(existingChampionship -> {
            throw new RuntimeException("Já existe um campeonato com esse nome.");
        });

        Campeonato newChampionship = new Campeonato();
        newChampionship.setName(championshipDTO.name());
        newChampionship.setTimes(championshipDTO.times());
        this.saveChampionship(newChampionship);

        return newChampionship;
    }

    // Salvar um campeonato
    public void saveChampionship(Campeonato championship) {
        this.championshipRepository.save(championship);
    }

    // Buscar um campeonato pelo ID
    public Campeonato findChampionshipById(Long id) throws Exception {
        return this.championshipRepository.findById(id).orElseThrow(() -> new Exception("Campeonato não encontrado"));
    }

    // Listar todos os campeonatos
    public List<Campeonato> getAllChampionships() {
        return this.championshipRepository.findAll();
    }

    // Atualizar um campeonato
    public Campeonato updateChampionship(Long id, ChampionshipDTO championshipDTO) throws Exception {
        Campeonato existingChampionship = this.findChampionshipById(id);
        existingChampionship.setName(championshipDTO.name());
        existingChampionship.setTimes(championshipDTO.times());
        this.saveChampionship(existingChampionship);

        return existingChampionship;
    }

    // Deletar um campeonato
    public void deleteChampionship(Long id) {
        Campeonato championship = this.championshipRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Campeonato não encontrado"));
        this.championshipRepository.deleteById(id);
    }
}
