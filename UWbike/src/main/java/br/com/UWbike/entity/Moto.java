package br.com.UWbike.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_moto")
@SequenceGenerator(name = "moto_seq",allocationSize = 1,sequenceName = "tb_moto_seq")

public class Moto {
    public Moto(){

    }

    public Moto(String modelo, String placa, String chassi) {
        this.modelo = modelo;
        this.placa = placa;
        this.chassi = chassi;

    }

    @Id
    @Column(name = "id_moto")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "moto_seq")
    private long idMoto;

    @Column(name = "modelo",nullable = false,length = 100)
    private String modelo;

    @Column(name = "placa",nullable = false,length = 10)
    private String placa;

    @Column(name = "chassi",nullable = false,length = 30)
    private String chassi;

    @OneToMany(mappedBy = "moto",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MotoPatio> historicoEntrada;


    public List<MotoPatio> getHistoricoEntrada() {
        return historicoEntrada;
    }

    public void setHistoricoEntrada(List<MotoPatio> historicoEntrada) {
        this.historicoEntrada = historicoEntrada;
    }

    public long getId_moto() {
        return idMoto;
    }

    public void setId_moto(long id_moto) {
        this.idMoto = id_moto;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    @Override
    public String toString(){
        return "id moto: " + getId_moto() + ", modelo: " + getModelo() + ", placa: " + getPlaca() +
                ", " + getChassi();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Moto outro = (Moto) obj;

        return this.idMoto == outro.idMoto && this.modelo.equals(outro.modelo)
                && this.placa.equals(outro.placa) && this.chassi.equals(outro.chassi);
    }

}

