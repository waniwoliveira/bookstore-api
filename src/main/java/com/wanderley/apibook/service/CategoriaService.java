/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wanderley.apibook.service;

import com.wanderley.apibook.dtos.CategoriaDTO;
import com.wanderley.apibook.domain.Categoria;
import com.wanderley.apibook.service.exceptions.ObjectNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wanderley.apibook.repositories.CategoriaRepository;
import org.springframework.dao.DataIntegrityViolationException;

/**
 *
 * @author Wanderley
 */
@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository cidadeRepository;

    public Categoria findById(Integer id) {
        Optional<Categoria> obj = cidadeRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado! id: " + id + " " + Categoria.class.getName()));
    }

    public List<Categoria> findAll() {
        return cidadeRepository.findAll();
    }

    public Categoria create(Categoria obj) {
        obj.setId(null);
        return cidadeRepository.save(obj);
    }

    public Categoria update(Integer id, CategoriaDTO objDTO) {
        Categoria obj = findById(id);
        obj.setNome(objDTO.getNome());
        obj.setDescricao(objDTO.getDescricao());
        return cidadeRepository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            cidadeRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new com.wanderley.apibook.service.exceptions.DataIntegrityViolationException("Objeto não pode ser deletado!");
        }

    }

}
