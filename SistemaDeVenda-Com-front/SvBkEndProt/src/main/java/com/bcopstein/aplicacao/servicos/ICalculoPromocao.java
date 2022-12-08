package com.bcopstein.aplicacao.servicos;

import com.bcopstein.negocio.entidades.Item_Carrinho;

public interface ICalculoPromocao {
    Double calculaPromocao( Item_Carrinho[] itens);
}
