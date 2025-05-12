package br.com.UWbike.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_moto")
@SequenceGenerator(name = "moto_seq",allocationSize = 1,sequenceName = "tb_moto_seq")

public class Moto {
    public Moto(){

    }

    public Moto(TipoMoto modelo, String placa, List<MotoPatio> historicoEntrada) {
        this.modelo = modelo;
        this.placa = placa;
        this.historicoEntrada = historicoEntrada;
    }

    @Id
    @Column(name = "id_moto")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "moto_seq")
    private long idMoto;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "modelo",nullable = false,length = 100)
    private TipoMoto modelo;


    @Column(name = "placa",nullable = false,length = 10)
    private String placa;

    @OneToMany(mappedBy = "moto")
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
    public TipoMoto getModelo() {
        return modelo;
    }

    public void setModelo(TipoMoto modelo) {
        this.modelo = modelo;
    }
}
