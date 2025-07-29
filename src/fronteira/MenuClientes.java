package fronteira;

import java.util.Scanner;

public class MenuClientes {

    private Scanner teclado = new Scanner(System.in);

    public void exibirMenu() {
        int opcao;

        do {
            System.out.println(" 3 mundiais ");
            System.out.println("1. Cadastrar novo cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Buscar cliente por CPF");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Cadastrar cliente");
                    break;
                case 2:
                    System.out.println("Listar clientes");
                    // chamar método de listagem
                    break;
                case 3:
                    System.out.println("Buscar cliente");
                    // chamar método de busca
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
