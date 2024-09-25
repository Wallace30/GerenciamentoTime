package com.gerenciatime.domain.Championship;

import com.gerenciatime.domain.Team.Team;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "campeonato")
@Table(name = "campeonato")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Campeonato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany
    private List<Team> times;
}
