package bolsaDeValores;

import estruturadados.DynamicArray;

public class Investidor {
    private String nome;
    private DynamicArray<Ativo> ativos;
    private float dinheiro;

    public Investidor(String nome, float dinheiro) {
        this.nome = nome;
        this.dinheiro = dinheiro;
        this.ativos = new DynamicArray<>(0);
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
        this.ativos = Investidor.this.ativos;
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
            ativos.add(ativo);
        }
    }

    public void vender (Ativo ativo, int quantidade) {
        if (quantidade < 0)
            throw new RuntimeException("Quantidade nao pode ser negativa");

        // vefifica se o investidor consegue vender os ativos
        if (ativos.filter(inv -> inv.equals(ativo)).getSize() < quantidade)
            throw new RuntimeException("erorr");

        // venda do ativo
        dinheiro += (ativo.getValor() * quantidade) * (1 + ativo.getDividendos());
    }
}
