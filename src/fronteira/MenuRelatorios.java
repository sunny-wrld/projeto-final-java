package fronteira;

import java.util.Scanner;

public class MenuRelatorios {

    private Scanner teclado = new Scanner(System.in);

    public void exibirMenu() {
        int opcao;

        do {
            System.out.println("3 mundiais");
            System.out.println();
            System.out.println("1. Relatorio de reservas por cliente");
            System.out.println("2. Relatorio de espacos disponiveis");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opcao: ");
            opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Gerar relatorio por cliente");
                    break;
                case 2:
                    System.out.println("Gerar relatorio de espaços");
                    break;
                case 0:
                    System.out.println("Voltando");
                    break;
                default:
                    System.out.println("Opcao inválida");
            }
        } while (opcao != 0);
    }
}
