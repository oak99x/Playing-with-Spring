package com.bcopstein.aplicacao.servicos;

import com.bcopstein.negocio.entidades.Item_Carrinho;

public interface ICalculoCustoBasico {
    Double calculaCustoBasico(Item_Carrinho[] itens);
}
