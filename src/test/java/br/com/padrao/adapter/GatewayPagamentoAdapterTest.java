package br.com.padrao.adapter;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class GatewayPagamentoAdapterTest {

    @Test
    void deveLancarExcecaoQuandoGatewayForNulo() {
        assertThrows(IllegalArgumentException.class, () -> new GatewayPagamentoAdapter(null));
    }

    @Test
    void deveCriarAdapterQuandoGatewayForValido() {
        assertNotNull(new GatewayPagamentoAdapter(new GatewayPagamentoExterno()));
    }

    @Test
    void deveRetornarVerdadeiroQuandoPagamentoForAprovado() {
        ProcessadorPagamento processador = new GatewayPagamentoAdapter(new GatewayPagamentoExterno());
        assertTrue(processador.pagar(50.00));
    }

    @Test
    void deveRetornarFalsoQuandoPagamentoForRecusado() {
        ProcessadorPagamento processador = new GatewayPagamentoAdapter(new GatewayPagamentoExterno());
        assertFalse(processador.pagar(0.0));
    }
}
