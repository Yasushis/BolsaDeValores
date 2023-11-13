package com.example.bolsadevaloresjavafx.bolsaDeValores;

import main.java.com.example.bolsadevaloresjavafx.estruturadados.DynamicArray;

public class Carteira {

    private DynamicArray<Ativo> ativos;

    public Carteira() {
        this.ativos = new DynamicArray<>(0);
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

    public int countAtivos(Ativo ativo) {
        return ativos.filter(inv -> inv.equals(ativo)).getSize();
    }
}
