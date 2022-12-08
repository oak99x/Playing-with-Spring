package com.bcopstein.adaptadores.configuradores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bcopstein.aplicacao.servicos.CalculoImposto;
import com.bcopstein.aplicacao.servicos.ICalculoImposto;

@Configuration
public class ConfiguradorCalculoImposto {
    
    @Autowired
    public ConfiguradorCalculoImposto() {
    }

    @Bean
    @ConditionalOnProperty(name = "calculo.imposto", havingValue = "original", matchIfMissing = true)
    public ICalculoImposto opcaoImpostoClassico() {
        return new CalculoImposto();
    }
}
