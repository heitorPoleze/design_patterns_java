package org.example.designPatterns.src;

import org.example.designPatterns.src.dados.DadosExemplo;
import org.example.designPatterns.src.model.domain.Pedido;
import org.example.designPatterns.src.model.domain.cliente.Cliente;
import org.example.designPatterns.src.model.patterns.factory.CalculadoraDescontoFactory;
import org.example.designPatterns.src.model.patterns.observer.LogAuditoria;
import org.example.designPatterns.src.model.patterns.observer.NotificacaoEmail;
import org.example.designPatterns.src.model.patterns.observer.ObservadorPedido;
import org.example.designPatterns.src.model.patterns.observer.singleton.Estoque;
import org.example.designPatterns.src.model.patterns.templateMethod.ProcessadorPedido;
import org.example.designPatterns.src.model.patterns.templateMethod.ProcessadorPedidoDigital;
import org.example.designPatterns.src.model.patterns.templateMethod.ProcessadorPedidoFisico;

public class Main {
    private static final ObservadorPedido EMAIL = new NotificacaoEmail();
    private static final ObservadorPedido ESTOQUE = Estoque.INSTANCIA;
    private static final ObservadorPedido AUDITORIA = new LogAuditoria();

    public static void main(String[] args) {
        Cliente comum = DadosExemplo.clienteComum();
        Cliente vip = DadosExemplo.clienteVip();

        executar("1) Físico | Comum", processadorFisico(comum), DadosExemplo.pedidoTecladoMouse(comum));
        executar("2) Físico | VIP", processadorFisico(vip), DadosExemplo.pedidoMonitor(vip));
        executar("3) Digital | Comum", processadorDigital(comum), DadosExemplo.pedidoCurso(comum));
        executar("4) Digital | VIP", processadorDigital(vip), DadosExemplo.pedidoEbook(vip));
        executar("5) Inválido | Físico sem endereço", processadorFisico(comum), DadosExemplo.pedidoSemEndereco(comum));
    }

    private static ProcessadorPedido processadorFisico(Cliente cliente) {
        return new ProcessadorPedidoFisico(
                CalculadoraDescontoFactory.fabricarCalculadora(cliente.getTipo()),
                new ObservadorPedido[]{EMAIL, ESTOQUE, AUDITORIA}
        );
    }

    private static ProcessadorPedido processadorDigital(Cliente cliente) {
        return new ProcessadorPedidoDigital(
                CalculadoraDescontoFactory.fabricarCalculadora(cliente.getTipo()),
                new ObservadorPedido[]{EMAIL, AUDITORIA}
        );
    }

    private static void executar(String titulo, ProcessadorPedido processador, Pedido pedido) {
        System.out.println();
        System.out.println("=== " + titulo + " ===");
        try {
            processador.processar(pedido);
        } catch (IllegalArgumentException e) {
            System.out.println("  [ERRO] " + e.getMessage());
        }
    }
}
