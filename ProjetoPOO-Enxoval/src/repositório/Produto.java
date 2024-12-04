package repositório;

public class Produto {
    private String nome;
    private int idProduto;
    private int quantEstoque;
    private float preco;

    // Construtor
    public Produto(String nome, int idProduto, int quantEstoque, double preco) {
        this.nome = nome;
        this.idProduto = idProduto;
        this.quantEstoque = quantEstoque;
        this.preco = (float) preco;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantEstoque() {
        return quantEstoque;
    }

    public void setQuantEstoque(int quantEstoque) {
        this.quantEstoque = quantEstoque;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    // Método para atualizar o estoque
    public void atualizarEstoque(int quantidade) {
        if (quantEstoque + quantidade < 0) {
            System.out.println("Erro: Estoque insuficiente para remover essa quantidade.");
        } else {
            quantEstoque += quantidade;
            System.out.println("Estoque atualizado com sucesso. Estoque atual: " + quantEstoque);
        }
    }

    // Método para exibir informações do produto
    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", idProduto=" + idProduto +
                ", quantEstoque=" + quantEstoque +
                ", preco=" + preco +
                '}';
    }
}