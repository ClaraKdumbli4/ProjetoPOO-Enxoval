package repositório;

public class ItemPedido {
    private Produto produto; // Produto associado ao item
    private double precoUnitario; // Preço unitário do produto no momento do pedido
    private int quantidadeItens; // Quantidade de itens no pedido
    private double subTotal; // Subtotal do item (precoUnitario * quantidadeItens)

    // Construtor
    public ItemPedido(Produto produto, int quantidadeItens) {
        this.produto = produto;
        this.precoUnitario = produto.getPreco(); // Captura o preço do produto no momento do pedido
        this.quantidadeItens = quantidadeItens;
        calcularSubTotal();
    }

    // Método para calcular o subtotal
    public void calcularSubTotal() {
        this.subTotal = this.precoUnitario * this.quantidadeItens;
    }

    // Getters
    public Produto getProduto() {
        return produto;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public int getQuantidadeItens() {
        return quantidadeItens;
    }

    public double getSubTotal() {
        return subTotal;
    }

    // Exibir informações do item
    @Override
    public String toString() {
        return "Produto: " + produto.getNome() +
               " | Preço Unitário: R$ " + precoUnitario +
               " | Quantidade: " + quantidadeItens +
               " | Subtotal: R$ " + subTotal;
    }
}
