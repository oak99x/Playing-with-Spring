package com.bcopstein.aplicacao.casosDeUso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcopstein.aplicacao.servicos.ServicoEstoque;
import com.bcopstein.negocio.entidades.Item_Carrinho;

@Component
public class AtualizaEstoqueUC {
    
    private ServicoEstoque servicoEstoque;

    @Autowired
    public AtualizaEstoqueUC(ServicoEstoque servicoEstoque) {
        this.servicoEstoque = servicoEstoque;
    }

    public void run(Item_Carrinho[] itens){
        servicoEstoque.atualizaEstoque(itens);
    } 
}
