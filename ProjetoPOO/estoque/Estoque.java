package estoque;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<Produto> produtos;

    // Construtor
    public Estoque() {
        this.produtos = new ArrayList<>();
    }

    // Adicionar um novo produto ao estoque
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        System.out.println("Produto adicionado: " + produto.getNome());
    }

    // Remover um produto do estoque
    public void removerProduto(int idProduto) {
        Produto produtoRemover = null;
        for (Produto produto : produtos) {
            if (produto.getIdProduto() == idProduto) {
                produtoRemover = produto;
                break;
            }
        }

        if (produtoRemover != null) {
            produtos.remove(produtoRemover);
            System.out.println("Produto removido do estoque: " + produtoRemover.getNome());
        } else {
            System.out.println("Produto com ID " + idProduto + " não encontrado no estoque.");
        }
    }

    // Verificar disponibilidade de um produto
    public boolean verificarDisponibilidade(int idProduto) {
        for (Produto produto : produtos) {
            if (produto.getIdProduto() == idProduto) {
                System.out.println("Produto encontrado: " + produto.getNome() + ". Quantidade em estoque: " + produto.getQuantEstoque());
                return true;
            }
        }
        System.out.println("Produto com ID " + idProduto + " não está disponível no estoque.");
        return false;
    }

    // Atualizar a lista de produtos no estoque
    public void atualizarProduto(int idProduto, int quantidade, boolean adicionar) {
        for (Produto produto : produtos) {
            if (produto.getIdProduto() == idProduto) {
                produto.atualizarEstoque(quantidade);
                return;
            }
        }
        System.out.println("Produto com ID " + idProduto + " não encontrado no estoque para atualização.");
    }

    // Exibir todos os produtos no estoque
    public void exibirProdutos() {
        System.out.println("Produtos no estoque:");
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }
}
