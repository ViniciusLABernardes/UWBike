package br.com.UWbike.services;

import br.com.UWbike.dto.MotoResponseDto;
import br.com.UWbike.dto.PatioResponseDto;
import br.com.UWbike.entity.Moto;
import br.com.UWbike.entity.Patio;
import br.com.UWbike.exceptions.IdNaoEncontradoException;

import br.com.UWbike.repository.PatioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatioService {

    @Autowired
    private PatioRepository patioRepository;

    public Patio salvarPatio(Patio patio) {
        try {

            System.out.println("Complemento recebido: " + patio.getComplemento());
            patioRepository.save(patio);
        } catch (Exception e) {
            System.out.println("Houve um erro ao tentar cadastrar o pátio:");
            e.printStackTrace();
        }
        return patio;
    }

    public void removerPatio(Long id) throws IdNaoEncontradoException {

        Patio patio = patioRepository.findById(id)
                .orElseThrow(() -> new IdNaoEncontradoException("Moto não encontrada"));
            patioRepository.deleteById(id);
            System.out.println("Patio: " + patio.getLogradouro() + ", " + patio.getCep() + " deletado com sucesso!");

    }

    @Transactional
    public void atualizarDadosPatio(Long id, Patio patio) throws IdNaoEncontradoException {
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

    public Optional<Patio> visualizarDadosPatioEspecifica(Long id)  {
        return patioRepository.findById(id);
    }

    public List<MotoResponseDto> visualizarMotosQueJaPassaramEstaoNoPatio(Long idPatio) throws IdNaoEncontradoException {
        List<Moto> motos = patioRepository.findMotosByPatio(idPatio);

        if (motos == null || motos.isEmpty()) {
            throw new IdNaoEncontradoException("Nenhuma moto encontrada para o pátio com id " + idPatio);
        }

        return motos.stream()
                .map(moto -> new MotoResponseDto(
                        moto.getId_moto(),
                        moto.getModelo(),
                        moto.getPlaca(),
                        moto.getChassi()))
                .toList();
    }

    public List<PatioResponseDto> listarPatios() {
        try {
            return patioRepository.findAll()
                    .stream()
                    .map(patio -> new PatioResponseDto(
                            patio.getIdPatio(),
                            patio.getLogradouro(),
                            patio.getNumero(),
                            patio.getComplemento(),
                            patio.getCep(),
                            patio.getCidade(),
                            patio.getUf(),
                            patio.getPais(),
                            patio.getLotacao()
                            ))
                    .toList();
        } catch (Exception e) {
            System.out.println("Houve um erro ao tentar resgatar todos os pátios: ");
            e.printStackTrace();
            return new ArrayList<>();
        }
    }


}
