package Controller;

import java.util.Date;
import repositório.Pedido;
import repositório.Produto;

public class VendaController {
    // Instância única da classe Venda
    private static VendaController instanciaUnica;

    // Atributos da classe
    private int codigoVenda;
    private Pedido pedido;
    private Date data;
    private double valorFinal;

    // Construtor privado para evitar criação direta de instâncias
    private VendaController(int codigoVenda, Pedido pedido, Date data) {
        this.codigoVenda = codigoVenda;
        this.pedido = pedido;
        this.data = data;
        this.valorFinal = 0.0; // Valor final será calculado quando a venda for finalizada
    }

    // Método para obter a instância única da classe
    public static VendaController getInstancia(int codigoVenda, Pedido pedido, Date data) {
        if (instanciaUnica == null) {
            // Criação da instância única, se ainda não criada
            synchronized (VendaController.class) {
                if (instanciaUnica == null) {
                    instanciaUnica = new VendaController(codigoVenda, pedido, data);
                }
            }
        }
        return instanciaUnica;
    }

    // Método para finalizar a venda
    public void finalizarVenda() {
        if (pedido != null && !pedido.getItens().isEmpty()) {
            this.valorFinal = pedido.getValorFinal(); // Calcula o valor total com base no pedido
            System.out.println("Venda finalizada com sucesso!");
            System.out.println("Valor final da venda: R$ " + valorFinal);
        } else {
            System.out.println("Não é possível finalizar a venda: o pedido está vazio.");
        }
    }

    // Método para gerar a nota fiscal
    public void gerarNotaFiscal() {
        if (pedido != null && valorFinal > 0) {
            System.out.println("----- NOTA FISCAL -----");
            System.out.println("Código da Venda: " + codigoVenda);
            System.out.println("Data: " + data);
            System.out.println("Revendedor: " + pedido.getRevendedor().getNome());
            System.out.println("Itens do Pedido:");
            for (Produto item : pedido.getItens()) {
                System.out.println(item);
            }
            System.out.println("Valor Total: R$ " + valorFinal);
            System.out.println("-----------------------");
        } else {
            System.out.println("Venda não foi finalizada. Não é possível gerar nota fiscal.");
        }
    }

    // Getters
    public int getCodigoVenda() {
        return codigoVenda;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public Date getData() {
        return data;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    // Exibir informações da venda
    @Override
    public String toString() {
        return "Venda [Código: " + codigoVenda + ", Data: " + data + ", Valor Final: R$ " + valorFinal + "]";
    }
}
