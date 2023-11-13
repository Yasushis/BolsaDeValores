package com.example.bolsadevaloresjavafx.bolsaDeValores;

public class Corretora {
    private String nome;
    private float corretagem;

    public Corretora(String nome, float corretagem) {
        this.nome = nome;
        this.corretagem = corretagem;
    }

    public float getCorretagem() {
        return corretagem;
    }

    public void setCorretagem(float corretagem) {
        this.corretagem = corretagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return getNome();
    }
}
