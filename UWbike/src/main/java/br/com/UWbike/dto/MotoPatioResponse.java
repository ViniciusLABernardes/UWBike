package br.com.UWbike.dto;

import br.com.UWbike.entity.Moto;
import br.com.UWbike.entity.Patio;
import jakarta.persistence.*;

import java.time.LocalDateTime;

public class MotoPatioResponse {
    public MotoPatioResponse(){

    }
    public MotoPatioResponse(Long id, Moto moto, Patio patio, LocalDateTime dataHoraEntrada, LocalDateTime dataHoraSaida){
        this.id = id;
        this.moto = moto;
        this.patio = patio;
        this.dataHoraEntrada = dataHoraEntrada;
        this.dataHoraSaida = dataHoraSaida;
    }

    private Long id;

    private Moto moto;

    private Patio patio;

    private LocalDateTime dataHoraEntrada;

    private LocalDateTime dataHoraSaida;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
