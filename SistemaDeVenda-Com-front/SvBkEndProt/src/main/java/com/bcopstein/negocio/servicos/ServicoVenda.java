package com.bcopstein.negocio.servicos;

import java.util.List;

import com.bcopstein.negocio.entidades.Venda;
import com.bcopstein.negocio.repositorios.IVendaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicoVenda {
    public IVendaRepository vendaRep;

    @Autowired
    public ServicoVenda(IVendaRepository vendaRep){
        this.vendaRep = vendaRep;
    }

    public List<Venda> todos(){
        return vendaRep.todos();
    }

    public void cadastraVenda(Venda venda){
        vendaRep.cadastra(venda);
    }

    public void removeTodos(){
        vendaRep.removeTodos();
    }
    
}
