package com.bcopstein.adaptadores.configuradores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bcopstein.aplicacao.servicos.CalculoPromocao;
import com.bcopstein.aplicacao.servicos.ICalculoPromocao;
import com.bcopstein.negocio.repositorios.IProdutoRepository;

@Configuration
public class ConfiguradorCalculoPromocao {

    private IProdutoRepository produtos;
    
    @Autowired
    public ConfiguradorCalculoPromocao(IProdutoRepository produtos) {
        this.produtos = produtos;
    }

    @Bean
    @ConditionalOnProperty(name = "calculo.promocao", havingValue = "original", matchIfMissing = true)
    public ICalculoPromocao opcaoPromocaoClassica() {
        return new CalculoPromocao( produtos, 10);
    }
}
