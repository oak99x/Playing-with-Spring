package com.bcopstein.aplicacao.servicos;

import org.springframework.beans.factory.annotation.Autowired;

import com.bcopstein.negocio.entidades.Item_Carrinho;
import com.bcopstein.negocio.entidades.Produto;
import com.bcopstein.negocio.repositorios.IProdutoRepository;

public class CalculoCustoBasico implements ICalculoCustoBasico{

    private IProdutoRepository produtos;

    @Autowired
    public CalculoCustoBasico(IProdutoRepository produtos) {

        this.produtos = produtos;
    }

    public Double calculaCustoBasico(Item_Carrinho[] itens) {

        double custoBasico = 0;
        for (final Item_Carrinho it : itens) {
            // Procurar o produto pelo código
            final Produto prod = produtos.todos()
                                        .stream()
                                        .filter(p -> p.getCodigo() == it.getCodigo())
                                        .findAny()
                                        .orElse(null);

            if (prod != null) {
                custoBasico += (int) (prod.getPreco() * it.getQuantidade());
            } else {
            throw new IllegalArgumentException("Codigo invalido");
            }
        }
    
        return custoBasico;
    }
    
}
