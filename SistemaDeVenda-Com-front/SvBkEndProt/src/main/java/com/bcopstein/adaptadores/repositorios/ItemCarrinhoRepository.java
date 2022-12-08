package com.bcopstein.adaptadores.repositorios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcopstein.negocio.entidades.Item_Carrinho;
import com.bcopstein.negocio.repositorios.IItemCarrinhoRepository;

@Component
public class ItemCarrinhoRepository implements IItemCarrinhoRepository{


    private IItemCarrinhoCRUD itemCarrinhoCRUD;

    @Autowired
    public ItemCarrinhoRepository(IItemCarrinhoCRUD itemCarrinhoCRUD) {
        this.itemCarrinhoCRUD = itemCarrinhoCRUD;
    }

    //@Override
    public List<Item_Carrinho> todos() {
        List<Item_Carrinho> resp = itemCarrinhoCRUD.findAll();
        return resp;
    }

    //@Override
    public void removeTodos() {
        itemCarrinhoCRUD.deleteAll();    
    }

    //@Override
    public boolean cadastra(Item_Carrinho itemCarrinho) {
        itemCarrinhoCRUD.save(itemCarrinho);
        return true;
    }
    
}
