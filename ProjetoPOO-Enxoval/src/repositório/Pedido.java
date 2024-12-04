package repositório;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


// SINGLETON:

public class Pedido {
    private static Pedido instancia; // Instância única da classe Pedido
    private int codigoPedido;
    private Revendedor revendedor; // Relação com a classe Revendedor
    private Date data;
    private List<Produto> itens; // Lista de itens do pedido
    private double valorFinal;

    // Construtor privado para evitar instância externa
    private Pedido(int codigoPedido, Revendedor revendedor, Date data) {
        this.codigoPedido = codigoPedido;
        this.revendedor = revendedor;
        this.data = data;
        this.itens = new ArrayList<>();
        this.valorFinal = 0.0;
    }

    // Método estático para obter a instância única de Pedido
    public static Pedido getInstancia(int codigoPedido, Revendedor revendedor, Date data) {
        if (instancia == null) {
            instancia = new Pedido(codigoPedido, revendedor, data);
        }
        return instancia;
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
}
