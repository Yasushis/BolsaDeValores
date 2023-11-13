package com.example.bolsadevaloresjavafx.bolsaDeValores;

import main.java.com.example.bolsadevaloresjavafx.estruturadados.DynamicArray;

public class Bolsa {

    private String nome;
    private DynamicArray<Ativo> ativos;

    public Bolsa(String nome) {
        this.nome = nome;
        this.ativos = new DynamicArray<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public DynamicArray<Ativo> getAtivos() {
        return ativos;
    }

    public void setAtivos(DynamicArray<Ativo> ativos) {
        this.ativos = ativos;
    }

    public void add(Ativo ativo) {
        ativos.add(ativo);
    }
}
