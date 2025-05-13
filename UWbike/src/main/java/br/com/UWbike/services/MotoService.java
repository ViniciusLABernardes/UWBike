package br.com.UWbike.services;

import br.com.UWbike.entity.Moto;
import br.com.UWbike.repository.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MotoService {

    @Autowired
    private MotoRepository motoRepository;

    public Moto salvarMoto(Moto moto){return motoRepository.save(moto);}

    public void removerMoto(Long id, Moto moto){
        Moto motoAchada = motoRepository.findById(id).get();
        if(motoAchada.equals(moto)){
            motoRepository.deleteById(id);
            System.out.println("Moto: " + moto.getId_moto() + ", " + moto.getPlaca() + " deletada com sucesso!");
        }else{
            System.out.println("Moto especificada não condiz com a moto com o id inserido");
        }


    }
}
