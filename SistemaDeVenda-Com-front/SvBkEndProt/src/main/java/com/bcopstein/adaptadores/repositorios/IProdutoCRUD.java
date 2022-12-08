package com.bcopstein.adaptadores.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bcopstein.negocio.entidades.Produto;

public interface IProdutoCRUD extends CrudRepository<Produto,Integer>{
    List<Produto> findAll();
    List<Produto> findByCodigo(Integer codigo);   
}
