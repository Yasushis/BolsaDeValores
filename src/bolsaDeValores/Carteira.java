package bolsaDeValores;

import estruturadados.DynamicArray;

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
}
