package bolsaDeValores;

import estruturadados.StaticArray;

public class Bolsa {

    private String nome;
    private StaticArray<Ativo> ativos;

    public Bolsa(String nome) {
        this.nome = nome;
        this.ativos = new StaticArray<>(0);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public StaticArray<Ativo> getAtivos() {
        return ativos;
    }

    public void setAtivos(StaticArray<Ativo> ativos) {
        this.ativos = ativos;
    }
}
