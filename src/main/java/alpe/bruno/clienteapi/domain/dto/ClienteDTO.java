package alpe.bruno.clienteapi.domain.dto;

import lombok.Builder;

import java.util.UUID;

/**
 * @author brunoabneves
 */
@Builder
public record ClienteDTO(
        Long id,
        UUID uuid,
        String nome,
        String cpfCnpj,
        String endereco,
        String email
) {
}
