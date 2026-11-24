package br.com.padrao.adapter;

public class GatewayPagamentoAdapter implements ProcessadorPagamento {

    private final GatewayPagamentoExterno gateway;

    public GatewayPagamentoAdapter(GatewayPagamentoExterno gateway) {
        if (gateway == null) {
            throw new IllegalArgumentException("Gateway não pode ser nulo");
        }
        this.gateway = gateway;
    }

    @Override
    public boolean pagar(double valorEmReais) {
        long valorEmCentavos = Math.round(valorEmReais * 100);
        int status = gateway.efetuarTransacao(valorEmCentavos);
        return status == GatewayPagamentoExterno.APROVADO;
    }
}
