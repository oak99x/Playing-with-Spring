package com.bcopstein.aplicacao.casosDeUso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcopstein.negocio.entidades.Item_Carrinho;
import com.bcopstein.negocio.servicos.ServicoItemCarrinho;

@Component
public class ConsultaItemsCarrinhoUC {
    private ServicoItemCarrinho servicoItemCarrinho;

    @Autowired
    public ConsultaItemsCarrinhoUC(ServicoItemCarrinho servicoItemCarrinho) {
        this.servicoItemCarrinho = servicoItemCarrinho;
    }

    public List<Item_Carrinho> run(){
        return servicoItemCarrinho.todos();
    } 
}