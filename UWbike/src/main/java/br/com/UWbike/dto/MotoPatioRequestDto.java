package br.com.UWbike.dto;

import br.com.UWbike.entity.Moto;
import br.com.UWbike.entity.Patio;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class MotoPatioRequestDto {
    public MotoPatioRequestDto(){

    }
    public MotoPatioRequestDto(Long idMoto,Long idPatio){
        this.idMoto = idMoto;
        this.idPatio = idPatio;
    }

    @NotNull(message = "O id da moto é obrigatório")
    private Long idMoto;
    @NotNull(message = "O id do pátio é obrigatório")
    private Long idPatio;




    public Long getIdMoto() {
        return idMoto;
    }

    public void setIdMoto(Long idMoto) {
        this.idMoto = idMoto;
    }

    public Long getIdPatio() {
        return idPatio;
    }

    public void setIdPatio(Long idPatio) {
        this.idPatio = idPatio;
    }


}
