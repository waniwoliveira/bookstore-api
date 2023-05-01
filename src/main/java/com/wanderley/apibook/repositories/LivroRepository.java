/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wanderley.apibook.repositories;

import com.wanderley.apibook.domain.Livro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Wanderley
 */
public interface LivroRepository extends JpaRepository<Livro, Integer>{

    @Query("SELECT obj FROM Livro obj WHERE obj.categoria.id = :id_cat ORDER BY titulo")
    public List<Livro> findAllByCategoria(@Param(value =  "id_cat")Integer id_cat);
    
}
