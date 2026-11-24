package br.com.padrao.adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GatewayPagamentoExternoTest {

    private GatewayPagamentoExterno gateway;

    @BeforeEach
    void setUp() {
        gateway = new GatewayPagamentoExterno();
    }

    @Test
    void deveRetornarValorInvalidoQuandoValorForMenorOuIgualAZero() {
        assertEquals(GatewayPagamentoExterno.VALOR_INVALIDO, gateway.efetuarTransacao(0));
    }

    @Test
    void deveRetornarLimiteExcedidoQuandoValorUltrapassarOLimite() {
        assertEquals(GatewayPagamentoExterno.LIMITE_EXCEDIDO,
                gateway.efetuarTransacao(GatewayPagamentoExterno.LIMITE_EM_CENTAVOS + 1));
    }

    @Test
    void deveRetornarAprovadoQuandoValorEstiverDentroDoLimite() {
        assertEquals(GatewayPagamentoExterno.APROVADO, gateway.efetuarTransacao(5_000));
    }
}
