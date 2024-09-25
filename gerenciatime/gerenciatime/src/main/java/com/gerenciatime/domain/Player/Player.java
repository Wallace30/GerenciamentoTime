package com.gerenciatime.domain.Player;

import com.gerenciatime.dtos.PlayerDTO;
import jakarta.persistence.*;
import lombok.*;

import java.text.DateFormat;
import java.util.Date;

@Entity(name = "players")
@Table(name = "players")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date nascimento;
    private int numerocamisa;
    private PlayerType posicao;

    public Player(PlayerDTO data)
    {
        this.name = data.name();
        this.nascimento = data.datanasc();
        this.numerocamisa = data.numerocamisa();
        this.posicao = data.tipoplayer();
    }
}
