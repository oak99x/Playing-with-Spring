package com.bcopstein.adaptadores.repositorios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcopstein.negocio.entidades.Produto;
import com.bcopstein.negocio.repositorios.IProdutoRepository;

@Component
public class ProdutoRepository implements IProdutoRepository{

    private IProdutoCRUD produtoCRUD;


    @Autowired
    public ProdutoRepository(IProdutoCRUD produtoCRUD) {
        this.produtoCRUD = produtoCRUD;
    }

    public List<Produto> todos() {
        List<Produto> resp = produtoCRUD.findAll();
        return resp;
    }

    public void removeTodos() {
        produtoCRUD.deleteAll();
        
    }

    public boolean cadastra(Produto produto) {
        produtoCRUD.save(produto);
        return true;
    }

    public void remove(Produto produto) {
        produtoCRUD.delete(produto);    
    }
    
}
