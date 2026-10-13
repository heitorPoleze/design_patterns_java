package org.example.designPatterns.src.model.patterns.templateMethod;

import org.example.designPatterns.src.model.domain.Pedido;
import org.example.designPatterns.src.model.patterns.observer.ObservadorPedido;
import org.example.designPatterns.src.model.patterns.strategy.CalculadoraDesconto;

import java.util.ArrayList;
import java.util.List;

public abstract class ProcessadorPedido {
    protected CalculadoraDesconto calculadoraDesconto;

    private final List<ObservadorPedido> observadores = new ArrayList<>();

    public ProcessadorPedido(CalculadoraDesconto calculadoraDesconto, ObservadorPedido[] observadores) {
        this.calculadoraDesconto = calculadoraDesconto;
        this.observadores.addAll(List.of(observadores));
    }

    public void setCalculadoraDesconto(CalculadoraDesconto calculadoraDesconto) {
        this.calculadoraDesconto = calculadoraDesconto;
    }

    public final void processar(Pedido pedido) {
        System.out.println("[TEMPLATE] 1. validar()");
        this.validar(pedido);

        System.out.println("[TEMPLATE] 2. calcularTotal()");
        pedido.setTotal(this.calcularTotal(pedido));

        System.out.println("[TEMPLATE] 3. notificar()");
        this.notificar(pedido);
    }

    public void addObservadores(ObservadorPedido obs) {
        observadores.add(obs);
    }

    public void remover(ObservadorPedido obs) {
        observadores.remove(obs);
    }

    protected abstract void validar(Pedido pedido);

    protected abstract double calcularTotal(Pedido pedido);

    private void notificar(Pedido pedido) {
        observadores.forEach(obs -> obs.pedidoProcessado(pedido));
    }
}
