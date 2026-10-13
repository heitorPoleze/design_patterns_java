package org.example.designPatterns.src.model.domain;
import org.example.designPatterns.src.model.domain.cliente.Cliente;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private final Cliente cliente;
    //numa implementação real, itens e valor seriam substituidos por uma classe Produto, com descrição e valor unitário.
    //Teríamos qtd comprada do produto. Para dinheiro, o correto seria BigDecimal.
    private final double valor;
    private final List<String> itens;
    private final String enderecoEntrega;

    private double desconto;
    private double total;

    // [BUILDER]
    private Pedido(Builder builder) {
        this.cliente = builder.cliente;
        this.valor = verificaValorMaiorQue0(builder.valor);
        this.itens = new ArrayList<>(builder.itens);
        this.enderecoEntrega = builder.enderecoEntrega;
    }

    public static Builder builder(Cliente cliente, double valor) {
        return new Builder(cliente, valor);
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public double getValor() {
        return this.valor;
    }

    public List<String> getItens() {
        return new ArrayList<>(this.itens);
    }

    public String getEnderecoEntrega() {
        return this.enderecoEntrega;
    }

    public double getDesconto() {
        return this.desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    private static double verificaValorMaiorQue0(double valor){
        if(valor > 0) return valor;
        throw new IllegalArgumentException("Valor deve ser maior que 0");
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "cliente=" + cliente.getNome() +
                ", itens=" + itens +
                ", valor=" + String.format("%.2f", valor) +
                ", desconto=" + String.format("%.2f", desconto) +
                ", total=" + String.format("%.2f", total) +
                '}';
    }

    public static class Builder {
        private final Cliente cliente;
        private final double valor;
        private final List<String> itens = new ArrayList<>();
        private String enderecoEntrega;

        private Builder(Cliente cliente, double valor) {
            this.cliente = cliente;
            this.valor = valor;
        }

        public Builder item(String item) {
            this.itens.add(item);
            return this;
        }

        public Builder enderecoEntrega(String enderecoEntrega) {
            this.enderecoEntrega = enderecoEntrega;
            return this;
        }

        public Pedido build() {
            return new Pedido(this);
        }
    }
}
