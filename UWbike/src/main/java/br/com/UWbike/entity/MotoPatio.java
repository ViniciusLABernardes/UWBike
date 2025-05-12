package br.com.UWbike.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "moto_patio")
public class MotoPatio {
    public MotoPatio(){

    }
    public MotoPatio(Long id, Moto moto, Patio patio, LocalDateTime dataHoraEntrada, LocalDateTime dataHoraSaida){
        this.id = id;
        this.moto = moto;
        this.patio = patio;
        this.dataHoraEntrada = dataHoraEntrada;
        this.dataHoraSaida = dataHoraSaida;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_moto", nullable = false)
    private Moto moto;

    @ManyToOne
    @JoinColumn(name = "id_patio", nullable = false)
    private Patio patio;

    @Column(name = "data_hora_entrada", nullable = false)
    private LocalDateTime dataHoraEntrada;
    @Column(name = "data_hora_saida")
    private LocalDateTime dataHoraSaida;
}
