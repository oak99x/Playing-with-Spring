package com.bcopstein.aplicacao.servicos;

import org.springframework.beans.factory.annotation.Autowired;

public class CalculoImposto implements ICalculoImposto{
 
    @Autowired
    public CalculoImposto() {
    }

    public Double calculaImposto(String pais) {
        return 10.0;
    }
    
}
