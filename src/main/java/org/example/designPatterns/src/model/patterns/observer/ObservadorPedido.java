package org.example.designPatterns.src.model.patterns.observer;

import org.example.designPatterns.src.model.domain.Pedido;

public interface ObservadorPedido {
    void pedidoProcessado(Pedido pedido);
}
