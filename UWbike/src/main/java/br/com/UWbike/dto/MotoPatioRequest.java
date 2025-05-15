package br.com.UWbike.dto;

import br.com.UWbike.entity.Moto;
import br.com.UWbike.entity.Patio;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public class MotoPatioRequest {
    public MotoPatioRequest(){

    }
    public MotoPatioRequest(Moto moto, Patio patio, LocalDateTime dataHoraEntrada, LocalDateTime dataHoraSaida){
        this.moto = moto;
        this.patio = patio;
        this.dataHoraEntrada = dataHoraEntrada;
        this.dataHoraSaida = dataHoraSaida;
    }

    @NotBlank(message = "O id da moto é obrigatório")
    private Moto moto;
    @NotBlank(message = "O id do pátio é obrigatório")
    private Patio patio;

    @NotBlank(message = "A data e hora de entrada são obrigatorios")
    private LocalDateTime dataHoraEntrada;

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
