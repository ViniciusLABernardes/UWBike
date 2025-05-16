package br.com.UWbike.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "tb_moto_patio")
public class MotoPatio {
    public MotoPatio(){

    }
    public MotoPatio( Moto moto, Patio patio, LocalDateTime dataHoraEntrada){
        this.moto = moto;
        this.patio = patio;
        this.dataHoraEntrada = dataHoraEntrada;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_moto", nullable = false)
    private Moto moto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_patio", nullable = false)
    private Patio patio;

    @Column(name = "data_hora_entrada", nullable = false)
    private LocalDateTime dataHoraEntrada;
    @Column(name = "data_hora_saida")
    private LocalDateTime dataHoraSaida;

    public Moto getMoto() {
        return moto;
    }

    public void setMoto(Moto moto) {
        this.moto = moto;
    }

    public Patio getPatio() {
        return patio;
    }

    public void setPatio(Patio patio) {
        this.patio = patio;
    }

    public LocalDateTime getDataHoraEntrada() {
        return dataHoraEntrada;
    }

    public void setDataHoraEntrada(LocalDateTime dataHoraEntrada) {
        this.dataHoraEntrada = dataHoraEntrada;
    }

    public LocalDateTime getDataHoraSaida() {
        return dataHoraSaida;
    }

    public void setDataHoraSaida(LocalDateTime dataHoraSaida) {
        this.dataHoraSaida = dataHoraSaida;
    }
}
