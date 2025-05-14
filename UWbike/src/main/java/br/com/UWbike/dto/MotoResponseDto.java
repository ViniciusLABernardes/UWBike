package br.com.UWbike.dto;

import br.com.UWbike.entity.MotoPatio;
import br.com.UWbike.entity.TipoMoto;
import jakarta.persistence.*;

import java.util.List;

public class MotoResponseDto {

    public MotoResponseDto(){

    }

    public MotoResponseDto(TipoMoto modelo, String placa, String chassi, List<MotoPatio> historicoEntrada) {
        this.modelo = modelo;
        this.placa = placa;
        this.chassi = chassi;
        this.historicoEntrada = historicoEntrada;
    }

    private long idMoto;

    private TipoMoto modelo;

    private String placa;

    private String chassi;

    private List<MotoPatio> historicoEntrada;

    public long getIdMoto() {
        return idMoto;
    }

    public void setIdMoto(long idMoto) {
        this.idMoto = idMoto;
    }

    public TipoMoto getModelo() {
        return modelo;
    }

    public void setModelo(TipoMoto modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public List<MotoPatio> getHistoricoEntrada() {
        return historicoEntrada;
    }

    public void setHistoricoEntrada(List<MotoPatio> historicoEntrada) {
        this.historicoEntrada = historicoEntrada;
    }
}
