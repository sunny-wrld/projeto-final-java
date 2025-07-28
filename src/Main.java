package fronteira;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("    SISTEMA DE RESERVAS DE ESPAÇOS");

        exibirMenuPrincipal();

        System.out.println("\nObrigado por usar o Sistema de Reservas!");
        scanner.close();
    }

   private static void exibirMenuPrincipal() {
        int opcao;
        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Gerenciar Clientes");
            System.out.println("2. Gerenciar Espaços");
            System.out.println("3. Gerenciar Serviços");
            System.out.println("4. Gerenciar Reservas");
            System.out.println("5. Relatórios");
            System.out.println("0. Sair do Sistema");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa buffer

            switch (opcao) {
                case 1:
                    new MenuClientes().exibirMenu();
                    break;
                case 2:
                    new MenuEspacos().exibirMenu();
                    break;
                case 3:
                    new MenuServicos().exibirMenu();
                    break;
                case 4:
                    new MenuReservas().exibirMenu();
                    break;
                case 5:
                    new MenuRelatorios().exibirMenu();
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }
}