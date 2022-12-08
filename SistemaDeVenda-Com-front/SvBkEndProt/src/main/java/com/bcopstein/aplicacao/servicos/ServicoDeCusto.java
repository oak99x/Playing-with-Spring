package com.bcopstein.aplicacao.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcopstein.aplicacao.dtos.ParamSubTotalDTO;
import com.bcopstein.aplicacao.dtos.SubTotalDTO;
import com.bcopstein.aplicacao.dtos.TotalDTO;

@Component
public class ServicoDeCusto {

    private ICalculoCustoBasico calculoCustoBasico;
    private ICalculoFrete calculoFrete;
    private ICalculoImposto calculoImposto;
    private ICalculoPromocao calculoPromocao;
    
    @Autowired
    public ServicoDeCusto(  ICalculoCustoBasico calculoCustoBasico, ICalculoFrete calculoFrete, 
                            ICalculoImposto calculoImposto, ICalculoPromocao calculoPromocao) {

        this.calculoCustoBasico = calculoCustoBasico;
        this.calculoFrete = calculoFrete;
        this.calculoImposto = calculoImposto;
        this.calculoPromocao = calculoPromocao;
    }

    public SubTotalDTO calculaSubTotal(ParamSubTotalDTO parm){

        double subTotal = calculoCustoBasico.calculaCustoBasico(parm.getItens());
        double frete = calculoFrete.calculaFrete(parm.getEndereco());

        return new SubTotalDTO(subTotal, frete);
    }

    public TotalDTO calculaTotal(ParamSubTotalDTO parm){

        double subTotal = calculoCustoBasico.calculaCustoBasico(parm.getItens());
        double frete = calculoFrete.calculaFrete(parm.getEndereco());
        double imposto = calculoImposto.calculaImposto(parm.getEndereco());
        double promocao = calculoPromocao.calculaPromocao(parm.getItens());

        double total = (subTotal+frete+imposto)-promocao;

        return new TotalDTO(total, subTotal, frete, imposto, promocao);
    }

   
    
    
}
