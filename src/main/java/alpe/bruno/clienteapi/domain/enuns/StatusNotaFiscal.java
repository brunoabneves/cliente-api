package alpe.bruno.clienteapi.domain.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author brunoabneves
 */
@Getter
@AllArgsConstructor
public enum StatusNotaFiscal {

    EMITIDA,
    CANCELADA,
    PENDENTE
}
