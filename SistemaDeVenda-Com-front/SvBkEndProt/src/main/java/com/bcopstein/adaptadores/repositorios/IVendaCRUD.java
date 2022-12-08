package com.bcopstein.adaptadores.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bcopstein.negocio.entidades.Venda;

public interface IVendaCRUD extends CrudRepository<Venda,Integer>{
    List<Venda> findAll();
    List<Venda> findByCodigo(Integer codigo);   
}
