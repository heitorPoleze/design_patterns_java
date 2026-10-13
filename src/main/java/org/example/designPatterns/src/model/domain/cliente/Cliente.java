package org.example.designPatterns.src.model.domain.cliente;

public class Cliente {
    private final String nome;
    private final String email;
    private final TipoCliente tipo;

    public Cliente(String nome, String email, TipoCliente tipo) {
        this.nome = nome;
        this.email = email;
        this.tipo = tipo;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public TipoCliente getTipo() {
        return this.tipo;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", tipo=" + tipo +
                '}';
    }
}
