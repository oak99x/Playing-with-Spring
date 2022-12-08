package com.bcopstein.aplicacao.dtos;

import com.bcopstein.negocio.entidades.Item_Carrinho;

public class ParamSubTotalDTO {
    
    private Item_Carrinho[] itens;
    private String endereco;

    public ParamSubTotalDTO(Item_Carrinho[] itens, String endereco) {
        this.itens = itens;
        this.endereco = endereco;
    }

    public Item_Carrinho[] getItens() {
        return itens;
    }

    public void setItens(Item_Carrinho[] itens) {
        this.itens = itens;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }  
    
}