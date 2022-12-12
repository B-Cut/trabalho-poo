package uff.tank.seraphine.telas;

import java.util.Random;

import org.json.simple.JSONObject;

import uff.tank.seraphine.Batalha;
import uff.tank.seraphine.CadastroTreinador;
import uff.tank.seraphine.LiderGin;
import uff.tank.seraphine.Pokemon;
import uff.tank.seraphine.Treinador;
import uff.tank.seraphine.utils.ConsoleUtils;
import uff.tank.seraphine.utils.JSONUtils;

//Tela exibida durante a batalha
public class TelaBatalha extends Tela {
    LiderGin oponente;
    Batalha batalha;

    @Override
    public void mostrarTela() {
        Treinador treinador = this.contexto.getTreinador();

        // TODO: Sistema de batalha

        Random random = new Random();
        String randomLider = Integer.toString(random.nextInt(2) + 1);

        if (batalha.getEmExecucao()) {
            System.out.println("---------- Batalha ----------");
            System.out.println("Seu pokemon: " + batalha.getPkmAmigo().getNome());
            System.out.println(
                    "Seu HP atual: " + batalha.getPkmAmigo().getHpAtual());
            System.out.println("Seu ataque: " + batalha.getPkmAmigo().getAtaque());
            System.out.println("Sua defesa: " + batalha.getPkmAmigo().getDefesa());
            System.out.println("-----------------------------");
            System.out.println("Pokemon inimigo: " + batalha.getPkmInimigo().getNome());
            System.out.println("HP atual do inimigo: " + batalha.getPkmInimigo().getHpAtual());
            System.out.println("Ataque do inimigo: " + batalha.getPkmInimigo().getAtaque());
            System.out.println("Defesa do inimigo: " + batalha.getPkmInimigo().getDefesa());
            System.out.println("-----------------------------\n");
            System.out.println("Escolha seu ataque");
            System.out.println("(1) - Físico");
            System.out.println("(2) - Especial (Restantes: " + batalha.getContEspecial() + ")");
            System.out.println("\nX - Sair");

            String escolha = this.contexto.getUserInput();

            switch (escolha) {
                case "1":
                    System.out.println("Usuario aplicou um ataque físico.");
                    batalha.atacar(batalha.getPkmAmigo(), batalha.getPkmInimigo(),
                            batalha.getPkmAmigo().getMovimento(0));
                    ConsoleUtils.sleep(1500);
                    break;
                case "2":
                    if (batalha.getContEspecial() > 0) {
                        System.out.println("Usuario aplicou um ataque especial.");
                        batalha.atacar(batalha.getPkmAmigo(), batalha.getPkmInimigo(),
                                batalha.getPkmAmigo().getMovimento(1));
                        ConsoleUtils.sleep(1500);
                        batalha.decrementarContEspecial();
                        ;
                    } else {
                        System.out.println("Não possui mais ataques especiais. Foi aplicado um ataque físico.");
                        batalha.atacar(batalha.getPkmAmigo(), batalha.getPkmInimigo(),
                                batalha.getPkmAmigo().getMovimento(0));
                        ConsoleUtils.sleep(1500);

                    }
                    break;
                case "x":
                case "X":
                    this.contexto.sairPrograma();
                    break;
                default:
                    System.out.println("Por favor insira um valor válido");
                    break;
            }
            System.out.println("HP atual do inimigo: " + batalha.getPkmInimigo().getHpAtual());
            System.out.println("\n-----------------------------\n");
            ConsoleUtils.sleep(5000);

            if (batalha.getPkmInimigo().getHpAtual() > 0) {
                switch (randomLider) {
                    case "1":
                        System.out.println("Líder " + oponente.getNome() + " aplicou um ataque físico.");
                        batalha.atacar(batalha.getPkmInimigo(), batalha.getPkmAmigo(),
                                batalha.getPkmAmigo().getMovimento(0));
                        ConsoleUtils.sleep(1500);
                        break;
                    case "2":
                        if (batalha.getContEspecialLider() > 0) {
                            System.out.println("Líder " + oponente.getNome() + " aplicou um ataque especial.");
                            batalha.atacar(batalha.getPkmInimigo(), batalha.getPkmAmigo(),
                                    batalha.getPkmAmigo().getMovimento(1));
                            ConsoleUtils.sleep(1500);
                            batalha.decrementarContEspecialLider();
                        } else {
                            System.out.println("Líder " + oponente.getNome() + " aplicou um ataque físico.");
                            batalha.atacar(batalha.getPkmInimigo(), batalha.getPkmAmigo(),
                                    batalha.getPkmAmigo().getMovimento(0));
                            ConsoleUtils.sleep(1500);
                            break;
                        }
                        break;
                }
                System.out.println(
                        "\nSeu HP atual: " + batalha.getPkmAmigo().getHpAtual());
                System.out.println("-----------------------------\n");
                ConsoleUtils.sleep(5000);
            } else {
                System.out.println("Inimigo derrotado!");
                ConsoleUtils.sleep(1000);
            }
        } else {
            if (batalha.getVitoria()) {
                this.trocarTela(new TelaVitoria(this.contexto));
            } else {
                this.trocarTela(new TelaDerrota(this.contexto));
            }
        }
    }

    public TelaBatalha(TelaContext context, LiderGin oponente, Batalha batalha) {
        super(context);
        this.oponente = oponente;
        this.batalha = batalha;
    }
}
