package fronteira;

import java.util.Scanner;

public class MenuRelatorios {

    private Scanner teclado = new Scanner(System.in);

    public void exibirMenu() {
        int opcao;

        do {
            System.out.println("\n--- MENU RELATÓRIOS ---");
            System.out.println("1. Relatório de reservas por cliente");
            System.out.println("2. Relatório de espaços disponíveis");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Gerar relatório por cliente...");
                    break;
                case 2:
                    System.out.println("Gerar relatório de espaços...");
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
}
