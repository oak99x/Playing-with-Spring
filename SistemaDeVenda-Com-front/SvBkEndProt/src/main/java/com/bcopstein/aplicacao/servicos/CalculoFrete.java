package com.bcopstein.aplicacao.servicos;

import org.springframework.beans.factory.annotation.Autowired;

public class CalculoFrete implements ICalculoFrete{
    
    @Autowired
    public CalculoFrete() {

    }

    public Double calculaFrete(String endereco) {

        // //Verifica se o endereço é invalido
        // if (endereco == null || endereco.isEmpty() || endereco().isBlank()){
        //     throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Endereco invalido");
        // }
        
        // // Verifica se o endereço já está na cache
        // if (!cacheFrete.keySet().contains(param.getEndereco())){
        //   // Calcula o frete 
        //   cacheFrete.put(param.getEndereco(),25);
        // }

        return 25.0;
    }
    
}
