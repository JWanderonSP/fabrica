package br.com.tech4me.fabrica.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.fabrica.shared.FabricaDto;
import br.com.tech4me.fabrica.shared.FabricaDtoCompleto;

public interface FabricaService {
    List<FabricaDto> obterTodas();
    Optional<FabricaDtoCompleto> obterPorId(String id);
    FabricaDtoCompleto cadastrar(FabricaDtoCompleto dto);
    FabricaDtoCompleto atualizarPorId(String id, FabricaDtoCompleto dto);
    void excluirPorId(String id);
}
