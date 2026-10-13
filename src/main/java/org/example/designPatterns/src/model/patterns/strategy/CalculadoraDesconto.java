package org.example.designPatterns.src.model.patterns.strategy;
import org.example.designPatterns.src.model.domain.Pedido;

public interface CalculadoraDesconto {
    double calcularDesconto(Pedido pedido);
}
