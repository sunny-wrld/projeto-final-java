package fronteira;

import java.util.Scanner;

public class MenuEspacos {

    private Scanner teclado = new Scanner(System.in);

    public void exibirMenu() {
        int opcao;

        do {
            System.out.println("\n--- MENU ESPAÇOS ---");
            System.out.println("1. Cadastrar espaço");
            System.out.println("2. Listar todos os espaços");
            System.out.println("3. Buscar espaço por ID");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Cadastrar espaço...");
                    break;
                case 2:
                    System.out.println("Listar espaços...");
                    break;
                case 3:
                    System.out.println("Buscar espaço...");
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
