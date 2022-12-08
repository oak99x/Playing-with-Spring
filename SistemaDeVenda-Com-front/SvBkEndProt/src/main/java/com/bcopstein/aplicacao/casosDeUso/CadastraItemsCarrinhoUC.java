package com.bcopstein.aplicacao.casosDeUso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcopstein.negocio.entidades.Item_Carrinho;
import com.bcopstein.negocio.servicos.ServicoItemCarrinho;



@Component
public class CadastraItemsCarrinhoUC {

    private ServicoItemCarrinho servicoItemCarrinho;

    @Autowired
    public CadastraItemsCarrinhoUC(ServicoItemCarrinho servicoItemCarrinho) {
        this.servicoItemCarrinho = servicoItemCarrinho;
    }
    
    public void run(Item_Carrinho itemCarrinho){
        servicoItemCarrinho.cadastraItemCarrinho(itemCarrinho);
    }
    
}
