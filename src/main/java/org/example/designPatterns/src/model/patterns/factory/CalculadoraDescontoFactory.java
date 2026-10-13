package org.example.designPatterns.src.model.patterns.factory;

import org.example.designPatterns.src.model.domain.cliente.TipoCliente;
import org.example.designPatterns.src.model.patterns.strategy.CalculadoraDesconto;
import org.example.designPatterns.src.model.patterns.strategy.CalculadoraDescontoClienteComum;
import org.example.designPatterns.src.model.patterns.strategy.CalculadoraDescontoClienteVIP;

public final class CalculadoraDescontoFactory {

    private CalculadoraDescontoFactory() {
    }

    public static CalculadoraDesconto fabricarCalculadora(TipoCliente tipo) {
        return switch (tipo) {
            case VIP -> new CalculadoraDescontoClienteVIP();
            case COMUM -> new CalculadoraDescontoClienteComum();
        };
    }
}
