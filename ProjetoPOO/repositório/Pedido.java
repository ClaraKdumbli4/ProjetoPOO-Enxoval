package repositório;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    private int codigoPedido;
    private Revendedor revendedor; // Relação com a classe Revendedor
    private Date data;
    private List<Produto> itens; // Lista de itens do pedido
    private double valorFinal;

    // Construtor
    public Pedido(int codigoPedido, Revendedor revendedor, Date data) {
        this.codigoPedido = codigoPedido;
        this.revendedor = revendedor;
        this.data = data;
        this.itens = new ArrayList<>();
        this.valorFinal = 0.0;
    }

    // Adicionar item ao pedido
    public void adicionarItem(Produto produto, int quantidade) {
        if (produto.getQuantEstoque() >= quantidade) {
            produto.atualizarEstoque(-quantidade); // Atualiza o estoque
            for (int i = 0; i < quantidade; i++) {
                itens.add(produto); // Adiciona o produto à lista de itens
            }
            System.out.println("Item adicionado: " + produto.getNome() + " (Quantidade: " + quantidade + ")");
            calcularValorTotal();
        } else {
            System.out.println("Estoque insuficiente para o produto: " + produto.getNome());
        }
    }

    // Remover item do pedido
    public void removerItem(Produto produto, int quantidade) {
        int contador = 0;
        List<Produto> itensParaRemover = new ArrayList<>();
        for (Produto item : itens) {
            if (item.equals(produto) && contador < quantidade) {
                itensParaRemover.add(item);
                contador++;
            }
        }
        itens.removeAll(itensParaRemover);
        produto.atualizarEstoque(contador); // Repor o estoque removido
        System.out.println("Item removido: " + produto.getNome() + " (Quantidade: " + contador + ")");
        calcularValorTotal();
    }

    // Calcular o valor total do pedido
    public void calcularValorTotal() {
        valorFinal = 0.0;
        for (Produto produto : itens) {
            valorFinal += produto.getPreco();
        }
    }

    // Getters
    public int getCodigoPedido() {
        return codigoPedido;
    }

    public Revendedor getRevendedor() {
        return revendedor;
    }

    public Date getData() {
        return data;
    }

    public List<Produto> getItens() {
        return itens;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    // Exibir informações do pedido
    @Override
    public String toString() {
        StringBuilder detalhes = new StringBuilder();
        detalhes.append("Pedido: ").append(codigoPedido).append("\n");
        detalhes.append("Revendedor: ").append(revendedor.getNome()).append("\n");
        detalhes.append("Data: ").append(data).append("\n");
        detalhes.append("Itens:\n");
        for (Produto produto : itens) {
            detalhes.append(" - ").append(produto.getNome()).append(" | Preço: R$ ").append(produto.getPreco()).append("\n");
        }
        detalhes.append("Valor Total: R$ ").append(valorFinal);
        return detalhes.toString();
    }
}