package controle;

import entidades.*;
import excecoes.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class AdministradorSistema {
    private RepositorioClientes repositorioClientes;
    private RepositorioEspacos repositorioEspacos;
    private RepositorioReservas repositorioReservas;

    public AdministradorSistema() {
        this.repositorioClientes = new RepositorioClientes();
        this.repositorioEspacos = new RepositorioEspacos();
        this.repositorioReservas = new RepositorioReservas();

    }
}
