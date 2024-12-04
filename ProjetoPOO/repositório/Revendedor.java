public class Revendedor {
    private String nome;
    private int idRevendedor;
    private String email;
    private String telefone;
    private String cpf;
    private String endereco;

    // Construtor
    public Revendedor(String nome, int idRevendedor, String email, String telefone, String cpf, String endereco) {
        this.nome = nome;
        this.idRevendedor = idRevendedor;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdRevendedor() {
        return idRevendedor;
    }

    public void setIdRevendedor(int idRevendedor) {
        this.idRevendedor = idRevendedor;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    // Método para exibir informações do revendedor
    @Override
    public String toString() {
        return "Revendedor{" +
                "nome='" + nome + '\'' +
                ", idRevendedor=" + idRevendedor +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cpf='" + cpf + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
