package com.bcopstein.aplicacao.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcopstein.negocio.entidades.Item_Carrinho;
import com.bcopstein.negocio.entidades.Produto;
import com.bcopstein.negocio.repositorios.IProdutoRepository;

@Component
public class ServicoEstoque {

    private IProdutoRepository produtoRep;

    @Autowired
    public ServicoEstoque(IProdutoRepository produtoRep) {
        this.produtoRep = produtoRep;
    }

    public boolean consultaEstoque(Integer codProd, Integer quantidade){

        boolean disponivel = produtoRep.todos()
                                             .stream()
                                             .anyMatch(p -> p.getCodigo() == codProd && p.getQtdade() >= quantidade);

        return disponivel;
    }

    public void atualizaEstoque(Item_Carrinho[] itens){
        
        for (Item_Carrinho item : itens) {
            Produto produto = produtoRep.todos()
                                            .stream()
                                            .filter(p -> p.getCodigo() == item.getCodigo())
                                            .findAny()
                                            .orElse(null);

            int qtdade = item.getQuantidade();

            produto.saidaDeProduto(qtdade);
            produtoRep.cadastra(produto);
        }

    }

    
    
}
