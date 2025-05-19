package br.com.UWbike.controller;

import br.com.UWbike.dto.AncoraRequestDto;
import br.com.UWbike.dto.AncoraResponseDto;
import br.com.UWbike.entity.Ancora;
import br.com.UWbike.exceptions.IdNaoEncontradoException;
import br.com.UWbike.services.AncoraService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ancora")
public class AncoraController {

    @Autowired
    private AncoraService ancoraService;

    @PostMapping
    public ResponseEntity<AncoraResponseDto> cadastrarAncora(@Valid @RequestBody AncoraRequestDto ancoraRequestDto) throws IdNaoEncontradoException {
        Ancora ancora = new Ancora(ancoraRequestDto.getX(), ancoraRequestDto.getY());
        Ancora ancoraSalva = ancoraService.salvarAncoraComPatio(ancora, ancoraRequestDto.getIdPatio());
        return ResponseEntity.ok(new AncoraResponseDto(ancoraSalva.getId(),ancoraSalva.getX(),ancoraSalva.getY(),ancoraRequestDto.getPatio()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AncoraResponseDto> lerAncoraEspecifica(@PathVariable Long id){
        return ancoraService.visualizarDadosAncoraEspecifica(id)
                .map(ancora -> ResponseEntity.ok(
                        new AncoraResponseDto(ancora.getId(),ancora.getX(),ancora.getY(),ancora.getPatio()))
                )
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AncoraResponseDto> atualizarAncora(@PathVariable Long id, @Valid @RequestBody AncoraRequestDto ancoraRequestDto) {

        Ancora novaAncora = new Ancora(ancoraRequestDto.getX(), ancoraRequestDto.getY());

        try {
            ancoraService.atualizarDadosAncora(id, novaAncora);
            return ResponseEntity.ok(new AncoraResponseDto(id, ancoraRequestDto.getX(), ancoraRequestDto.getY(), ancoraRequestDto.getPatio()));
        } catch (IdNaoEncontradoException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AncoraResponseDto> deletarAncora(@PathVariable Long id){
        if(ancoraService.visualizarDadosAncoraEspecifica(id).isPresent()){
            try {
                ancoraService.removerAncora(id);
                return ResponseEntity.noContent().build();
            } catch (IdNaoEncontradoException e) {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.notFound().build();
    }
}
