package com.bcopstein.adaptadores.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bcopstein.negocio.entidades.Item_Carrinho;

public interface IItemCarrinhoCRUD extends CrudRepository<Item_Carrinho,Integer>{
    List<Item_Carrinho> findAll();
    List<Item_Carrinho> findByCodigo(Integer codigo);   
}
