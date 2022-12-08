package com.bcopstein.negocio.repositorios;

import java.util.List;

import com.bcopstein.negocio.entidades.Item_Carrinho;

public interface IItemCarrinhoRepository {
    List<Item_Carrinho> todos();
    void removeTodos();
    boolean cadastra(Item_Carrinho itemCarrinho);
}
