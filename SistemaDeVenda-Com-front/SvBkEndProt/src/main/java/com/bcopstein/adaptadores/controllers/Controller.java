package com.bcopstein.adaptadores.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bcopstein.aplicacao.casosDeUso.AtualizaEstoqueUC;
import com.bcopstein.aplicacao.casosDeUso.CadastraItemsCarrinhoUC;
import com.bcopstein.aplicacao.casosDeUso.CadastraProdutosUC;
import com.bcopstein.aplicacao.casosDeUso.ConsultaProdutosUC;
import com.bcopstein.aplicacao.casosDeUso.ConsultaSubTotalUC;
import com.bcopstein.aplicacao.casosDeUso.ConsultaTotalUC;
import com.bcopstein.aplicacao.casosDeUso.CadastraVendasUC;
import com.bcopstein.aplicacao.casosDeUso.ConsultaEstoqueUC;
import com.bcopstein.aplicacao.casosDeUso.ConsultaItemsCarrinhoUC;
import com.bcopstein.aplicacao.casosDeUso.ConsultaVendasUC;
import com.bcopstein.aplicacao.dtos.ParamSubTotalDTO;
import com.bcopstein.aplicacao.dtos.SubTotalDTO;
import com.bcopstein.aplicacao.dtos.TotalDTO;
import com.bcopstein.negocio.entidades.Item_Carrinho;
import com.bcopstein.negocio.entidades.Produto;
import com.bcopstein.negocio.entidades.Venda;
import com.google.gson.Gson;

@RestController
@RequestMapping("/vendas")
public class Controller {

  private ConsultaProdutosUC consultaProdutosUC;
  private ConsultaItemsCarrinhoUC consultaItemsCarrinhoUC;
  private ConsultaVendasUC consultaVendasUC;

  private CadastraProdutosUC cadastraProdutosUC;
  private CadastraItemsCarrinhoUC cadastraItemsCarrinhoUC;
  private CadastraVendasUC cadastraVendasUC;

  private ConsultaTotalUC consultaTotalUC;
  private ConsultaSubTotalUC consultaSubTotalUC;

  private ConsultaEstoqueUC consultaEstoqueUC;
  private AtualizaEstoqueUC atualizaEstoqueUC;
  //private ConsultaFreteUC consultaFreteUC;
  //private ConsultaImposto ConsultaImposto;

  TotalDTO total;

  @Autowired
  public Controller(ConsultaProdutosUC consultaProdutosUC, ConsultaItemsCarrinhoUC consultaItemsCarrinhoUC,
      ConsultaVendasUC consultaVendasUC, CadastraProdutosUC cadastraProdutosUC,
      CadastraItemsCarrinhoUC cadastraItemsCarrinhoUC, CadastraVendasUC cadastraVendasUC,
      ConsultaTotalUC consultaTotalUC, ConsultaSubTotalUC consultaSubTotalUC, ConsultaEstoqueUC consultaEstoqueUC,
      AtualizaEstoqueUC atualizaEstoqueUC) {

    this.consultaProdutosUC = consultaProdutosUC;
    this.consultaItemsCarrinhoUC = consultaItemsCarrinhoUC;
    this.consultaVendasUC = consultaVendasUC;
    this.cadastraProdutosUC = cadastraProdutosUC;
    this.cadastraItemsCarrinhoUC = cadastraItemsCarrinhoUC;
    this.cadastraVendasUC = cadastraVendasUC;
    this.consultaTotalUC = consultaTotalUC;
    this.consultaSubTotalUC = consultaSubTotalUC;
    this.consultaEstoqueUC = consultaEstoqueUC;
    this.atualizaEstoqueUC = atualizaEstoqueUC;
  }

  @GetMapping("/produtos")
  @CrossOrigin(origins = "*")
  public List<Produto> listaProdutos() {
    return consultaProdutosUC.run();
  }

  @PostMapping("/produtos")
  @CrossOrigin(origins = "*")
  public boolean cadastraProduto(@RequestBody String produto) {
    
    cadastraProdutosUC.run(new Gson().fromJson(produto, Produto.class));
    return true;
  }

  @GetMapping("/itens_carrinho")
  @CrossOrigin(origins = "*")
  public List<Item_Carrinho> listaItensCarrinho() {
    return consultaItemsCarrinhoUC.run();
  }

  @GetMapping("/historico")
  @CrossOrigin(origins = "*")
  public List<Venda> vendasEfetuadas() {
    return consultaVendasUC.run();
  }

  @GetMapping("/autorizacao")
  @CrossOrigin(origins = "*")
  public boolean podeVender(@RequestParam final Integer codProd, @RequestParam final Integer qtdade) {

    final boolean disponivel = consultaEstoqueUC.run(codProd, qtdade);
    return disponivel;
  }

  @PostMapping("/subtotal")
  @CrossOrigin(origins = "*")
  public Double[] calculaSubtotal(@RequestBody final ParamSubTotalDTO param) {

    //SubTotalDTO subtotal = consultaSubTotalUC.run(param);
    total = consultaTotalUC.run(param);

    final Double[] resp = new Double[4];
    resp[0] = total.getSubTotal();
    resp[1] = total.getImposto();
    resp[2] = total.getTotal();
    resp[3] = total.getFrete();

    return resp;
  }

  @PostMapping("/confirmacao")
  @CrossOrigin(origins = "*")
  public boolean confirmaVenda(@RequestBody final Item_Carrinho[] itens) {

    if(cadastraVendasUC.run(itens, total)){
      atualizaEstoqueUC.run(itens);
    }
    
    return true;
  }
 

}
