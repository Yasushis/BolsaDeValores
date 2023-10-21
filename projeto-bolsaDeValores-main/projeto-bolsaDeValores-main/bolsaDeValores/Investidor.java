package bolsaDeValores;

import estruturadados.StaticArray;

public class Investidor {
    private String nome;
    private StaticArray<Ativo> ativos;
    private float dinheiro;

    public Investidor(String nome, float dinheiro) {
        this.nome = nome;
        this.dinheiro = dinheiro;
        this.ativos = new StaticArray<>(0);
    }

    private void resizeAtivos(int newCapacity) {
        StaticArray<Ativo> temp = new StaticArray<>(newCapacity);
        ativos.forEach(ativo -> temp.add(ativo));
        ativos = temp;
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

        if (ativos.getSize() + quantidade > ativos.getCapacity())
            this.resizeAtivos(ativos.getCapacity() + quantidade + 10);

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
