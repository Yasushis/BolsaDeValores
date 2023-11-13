package com.example.bolsadevaloresjavafx.bolsaDeValores;

import main.java.com.example.bolsadevaloresjavafx.estruturadados.DynamicArray;

public class Custodiante {

    private String nome;
    private DynamicArray<Carteira> carteiras;

    public Custodiante(String nome) {
        this.nome = nome;
        this.carteiras = carteiras;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public DynamicArray<Carteira> getCarteiras() {
        return carteiras;
    }

    public void setCarteiras(DynamicArray<Carteira> carteiras) {
        this.carteiras = carteiras;
    }
}
