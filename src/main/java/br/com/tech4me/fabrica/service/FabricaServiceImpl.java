package br.com.tech4me.fabrica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.fabrica.model.Carros;
import br.com.tech4me.fabrica.repository.FabricaRepository;
import br.com.tech4me.fabrica.shared.FabricaDto;
import br.com.tech4me.fabrica.shared.FabricaDtoCompleto;

@Service
public class FabricaServiceImpl implements FabricaService{

    @Autowired
    private FabricaRepository repository;
    
    @Override
    public List<FabricaDto> obterTodas() {
        return repository.findAll()
            .stream()
            .map(p -> new FabricaDto(p.getId(),
                                     p.getModelo(), 
                                     p.getCategoria()))
            .toList();
    }

    @Override
    public Optional<FabricaDtoCompleto> obterPorId(String id) {
        Optional<Carros> carros = repository.findById(id);

        if (carros.isPresent()) {
                    return Optional.of(new FabricaDtoCompleto(carros.get().getId(),
                                                               carros.get().getModelo(),
                                                               carros.get().getCor(),
                                                               carros.get().getCategoria()));                
        } else {
            return Optional.empty();
        }
    }

    @Override
    public FabricaDtoCompleto cadastrar(FabricaDtoCompleto dto) {
        Carros carro = new Carros(dto);
        repository.save(carro);

        return new FabricaDtoCompleto(carro.getId(),
                    carro.getModelo(),
                    carro.getCor(),
                    carro.getCategoria());
                    
    }

    @Override
    public FabricaDtoCompleto atualizarPorId(String id, FabricaDtoCompleto dto) {
        Carros carro = repository.findById(id).orElse(null);

        if (carro != null) {
            Carros carroAtualizar = new Carros(dto);
            carroAtualizar.setId(id);
            repository.save(carroAtualizar);
            return new FabricaDtoCompleto(carroAtualizar.getId(),
                       carroAtualizar.getModelo(),
                       carroAtualizar.getCor(),
                       carroAtualizar.getCategoria());
                       
        } else {
            return null;
        }
    }

    @Override
    public void excluirPorId(String id) {
        repository.deleteById(id);
    }
    
    
}
