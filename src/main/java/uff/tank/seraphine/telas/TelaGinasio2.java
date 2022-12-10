package uff.tank.seraphine.telas;

public class TelaGinasio2 extends Tela {

    // Tela do ginásio Valadares (Vitoria)
    @Override
    public void mostrarTela() {
        System.out.println("Opa, " + this.contexto.getTreinador().getNome()
                + "! Você agora se encontra no ginásio de Valadares!\nNossa grande líder de ginásio é a Vitória com seu misterioso Gengar.\nTem certeza que consegue enfrentá-la?\n");
        System.out.println("1 - Claro! Manda ver!");
        System.out.println("2 - Eh... Não tenho certeza, acho que vou voltar.\n");
        System.out.println("X - Sair");

        String escolha = this.contexto.getUserInput();

        switch (escolha) {
            case "1":
                this.trocarTela(new TelaBatalha(this.contexto));
                break;
            case "2":
                this.trocarTela(new TelaEscolherGinasio(this.contexto));
                break;
            case "X":
            case "x":
                this.contexto.sairPrograma();
                break;
            default:
                System.out.println("Por favor, insira um valor válido!");
        }
    }

    public TelaGinasio2(TelaContext context) {
        super(context);
    }
}