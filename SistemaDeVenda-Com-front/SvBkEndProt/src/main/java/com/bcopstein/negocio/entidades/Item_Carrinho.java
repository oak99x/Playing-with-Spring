package com.bcopstein.negocio.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Item_Carrinho {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer codigo;
  
  @OneToOne()
  private Produto produto;
  private int quantidade;
  private double precoItem;
  
  public Item_Carrinho() {
  }

  public Item_Carrinho(Integer codigo, int quantidade) {
    this.codigo = codigo;
    this.quantidade = quantidade;
  }

  public Item_Carrinho(Integer codigo, Produto produto, int quantidade, double precoItem) {
    this.codigo = codigo;
    this.produto = produto;
    this.quantidade = quantidade;
    this.precoItem = precoItem;
  }

  public Integer getCodigo() {
    return codigo;
  }

  public int getQuantidade() {
    return quantidade;
  }

  

  public Produto getProduto() {
    return produto;
  }

  public double getPrecoItem() {
    return precoItem;
  }

  @Override
  public String toString() {
    return "Item_Carrinho [codigo=" + codigo + ", precoItem=" + precoItem + ", produto=" + produto + ", quantidade="
        + quantidade + "]";
  }

 

 

  
 

 

  

  
}
