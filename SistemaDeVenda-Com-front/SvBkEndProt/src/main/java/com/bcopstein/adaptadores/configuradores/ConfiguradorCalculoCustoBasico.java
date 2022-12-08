package com.bcopstein.adaptadores.configuradores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bcopstein.aplicacao.servicos.CalculoCustoBasico;
import com.bcopstein.aplicacao.servicos.ICalculoCustoBasico;
import com.bcopstein.negocio.repositorios.IProdutoRepository;

@Configuration
public class ConfiguradorCalculoCustoBasico {

    private IProdutoRepository produtos;
    
    @Autowired
    public ConfiguradorCalculoCustoBasico(IProdutoRepository produtos) {
        this.produtos = produtos;
    }

    @Bean
    @ConditionalOnProperty(name = "calculo.custobasico", havingValue = "original", matchIfMissing = true)
    public ICalculoCustoBasico opcaoCustoBasico() {
        return new CalculoCustoBasico(produtos);
    }
}
