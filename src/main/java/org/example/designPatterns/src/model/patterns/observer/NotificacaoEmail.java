package org.example.designPatterns.src.model.patterns.observer;

import org.example.designPatterns.src.model.domain.Pedido;

public class NotificacaoEmail implements ObservadorPedido {

    @Override
    public void pedidoProcessado(Pedido pedido) {
        System.out.println("  [E-MAIL] Enviando para " + pedido.getCliente().getEmail() + ": " + pedido);
    }
}
