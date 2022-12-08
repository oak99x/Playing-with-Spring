package com.bcopstein.negocio.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @OneToMany()
    private List<Item_Carrinho> itens_carrinho;

    private double subtotal;
    private double impostos;
    private double frete;
    private double total;

    
    public Venda() {
    }

    public Venda( Integer codigo, List<Item_Carrinho> itens_carrinho, double subtotal, double impostos, double frete, double total) {

        this.codigo = codigo;
        this.itens_carrinho = itens_carrinho;
        this.subtotal = subtotal;
        this.impostos = impostos;
        this.frete = frete;
        this.total = total;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getImpostos() {
        return impostos;
    }

    public double getFrete() {
        return frete;
    }

    public double getTotal() {
        return total;
    }

    public List<Item_Carrinho> getItens_carrinho() {
        return itens_carrinho;
    }

    @Override
    public String toString() {
        return "Venda [codigo=" + codigo + ", frete=" + frete + ", impostos=" + impostos + ", itens_carrinho="
                + itens_carrinho + ", subtotal=" + subtotal + ", total=" + total + "]";
    }

    

 

  

   




    

    

    


    
}
