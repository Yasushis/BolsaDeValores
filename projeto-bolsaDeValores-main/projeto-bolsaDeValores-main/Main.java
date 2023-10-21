import bolsaDeValores.Acao;
import bolsaDeValores.Corretora;
import bolsaDeValores.Investidor;

public class Main {
    public static void main(String[] args) {
        Corretora corretora = new Corretora(0.1f);

        Investidor Joel = new Investidor("Joel",  100);

        Acao acao = new Acao("Salgabitos", "S132", 1);

        Joel.comprar(corretora, acao, 1);
        System.out.println(Joel.getDinheiro());

        Joel.vender(acao, 1);
        System.out.println(Joel.getDinheiro());
    }
}
