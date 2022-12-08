package com.bcopstein.adaptadores.repositorios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcopstein.negocio.entidades.Venda;
import com.bcopstein.negocio.repositorios.IVendaRepository;

@Component
public class VendaRepository  implements IVendaRepository {

    private IVendaCRUD vendaCRUD;

    @Autowired
    public VendaRepository(IVendaCRUD vendaCRUD) {
        this.vendaCRUD = vendaCRUD;
    }

    public List<Venda> todos() {
        List<Venda> resp = vendaCRUD.findAll();
        return resp;
    }

    public void removeTodos() {
        vendaCRUD.deleteAll(); 
    }

    public boolean cadastra(Venda venda) {
        vendaCRUD.save(venda);
        return true;
    }
    
}
