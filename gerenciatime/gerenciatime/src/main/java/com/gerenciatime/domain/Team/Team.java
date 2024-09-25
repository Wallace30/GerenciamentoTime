package com.gerenciatime.domain.Team;


import com.gerenciatime.domain.Player.Player;
import com.gerenciatime.domain.Trainner.Trainer;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity(name = "teams")
@Table(name = "teams")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String stadium;
    private Date datafundacao;
    @OneToOne
    private Trainer treinador;
    @OneToMany
    private List<Player> jogadores;


}
