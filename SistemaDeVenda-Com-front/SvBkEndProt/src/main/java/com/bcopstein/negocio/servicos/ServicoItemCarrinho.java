package com.bcopstein.negocio.servicos;

import java.util.List;

import com.bcopstein.negocio.entidades.Item_Carrinho;
import com.bcopstein.negocio.repositorios.IItemCarrinhoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicoItemCarrinho {
    public IItemCarrinhoRepository itemCarrinhoRep;

    @Autowired
    public ServicoItemCarrinho(IItemCarrinhoRepository itemCarrinhoRep){
        this.itemCarrinhoRep = itemCarrinhoRep;
    }

    public List<Item_Carrinho> todos(){
        return itemCarrinhoRep.todos();
    }

    public void cadastraItemCarrinho(Item_Carrinho itemCarrinho){
        itemCarrinhoRep.removeTodos();
        itemCarrinhoRep.cadastra(itemCarrinho);
    }

    public void removeTodos(){
        itemCarrinhoRep.removeTodos();
    }
    
}
