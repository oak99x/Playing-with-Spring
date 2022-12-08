package com.bcopstein.aplicacao.casosDeUso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcopstein.negocio.entidades.Produto;
import com.bcopstein.negocio.servicos.ServicoProduto;

@Component
public class CadastraProdutosUC {

    private ServicoProduto servicoProduto;

    @Autowired
    public CadastraProdutosUC(ServicoProduto servicoProduto) {
        this.servicoProduto = servicoProduto;
    }
    
    public void run(Produto produto){
        servicoProduto.cadastraProduto(produto);
    }
    
}
