package alpe.bruno.clienteapi.domain.dto;

import alpe.bruno.clienteapi.domain.enuns.TipoDocumento;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Lob;

/**
 * @author brunoabneves
 */
public record ArquivoDTO(
        String nomeDocumento,
        @Enumerated(EnumType.STRING)
        TipoDocumento tipoDocumento,
        @Lob
        byte[] arquivo) {
}
