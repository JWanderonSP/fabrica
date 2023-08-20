package br.com.tech4me.fabrica.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.tech4me.fabrica.shared.FabricaDto;
import br.com.tech4me.fabrica.shared.FabricaDtoCompleto;

@Document("carros")
public class Carros {
    
    @Id
    private String id;
    private Modelo modelo;
    private Cor cor;
    private Categoria categoria;

    public Carros(){}

    public Carros(FabricaDtoCompleto dto){
        this.id = dto.id();
        this.modelo = dto.modelo();
        this.cor = dto.cor();
        this.categoria = dto.categoria();
        }

    public Carros(FabricaDto dto){
        this.id = dto.id();
        this.modelo = dto.modelo();
        this.categoria = dto.categoria();
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Modelo getModelo() {
        return modelo;
    }
    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
    public Cor getCor() {
        return cor;
    }
    public void setCor(Cor cor) {
        this.cor = cor;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
  
}
