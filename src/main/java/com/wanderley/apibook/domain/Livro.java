/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wanderley.apibook.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Wanderley
 */
@Entity
public class Livro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "O Campo TITULO é requerido") // o nome nao pode ser vazio
    @Length(min = 10, max = 50, message = "O Campo TITULO deve ter no minimo 10 caracteres e no Maximo 50 caracteres") // no minimo o tamanho 3 e no maximo 100
    private String titulo;
    @NotEmpty(message = "O Campo NOME DO AUTOR é requerido") // o nome nao pode ser vazio
    @Length(min = 10, max = 50, message = "O Campo NOME DO AUTOR deve ter no minimo 10 caracteres e no Maximo 50 caracteres") // no minimo o tamanho 3 e no maximo 100
    private String nome_autor;
    @NotEmpty(message = "O Campo TEXTO é requerido") // o nome nao pode ser vazio
    @Length(min = 10, max = 2000000, message = "O Campo TEXTO deve ter no minimo 10 caracteres e no Maximo 2.000.000 caracteres") // no minimo o tamanho 3 e no maximo 100
    private String texto;
    @JsonIgnore
    @ManyToOne   //muitos para um
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Livro() {
        super();
    }

    public Livro(Integer id, String titulo, String nome_autor, String texto, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.nome_autor = nome_autor;
        this.texto = texto;
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNome_autor() {
        return nome_autor;
    }

    public void setNome_autor(String nome_autor) {
        this.nome_autor = nome_autor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}
