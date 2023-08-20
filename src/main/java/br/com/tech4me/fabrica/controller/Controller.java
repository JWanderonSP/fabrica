package br.com.tech4me.fabrica.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.fabrica.service.FabricaService;
import br.com.tech4me.fabrica.shared.FabricaDto;
import br.com.tech4me.fabrica.shared.FabricaDtoCompleto;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/carros")
public class Controller {
    
    @Autowired
    private FabricaService service;

    
    @GetMapping("/porta")
    private String obterPorta(@Value("${local.server.port}") String porta) {
        return "A instância que respondeu a requisição está rodando na porta " + porta;
    }
    
    @GetMapping
    private ResponseEntity<List<FabricaDto>> obterTodas() {
        return new ResponseEntity<>(service.obterTodas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<FabricaDtoCompleto> obterPorId(@PathVariable String id) {
        Optional<FabricaDtoCompleto> carro = service.obterPorId(id);

        if (carro.isPresent()) {
            return new ResponseEntity<>(carro.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    private ResponseEntity<FabricaDtoCompleto> cadastrar(@RequestBody @Valid FabricaDtoCompleto carro) {
        return new ResponseEntity<>(service.cadastrar(carro), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    private ResponseEntity<FabricaDtoCompleto> atualizar(@PathVariable String id, @RequestBody @Valid FabricaDtoCompleto carro) {
        FabricaDtoCompleto carroAtualizado = service.atualizarPorId(id, carro);

        if (carroAtualizado != null) {
            return new ResponseEntity<>(carroAtualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> excluir(@PathVariable String id) {
        service.excluirPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
