package com.bcopstein.negocio.repositorios;

import java.util.List;

import com.bcopstein.negocio.entidades.Venda;
public interface IVendaRepository {
    List<Venda> todos();
    void removeTodos();
    boolean cadastra(Venda venda);
}
