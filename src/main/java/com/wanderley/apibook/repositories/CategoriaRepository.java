/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wanderley.apibook.repositories;

import com.wanderley.apibook.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Wanderley
 */
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
    
}
