package com.bcopstein.aplicacao.casosDeUso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcopstein.aplicacao.dtos.ParamSubTotalDTO;
import com.bcopstein.aplicacao.dtos.SubTotalDTO;
import com.bcopstein.aplicacao.servicos.ServicoDeCusto;

@Component
public class ConsultaSubTotalUC {
    private ServicoDeCusto servicoDeCusto;
    
    @Autowired
    public ConsultaSubTotalUC(ServicoDeCusto servicoDeCusto) {
        this.servicoDeCusto = servicoDeCusto;
    }

    public SubTotalDTO run(ParamSubTotalDTO param){
        return servicoDeCusto.calculaSubTotal(param);
    }
}
