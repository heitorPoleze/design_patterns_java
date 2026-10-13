package org.example.designPatterns.src.model.patterns.strategy;

import org.example.designPatterns.src.model.domain.Pedido;

public class CalculadoraDescontoClienteVIP implements CalculadoraDesconto {
    @Override
    public double calcularDesconto(Pedido pedido) {
        System.out.println("  [STRATEGY] Desconto de Cliente VIP (20%)");
        //20% desconto
        return pedido.getValor() * 0.20;
    }
}
