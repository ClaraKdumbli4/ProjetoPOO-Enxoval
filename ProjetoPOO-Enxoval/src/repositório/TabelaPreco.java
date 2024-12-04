package repositório;

import java.util.HashMap;
import java.util.Map;


//Classe Singleton:


public class TabelaPreco {
    private static TabelaPreco instancia; // Instância única da tabela de preços
    private Map<Produto, Double> precos;

    // Construtor privado para evitar instância externa
    private TabelaPreco() {
        this.precos = new HashMap<>();
    }

    // Método estático para obter a instância única da tabela de preços
    public static TabelaPreco getInstancia() {
        if (instancia == null) {
            instancia = new TabelaPreco();
        }
        return instancia;
    }

    // Adicionar ou atualizar o preço de um produto
    public void adicionarPreco(Produto produto, double preco) {
        precos.put(produto, preco);
        System.out.println("Preço do produto '" + produto.getNome() + "' atualizado para: R$ " + preco);
    }

    // Remover um produto da tabela de preços
    public void removerProduto(Produto produto) {
        if (precos.containsKey(produto)) {
            precos.remove(produto);
            System.out.println("Produto '" + produto.getNome() + "' removido da tabela de preços.");
        } else {
            System.out.println("Produto não encontrado na tabela de preços.");
        }
    }

    // Consultar o preço de um produto
    public Double consultarPreco(Produto produto) {
        return precos.get(produto);
    }

    // Exibir todos os produtos e preços da tabela
    public void exibirTabelaPrecos() {
        System.out.println("Tabela de Preços:");
        for (Map.Entry<Produto, Double> entry : precos.entrySet()) {
            Produto produto = entry.getKey();
            Double preco = entry.getValue();
            System.out.println("Produto: " + produto.getNome() + " | Preço: R$ " + preco);
        }
    }
}
