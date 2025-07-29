package fronteira;

import java.util.Scanner;

public class MenuReservas {

    private Scanner teclado = new Scanner(System.in);

    public void exibirMenu() {
        int opcao;

        do {
            System.out.println("3 mundiais");
            System.out.println("1. Fazer reserva");
            System.out.println("2. Listar todas as reservas");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opcao: ");
            opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Fazer nova reserva");
                    break;
                case 2:
                    System.out.println("Listar reservas");
                    break;
                case 0:
                    System.out.println("Voltando");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (opcao != 0);
    }
}
