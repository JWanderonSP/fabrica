package br.com.tech4me.fabrica.shared;

import br.com.tech4me.fabrica.model.Categoria;
import br.com.tech4me.fabrica.model.Modelo;

public record FabricaDto(String id, Modelo modelo,Categoria categoria) {
    
}
