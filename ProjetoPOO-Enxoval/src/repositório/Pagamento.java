package repositório;

import java.util.Date;

public class Pagamento {

    private String formaPagamento;  
    private float valorPago;
    private String statusPagamento;
    private Date dataPagamento;

    // Construtor
    public Pagamento(String formaPagamento, float valorPago) {
        this.formaPagamento = formaPagamento;
        this.valorPago = valorPago;
        this.statusPagamento = "Pendente";
        this.dataPagamento = null; 
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public float getValorPago() {
        return valorPago;
    }

    public void setValorPago(float valorPago) {
        this.valorPago = valorPago;
    }

    public String getStatusPagamento() {
        return statusPagamento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void processarPagamento() {
        if (valorPago > 0) {
            
            this.statusPagamento = "Pago";
            this.dataPagamento = new Date(); 
            System.out.println("Pagamento processado com sucesso.");
        } else {
            this.statusPagamento = "Recusado";
            System.out.println("Pagamento recusado. Valor inválido.");
        }
    }

    public String gerarNotaFiscal() {
        if ("Pago".equals(statusPagamento)) {
            return "----- Recibo de Pagamento -----\n" +
                   "Forma de Pagamento: " + formaPagamento + "\n" +
                   "Valor Pago: R$ " + valorPago + "\n" +
                   "Status: " + statusPagamento + "\n" +
                   "Data: " + dataPagamento + "\n";
        } else {
            return "Pagamento não foi concluído. Recibo não disponível.";
        }
    }


    public String verificarStatus() {
        return this.statusPagamento;
    }

    public void atualizarStatus(String novoStatus) {
        this.statusPagamento = novoStatus;
        System.out.println("Status do pagamento atualizado para: " + novoStatus);
    }

}
