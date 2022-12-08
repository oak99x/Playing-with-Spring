package com.bcopstein.aplicacao.casosDeUso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bcopstein.aplicacao.dtos.ParamSubTotalDTO;
import com.bcopstein.aplicacao.dtos.TotalDTO;
import com.bcopstein.aplicacao.servicos.ServicoDeCusto;

@Component
public class ConsultaTotalUC {
    private ServicoDeCusto servicoDeCusto;
    
    @Autowired
    public ConsultaTotalUC(ServicoDeCusto servicoDeCusto) {
        this.servicoDeCusto = servicoDeCusto;
    }

    public TotalDTO run(ParamSubTotalDTO param){
        return servicoDeCusto.calculaTotal(param);
    }
}
