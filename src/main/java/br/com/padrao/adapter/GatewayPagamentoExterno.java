package br.com.padrao.adapter;

public class GatewayPagamentoExterno {

    public static final int APROVADO = 200;
    public static final int VALOR_INVALIDO = 400;
    public static final int LIMITE_EXCEDIDO = 402;
    public static final long LIMITE_EM_CENTAVOS = 1_000_000L;

    public int efetuarTransacao(long valorEmCentavos) {
        if (valorEmCentavos <= 0) {
            return VALOR_INVALIDO;
        }
        if (valorEmCentavos > LIMITE_EM_CENTAVOS) {
            return LIMITE_EXCEDIDO;
        }
        return APROVADO;
    }
}
