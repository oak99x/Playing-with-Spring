package com.bcopstein.aplicacao.casosDeUso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcopstein.aplicacao.dtos.TotalDTO;
import com.bcopstein.aplicacao.servicos.ServicoRegistrodeVendas;
import com.bcopstein.negocio.entidades.Item_Carrinho;

@Component
public class CadastraVendasUC {

    private ServicoRegistrodeVendas servicoRegistrodeVendas;

    @Autowired
    public CadastraVendasUC(ServicoRegistrodeVendas servicoRegistrodeVendas) {
        this.servicoRegistrodeVendas = servicoRegistrodeVendas;
    }
    
    public boolean run(Item_Carrinho[] itens, TotalDTO totalDTO){
        return servicoRegistrodeVendas.registraVenda(itens, totalDTO);
    }
    
}