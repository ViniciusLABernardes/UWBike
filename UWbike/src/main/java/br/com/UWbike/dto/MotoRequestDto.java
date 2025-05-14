package br.com.UWbike.dto;

import br.com.UWbike.entity.MotoPatio;
import br.com.UWbike.entity.TipoMoto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public class MotoRequestDto {


    public MotoRequestDto(){

    }

    public MotoRequestDto(TipoMoto modelo, String placa, String chassi, List<MotoPatio> historicoEntrada) {
        this.modelo = modelo;
        this.placa = placa;
        this.chassi = chassi;
        this.historicoEntrada = historicoEntrada;
    }


    @NotBlank(message = "O modelo é obrigatório")
    private TipoMoto modelo;

    @NotBlank(message = "A placa é obrigatória")
    @Size(min = 1, max = 10, message = "A placa deve ter entre 1 e 10 caracteres")
    private String placa;

    @NotBlank(message = "O chassi é obrigatório")
    @Size(min = 1, max = 30, message = "O chassi deve ter entre 1 e 30 caracteres")
    private String chassi;

    private List<MotoPatio> historicoEntrada;

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
