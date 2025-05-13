package br.com.UWbike.services;

import br.com.UWbike.entity.Moto;
import br.com.UWbike.exceptions.IdNaoEncontradoException;
import br.com.UWbike.repository.MotoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MotoService {

    @Autowired
    private MotoRepository motoRepository;

    public Moto salvarMoto(Moto moto){
        Moto motoNova = new Moto();
        try {
            System.out.println("Moto cadastrada com sucesso!");
           motoNova = motoRepository.save(moto);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return motoNova;
    }

    public void removerMoto(Long id, Moto moto) throws IdNaoEncontradoException{
        Moto motoAchada = motoRepository.findById(id)
                .orElseThrow(() -> new IdNaoEncontradoException("Moto não encontrada"));
        if(motoAchada.equals(moto)){
            motoRepository.deleteById(id);
            System.out.println("Moto: " + moto.getId_moto() + ", " + moto.getPlaca() + " deletada com sucesso!");
        }else{
            System.out.println("Moto especificada não condiz com a moto com o id inserido");
        }
    }

    @Transactional
    public void atualizarDadosMoto(Long id, Moto moto) throws IdNaoEncontradoException{
        Moto motoAchada = motoRepository.findById(id)
                .orElseThrow(() -> new IdNaoEncontradoException("Moto não encontrada"));
        motoAchada.setModelo(moto.getModelo());
        motoAchada.setPlaca(moto.getPlaca());

        System.out.println("Moto: " + motoAchada.getId_moto() + ", "
                + " atualizada com sucesso para: " + moto.getPlaca() + " " + moto.getModelo());

    }

    public Moto visualizarDadosMotoEspecifica(Long id)throws IdNaoEncontradoException {
        Moto motoAchada = motoRepository.findById(id)
                .orElseThrow(() -> new IdNaoEncontradoException("Moto não encontrada"));
        return motoAchada;
    }

}
