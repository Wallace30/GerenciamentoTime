package com.gerenciatime.domain.Trainner;

import com.gerenciatime.dtos.PlayerDTO;
import com.gerenciatime.dtos.TrainnerDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity(name = "trainer")
@Table(name = "trainer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date datanasc;
    private TrainerType tipotrein;

    public Trainer(TrainnerDTO data)
    {
        this.name = data.name();
        this.datanasc = data.datanasc();
        this.tipotrein = data.tipotreina();
    }
}
