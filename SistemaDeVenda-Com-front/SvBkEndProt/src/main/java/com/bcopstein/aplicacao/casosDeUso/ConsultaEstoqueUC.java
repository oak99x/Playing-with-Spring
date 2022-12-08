package com.bcopstein.aplicacao.casosDeUso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcopstein.aplicacao.servicos.ServicoEstoque;

@Component
public class ConsultaEstoqueUC {
    
    private ServicoEstoque servicoEstoque;

    @Autowired
    public ConsultaEstoqueUC(ServicoEstoque servicoEstoque) {
        this.servicoEstoque = servicoEstoque;
    }

    public boolean run(Integer codProd, Integer qtdade){
        return servicoEstoque.consultaEstoque(codProd, qtdade);
    } 
}
