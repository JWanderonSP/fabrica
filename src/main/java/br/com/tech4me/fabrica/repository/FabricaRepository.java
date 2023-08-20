package br.com.tech4me.fabrica.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.fabrica.model.Carros;

public interface FabricaRepository extends MongoRepository<Carros, String> {
    
}
