package com.bcopstein.aplicacao.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcopstein.aplicacao.dtos.TotalDTO;
import com.bcopstein.negocio.entidades.Item_Carrinho;
import com.bcopstein.negocio.entidades.Produto;
import com.bcopstein.negocio.entidades.Venda;
import com.bcopstein.negocio.repositorios.IItemCarrinhoRepository;
import com.bcopstein.negocio.repositorios.IProdutoRepository;
import com.bcopstein.negocio.repositorios.IVendaRepository;

@Component
public class ServicoRegistrodeVendas {

    private IProdutoRepository produtoRep;
    private IItemCarrinhoRepository itemCarrinhoRep;
    private IVendaRepository vendaRep;

    
    @Autowired
    public ServicoRegistrodeVendas(IProdutoRepository produtoRep, IItemCarrinhoRepository itemCarrinhoRep,
            IVendaRepository vendaRep) {

        this.produtoRep = produtoRep;
        this.itemCarrinhoRep = itemCarrinhoRep;
        this.vendaRep = vendaRep;

    }

    public boolean registraVenda(Item_Carrinho[] itens, TotalDTO totalDTO){

        for (Item_Carrinho item : itens) {
            final Produto produto = produtoRep.todos()
                                            .stream()
                                            .filter(p -> p.getCodigo() == item.getCodigo())
                                            .findAny()
                                            .orElse(null);
      
            if (produto == null) {
              itemCarrinhoRep.removeTodos();
              return false;  
            }
           
            
           itemCarrinhoRep.cadastra(new Item_Carrinho(produto.getCodigo(), produto, item.getQuantidade(), (produto.getPreco()*item.getQuantidade()) ));
        }

        vendaRep.cadastra(new Venda( null, null, totalDTO.getSubTotal(), totalDTO.getImposto(),
                                     totalDTO.getFrete(), totalDTO.getTotal()));

        itemCarrinhoRep.removeTodos();
        return true;
    }
    
}
