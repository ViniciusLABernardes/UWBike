package br.com.UWbike.services;


import br.com.UWbike.entity.Moto;
import br.com.UWbike.entity.MotoPatio;
import br.com.UWbike.entity.Patio;
import br.com.UWbike.exceptions.IdNaoEncontradoException;
import br.com.UWbike.repository.MotoPatioRepository;
import br.com.UWbike.repository.MotoRepository;
import br.com.UWbike.repository.PatioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MotoPatioService {
    @Autowired
    private MotoPatioRepository motoPatioRepository;

    @Autowired
    private MotoRepository motoRepository;

    @Autowired
    private PatioRepository patioRepository;

    public MotoPatio adicionarMotoAoPatio(Long idMoto, Long idPatio) throws IdNaoEncontradoException {
        Moto moto = motoRepository.findById(idMoto)
                .orElseThrow(() -> new IdNaoEncontradoException("Moto com ID " + idMoto + " não encontrada."));

        Patio patio = patioRepository.findById(idPatio)
                .orElseThrow(() -> new IdNaoEncontradoException("Pátio com ID " + idPatio + " não encontrado."));

        MotoPatio motoPatio = new MotoPatio();
        motoPatio.setMoto(moto);
        motoPatio.setPatio(patio);
        motoPatio.setDataHoraEntrada(LocalDateTime.now());

        return motoPatioRepository.save(motoPatio);
    }


    public MotoPatio adicionarSaidaMoto(Long idMoto) throws IdNaoEncontradoException{
        MotoPatio entradaAberta = motoPatioRepository
                .findEntradaAbertaDaMoto(idMoto)
                .orElseThrow(() -> new IdNaoEncontradoException("Nenhuma entrada em aberto encontrada para a moto ID " + idMoto));

        entradaAberta.setDataHoraSaida(LocalDateTime.now());
        return motoPatioRepository.save(entradaAberta);
    }





}
