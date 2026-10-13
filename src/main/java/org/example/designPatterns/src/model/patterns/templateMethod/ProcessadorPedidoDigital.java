package org.example.designPatterns.src.model.patterns.templateMethod;

import org.example.designPatterns.src.model.domain.Pedido;
import org.example.designPatterns.src.model.patterns.observer.ObservadorPedido;
import org.example.designPatterns.src.model.patterns.strategy.CalculadoraDesconto;

public class ProcessadorPedidoDigital extends ProcessadorPedido {

    public ProcessadorPedidoDigital(CalculadoraDesconto calculadoraDesconto, ObservadorPedido[] observadores) {
        super(calculadoraDesconto, observadores);
    }

    @Override
    protected void validar(Pedido pedido) {
        if (pedido.getItens().isEmpty()) {
            throw new IllegalArgumentException("Pedido digital sem produtos");
        }
        String email = pedido.getCliente().getEmail();
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Pedido digital exige e-mail válido do cliente");
        }
    }

    @Override
    protected double calcularTotal(Pedido pedido) {
        double desconto = calculadoraDesconto.calcularDesconto(pedido);
        pedido.setDesconto(desconto);
        System.out.printf("Pedido DIGITAL: %.2f - %.2f (desconto), sem frete%n", pedido.getValor(), desconto);
        return pedido.getValor() - desconto;
    }
}
