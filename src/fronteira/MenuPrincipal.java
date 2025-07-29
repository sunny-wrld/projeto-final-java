package fronteira;

import java.util.Scanner;

public class MenuPrincipal {

    private Scanner teclado = new Scanner(System.in);

    private MenuClientes menuClientes = new MenuClientes();
    private MenuEspacos menuEspacos = new MenuEspacos();
    private MenuReservas menuReservas = new MenuReservas();
    private MenuRelatorios menuRelatorios = new MenuRelatorios();

    public void iniciar() {
        int opcao;

        do {
            System.out.println("3 mundiais");
            System.out.println("1. Clientes");
            System.out.println("2. Espacos");
            System.out.println("3. Reservas");
            System.out.println("4. Relatorios");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = teclado.nextInt();
            teclado.nextLine(); // limpar o buffer

            switch (opcao) {
                case 1:
                    menuClientes.exibirMenu();
                    break;
                case 2:
                    menuEspacos.exibirMenu();
                    break;
                case 3:
                    menuReservas.exibirMenu();
                    break;
                case 4:
                    menuRelatorios.exibirMenu();
                    break;
                case 0:
                    System.out.println("Encerrando o sistema. Até o proximo mundial do SP");
                    break;
                default:
                    System.out.println("Opção invalida. Tente novamente");
            }

        } while (opcao != 0);
    }
}
