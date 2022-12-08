package com.bcopstein.adaptadores.configuradores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bcopstein.aplicacao.servicos.CalculoFrete;
import com.bcopstein.aplicacao.servicos.ICalculoFrete;

@Configuration
public class ConfiguradorCalculoFrete {
    
    @Autowired
    public ConfiguradorCalculoFrete() {
    }

    @Bean
    @ConditionalOnProperty(name = "calculo.frete", havingValue = "original", matchIfMissing = true)
    public ICalculoFrete opcaoFreteClassico() {
        return new CalculoFrete();
    }
}
