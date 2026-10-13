package org.example.designPatterns.src.dados;

import org.example.designPatterns.src.model.domain.Pedido;
import org.example.designPatterns.src.model.domain.cliente.Cliente;
import org.example.designPatterns.src.model.domain.cliente.TipoCliente;

public final class DadosExemplo {

    private DadosExemplo() {
    }

    public static Cliente clienteComum() {
        return new Cliente("Ana", "ana@email.com", TipoCliente.COMUM);
    }

    public static Cliente clienteVip() {
        return new Cliente("Ze", "ze@ruela.com", TipoCliente.VIP);
    }

    public static Pedido pedidoTecladoMouse(Cliente cliente) {
        Pedido pedido = Pedido.builder(cliente, 600.0)
                .item("Teclado")
                .item("Mouse")
                .enderecoEntrega("Rua A, 10 - Vitória/ES")
                .build();
        return pedido;
    }

    public static Pedido pedidoMonitor(Cliente cliente) {
        Pedido pedido = Pedido.builder(cliente, 1000.0)
                .item("Monitor")
                .enderecoEntrega("Av. B, 200 - Serra/ES")
                .build();
        return pedido;
    }

    public static Pedido pedidoSemEndereco(Cliente cliente) {
        Pedido pedido = Pedido.builder(cliente, 100.0)
                .item("Cadeira")
                .build();
        return pedido;
    }


    public static Pedido pedidoEbook(Cliente cliente) {
        Pedido pedido = Pedido.builder(cliente, 200.0)
                .item("E-book Design Patterns")
                .build();
        return pedido;
    }

    public static Pedido pedidoCurso(Cliente cliente) {
        Pedido pedido = Pedido.builder(cliente, 200.0)
                .item("Curso online")
                .build();
        return pedido;
    }

    public static Pedido pedidoLicenca(Cliente cliente) {
        Pedido pedido = Pedido.builder(cliente, 50.0)
                .item("Licença de software")
                .build();
        return pedido;
    }
}
