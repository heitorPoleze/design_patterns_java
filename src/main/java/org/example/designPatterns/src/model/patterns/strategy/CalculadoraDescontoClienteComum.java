package org.example.designPatterns.src.model.patterns.strategy;

import org.example.designPatterns.src.model.domain.Pedido;

public class CalculadoraDescontoClienteComum implements CalculadoraDesconto {
    private static final double VALOR_MINIMO = 500.0;

    @Override
    public double calcularDesconto(Pedido pedido) {
        System.out.println("  [STRATEGY] Desconto de Cliente Comum (5% acima de R$ 500)");
        return pedido.getValor() > VALOR_MINIMO ? pedido.getValor() * 0.05 : 0.0;
    }
}
