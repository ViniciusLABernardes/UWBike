package br.com.UWbike.services;

import br.com.UWbike.entity.Patio;
import br.com.UWbike.exceptions.IdNaoEncontradoException;

import br.com.UWbike.repository.PatioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatioService {

    @Autowired
    private PatioRepository patioRepository;

    public Patio salvarPatio(Patio patio){
        Patio patioNovo = new Patio();
        try {
            System.out.println("Patio cadastrado com sucesso!");
            patioNovo = patioRepository.save(patio);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return patioNovo;
    }

    public void removerPatio(Long id, Patio patio) throws IdNaoEncontradoException {
        Patio patioAchado = patioRepository.findById(id)
                .orElseThrow(() -> new IdNaoEncontradoException("Patio não encontrado"));
        if(patioAchado.equals(patio)){
            patioRepository.deleteById(id);
            System.out.println("Patio: " + patio.getLogradouro() + ", " + patio.getCep() + " deletado com sucesso!");
        }else{
            System.out.println("Patio especificada não condiz com a patio com o id inserido");
        }
    }

    @Transactional
    public void atualizarDadosPatio(Long id, Patio patio) throws IdNaoEncontradoException{
        Patio patioAchada = patioRepository.findById(id)
                .orElseThrow(() -> new IdNaoEncontradoException("Patio não encontrado"));
        patioAchada.setLogradouro(patio.getLogradouro());
        patioAchada.setNumero(patio.getNumero());
        patioAchada.setCep(patio.getCep());
        patioAchada.setComplemento(patio.getComplemento());
        patioAchada.setCidade(patio.getCidade());
        patioAchada.setUf(patio.getUf());
        patioAchada.setPais(patio.getPais());

        System.out.println("Patio: " + patioAchada.getIdPatio() + ", "
                + " atualizada com sucesso para: "
                + patio.getLogradouro() + " " + patio.getNumero() + ", "
                + patio.getComplemento() + ", " + patio.getCep() + ", " + patio.getCidade() +
                ", " + patio.getUf() + ", " + patio.getPais());

    }

    public Patio visualizarDadosPatioEspecifica(Long id)throws IdNaoEncontradoException {
        return patioRepository.findById(id)
                .orElseThrow(() -> new IdNaoEncontradoException("Patio não encontrada"));
    }
}
