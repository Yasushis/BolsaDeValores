package com.example.bolsadevaloresjavafx.bolsaDeValores;

import com.example.bolsadevaloresjavafx.estruturadados.DynamicArray;

public class Investidor {
    private String nome;
    private float dinheiro;
    private Carteira carteira;
    public Investidor(String nome, float dinheiro) {
        this.nome = nome;
        this.dinheiro = dinheiro;
        this.carteira = new Carteira();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Carteira getCarteira() {
        return carteira;
    }

    public void setCarteira(Carteira carteira) {
        this.carteira = carteira;
    }

    public float getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(float dinheiro) {
        this.dinheiro = dinheiro;
    }

    public void comprar (Corretora corretora, Ativo ativo, int quantidade) {
        if (quantidade < 0)
            throw new RuntimeException("Quantidade nao pode ser negativa");

        // verfica se o investidor tem dinheiro suficente para comprar algum ativo
        if (dinheiro < (ativo.getValor() * (1 + corretora.getCorretagem())) * quantidade)
            throw new RuntimeException("Nao tem dinheiro suficiente");

        // compra do ativo
        dinheiro -= (ativo.getValor() * (1 + corretora.getCorretagem())) * quantidade;

        for (int i = 0; i < quantidade; i++) {
            carteira.add(ativo);
        }
    }

    public void vender (Ativo ativo, int quantidade) {
        if (quantidade < 0)
            throw new RuntimeException("Quantidade nao pode ser negativa");

        // vefifica se o investidor consegue vender os ativos
        if (carteira.countAtivos(ativo) < quantidade)
            throw new RuntimeException("error");

        // venda do ativo
        dinheiro += (ativo.getValor() * quantidade) * (1 + ativo.getDividendos());
    }
}
