package fronteira;

import java.util.Scanner;

public class MenuEspacos {

    private Scanner teclado = new Scanner(System.in);

    public void exibirMenu() {
        int opcao;

        do {
            System.out.println("3 mundiais");
            System.out.println("1. Cadastrar espaco");
            System.out.println("2. Listar todos os espacs");
            System.out.println("3. Buscar espaco por ID");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opcao: ");
            opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Cadastrar espaco");
                    break;
                case 2:
                    System.out.println("Listar espacos");
                    break;
                case 3:
                    System.out.println("Buscar espaco");
                    break;
                case 0:
                    System.out.println("Voltando");
                    break;
                default:
                    System.out.println("Opção invalida");
            }
        } while (opcao != 0);
    }
}
