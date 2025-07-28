package entidades;

import java.io.Serializable;
import java.time.LocalDate;

public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    private int idCliente;
    private String cpf;
    private String nomeCliente;
    private String email;
    private String telefone;
    private LocalDate dataCadastroCliente;

    // Se for criar um cliente
    public Cliente(String nomeCliente, String cpf, String telefone) {
        this.nomeCliente = nomeCliente;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataCadastroCliente = LocalDate.now(); // Data atual
    }

    // nao sei a onde ta o erro
    public Cliente(int idCliente, String cpf, String nomeCliente, String email, String telefone) {
        this.idCliente = idCliente;
        this.cpf = cpf;
        this.nomeCliente = nomeCliente;
        this.email = email;
        this.telefone = telefone;
        this.dataCadastroCliente = LocalDate.now();
    }

    public int getIdCliente() {

        return idCliente;
    }

    public void setIdCliente(int idCliente) {

        this.idCliente = idCliente;
    }

    public String getCpf() {

        return cpf;
    }

    public void setCpf(String cpf) {

        this.cpf = cpf;
    }

    public String getNomeCliente() {

        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {

        this.nomeCliente = nomeCliente;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getTelefone() {

        return telefone;
    }

    public void setTelefone(String telefone) {

        this.telefone = telefone;
    }

    public LocalDate getDataCadastroCliente() {

        return dataCadastroCliente;
    }

    public void setDataCadastroCliente(LocalDate dataCadastroCliente) {
        this.dataCadastroCliente = dataCadastroCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", cpf='" + cpf + '\'' +
                ", nomeCliente='" + nomeCliente + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", dataCadastroCliente=" + dataCadastroCliente +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cliente cliente = (Cliente) obj;
        return cpf != null ? cpf.equals(cliente.cpf) : cliente.cpf == null;
    }

    @Override
    public int hashCode() {
        return cpf != null ? cpf.hashCode() : 0;
    }
}