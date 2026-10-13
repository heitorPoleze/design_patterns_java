package org.example.designPatterns.src.model.patterns.observer;

import org.example.designPatterns.src.model.domain.Pedido;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogAuditoria implements ObservadorPedido {

    @Override
    public void pedidoProcessado(Pedido pedido) {
        registrarAtividade(String.format("pedido de %s processado, total %.2f",
                pedido.getCliente().getNome(), pedido.getTotal()));
    }

    private void registrarAtividade(String mensagem) {
        String agora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        System.out.println("  [AUDITORIA] " + agora + " - " + mensagem);
    }
}
