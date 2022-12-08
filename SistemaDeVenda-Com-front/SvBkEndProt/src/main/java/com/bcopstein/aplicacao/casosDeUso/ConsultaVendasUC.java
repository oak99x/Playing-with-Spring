package com.bcopstein.aplicacao.casosDeUso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcopstein.negocio.entidades.Venda;
import com.bcopstein.negocio.servicos.ServicoVenda;

@Component
public class ConsultaVendasUC {
    private ServicoVenda servicoVenda;

    @Autowired
    public ConsultaVendasUC(ServicoVenda servicoVenda) {
        this.servicoVenda = servicoVenda;
    }

    public List<Venda> run(){
        return servicoVenda.todos();
    } 
}
