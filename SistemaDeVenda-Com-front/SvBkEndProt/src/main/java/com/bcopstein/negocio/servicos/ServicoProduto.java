package com.bcopstein.negocio.servicos;

import java.util.List;

import com.bcopstein.negocio.entidades.Produto;
import com.bcopstein.negocio.repositorios.IProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicoProduto {
    public IProdutoRepository produtoRep;

    @Autowired
    public ServicoProduto(IProdutoRepository produtoRep){
        this.produtoRep = produtoRep;
    }

    public List<Produto> todos(){
        return produtoRep.todos();
    }

    public void cadastraProduto(Produto produto){
        produtoRep.cadastra(produto);
    }

    public void removeProduto(Produto produto){
        produtoRep.remove(produto);
    }

    public void removeTodos(){
        produtoRep.removeTodos();
    }
    
}
