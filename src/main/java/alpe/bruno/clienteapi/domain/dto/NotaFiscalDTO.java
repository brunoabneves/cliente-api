package alpe.bruno.clienteapi.domain.dto;

import alpe.bruno.clienteapi.domain.enuns.FormaPagamento;
import alpe.bruno.clienteapi.domain.enuns.StatusNotaFiscal;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author brunoabneves
 */
public record NotaFiscalDTO(
        String numero,
        String cnpjEmissor,
        String nomeEmissor,
        String dataOperacao,
        BigDecimal valorTotal,
        String descricao,
        UUID clienteUuidExterno,
        @Enumerated(EnumType.STRING)
        StatusNotaFiscal status,
        @Enumerated(EnumType.STRING)
        FormaPagamento formaPagamento,
        String observacao,
        ArquivoDTO arquivoDTO
)
{
}
