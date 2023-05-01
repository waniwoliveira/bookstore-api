/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wanderley.apibook.resources;

import com.wanderley.apibook.dtos.CategoriaDTO;
import com.wanderley.apibook.domain.Categoria;
import com.wanderley.apibook.service.CategoriaService;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author Wanderley
 */
@CrossOrigin("*")// pode receber requisicoes de diversas outras fontes
@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @Autowired
    CategoriaService cidadeService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Integer id) {
        Categoria obj = cidadeService.findById(id);
        return ResponseEntity.ok(obj);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> findAll() {
        List<Categoria> list = cidadeService.findAll();
        List<CategoriaDTO> listDTO = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    //essa anotação @Valid que faz a validação
    public ResponseEntity<Categoria> create(@Valid @RequestBody Categoria obj) {
        obj = cidadeService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build(); //pega o caminho da url implementada
        //return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    //essa anotação @Valid que faz a validação
    public ResponseEntity<CategoriaDTO> update(@Valid @PathVariable Integer id, @RequestBody CategoriaDTO objDTO) {
        Categoria newObj = cidadeService.update(id, objDTO);
        return ResponseEntity.ok().body(new CategoriaDTO(newObj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        cidadeService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
