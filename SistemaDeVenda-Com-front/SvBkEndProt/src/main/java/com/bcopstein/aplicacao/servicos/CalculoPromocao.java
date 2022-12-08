package com.bcopstein.aplicacao.servicos;

import org.springframework.beans.factory.annotation.Autowired;

import com.bcopstein.negocio.entidades.Item_Carrinho;
import com.bcopstein.negocio.repositorios.IProdutoRepository;

public class CalculoPromocao implements ICalculoPromocao {

    private IProdutoRepository produtos;
    private double taxaPromocao;
    
    @Autowired
    public CalculoPromocao(IProdutoRepository produtos, double taxaPromocao) {
        this.produtos = produtos;
        this.taxaPromocao = taxaPromocao;
    }

    public Double calculaPromocao(Item_Carrinho[] itens) {

        return 5.0;
    }

}
