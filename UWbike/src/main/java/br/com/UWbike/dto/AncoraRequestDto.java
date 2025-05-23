package br.com.UWbike.dto;

import br.com.UWbike.entity.Patio;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class AncoraRequestDto {
    public AncoraRequestDto (){

    }
    public AncoraRequestDto(double x, double y, long idPatio) {
        this.x = x;
        this.y = y;
    }



    @NotNull(message = "O x é obrigatório")
    @Max(value = 999999, message = "O número deve ser no máximo 7 dígitos")
    private double x;
    @NotNull(message = "O y é obrigatório")
    @Max(value = 999999, message = "O número deve ser no máximo 7 dígitos")
    private double y;
    @NotNull(message = "O id do pátio é obrigatório")
    @Min(value = 1, message = "O id não pode ser 0")
    private long idPatio;

    public long getIdPatio() {
        return idPatio;
    }

    public void setIdPatio(long idPatio) {
        this.idPatio = idPatio;
    }

    private Patio patio;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Patio getPatio() {
        return patio;
    }

    public void setPatio(Patio patio) {
        this.patio = patio;
    }
}
