package org.example.designPatterns.src.model.patterns.observer.singleton;

import org.example.designPatterns.src.model.domain.Pedido;
import org.example.designPatterns.src.model.patterns.observer.ObservadorPedido;

public enum Estoque implements ObservadorPedido {

    INSTANCIA;

    private void baixar(String item) {
        System.out.println("  [ESTOQUE] Baixando do estoque o item: " + item);
    }

    @Override
    public void pedidoProcessado(Pedido pedido) {
        for (String item : pedido.getItens()) {
            this.baixar(item);
        }
    }
}
