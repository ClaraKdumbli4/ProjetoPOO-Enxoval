package Controller;

import repositório.Produto;
import estoque.Estoque;
import java.util.HashMap;
import java.util.Map;

public class EstoqueController {
    // A instância única da classe
    private static EstoqueController instanciaUnica;

    // Mapa de produtos no estoque
    private Map<Integer, Produto> produtos;

    // Construtor privado para evitar a criação de instâncias fora da classe
    private EstoqueController() {
        produtos = new HashMap<>();
    }

    // Método para obter a instância única
    public static EstoqueController getInstancia() {
        if (instanciaUnica == null) {
            // Criação da instância única, se ainda não criada
            synchronized (EstoqueController.class) {
                if (instanciaUnica == null) {
                    instanciaUnica = new EstoqueController();
                }
            }
        }
        return instanciaUnica;
    }

    // Método para adicionar um produto ao estoque
    public void adicionarProduto(Produto produto) {
        produtos.put(produto.getIdProduto(), produto);
        System.out.println("Produto adicionado: " + produto.getNome());
    }

    // Método para remover um produto do estoque
    public void removerProduto(int idProduto) {
        Produto produtoRemovido = produtos.remove(idProduto);
        if (produtoRemovido != null) {
            System.out.println("Produto removido: " + produtoRemovido.getNome());
        } else {
            System.out.println("Produto não encontrado no estoque.");
        }
    }

    // Método para verificar se o produto está disponível no estoque
    public boolean verificarDisponibilidade(int idProduto, int quantidade) {
        Produto produto = produtos.get(idProduto);
        return produto != null && produto.getQuantEstoque() >= quantidade;
    }

    // Método para obter o produto pelo ID
    public Produto getProduto(int idProduto) {
        return produtos.get(idProduto);
    }

    // Exemplo de método para atualizar os produtos
    public void atualizarEstoque(int idProduto, int quantidade) {
        Produto produto = produtos.get(idProduto);
        if (produto != null) {
            produto.atualizarEstoque(quantidade);
        } else {
            System.out.println("Produto não encontrado no estoque.");
        }
    }

    // Exibir lista de produtos no estoque
    public void listarProdutos() {
        System.out.println("Produtos no estoque:");
        for (Produto produto : produtos.values()) {
            System.out.println(produto);
        }
    }
}