/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wanderley.apibook.dtos;

import com.wanderley.apibook.domain.Categoria;
import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Wanderley
 */
public class CategoriaDTO implements Serializable {

    private Integer id;
    @NotEmpty(message = "O Campo NOME é requerido") // o nome nao pode ser vazio
    @Length(min = 3, max = 100, message = "O Campo NOME deve ter no minimo 3 caracteres e no Maximo 100 caracteres") // no minimo o tamanho 3 e no maximo 100
    private String nome;
    @NotEmpty(message = "O Campo DESCRIÇÃO é requerido")
    @Length(min = 3, max = 200, message = "O Campo DESCRIÇÃO deve ter no minimo 3 caracteres e no Maximo 200 caracteres")
    private String descricao;

    public CategoriaDTO() {
        super();
    }

    public CategoriaDTO(Categoria obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.descricao = obj.getDescricao();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CategoriaDTO other = (CategoriaDTO) obj;
        return Objects.equals(this.id, other.id);
    }

}
