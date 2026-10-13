package org.example.designPatterns.src.model.patterns.templateMethod;

import org.example.designPatterns.src.model.domain.Pedido;
import org.example.designPatterns.src.model.patterns.observer.ObservadorPedido;
import org.example.designPatterns.src.model.patterns.strategy.CalculadoraDesconto;

public class ProcessadorPedidoFisico extends ProcessadorPedido {
    private static final double FRETE = 25.0;

    public ProcessadorPedidoFisico(CalculadoraDesconto calculadoraDesconto, ObservadorPedido[] observadores) {
        super(calculadoraDesconto, observadores);
    }

    @Override
    protected void validar(Pedido pedido) {
        if (pedido.getItens().isEmpty()) {
            throw new IllegalArgumentException("Pedido físico sem produtos");
        }
        if (pedido.getEnderecoEntrega() == null || pedido.getEnderecoEntrega().isBlank()) {
            throw new IllegalArgumentException("Pedido físico sem endereço de entrega");
        }
    }

    @Override
    protected double calcularTotal(Pedido pedido) {
        double desconto = calculadoraDesconto.calcularDesconto(pedido);
        pedido.setDesconto(desconto);
        System.out.printf("  Pedido FÍSICO: %.2f - %.2f (desconto) + %.2f (frete)%n", pedido.getValor(), desconto, FRETE);
        return pedido.getValor() - desconto + FRETE;
    }
}
