package alpe.bruno.clienteapi.domain.form;

import alpe.bruno.clienteapi.domain.enuns.FormaPagamento;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

/**
 * @author brunoabneves
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Deprecated
public class ArquivosClienteForm {

    @NotNull(message = "Este é um campo obrigatório.")
    private UUID uuidCliente;
    private MultipartFile xmlNotaFiscal;
    private List<MultipartFile> pdfs;
    @Enumerated(EnumType.STRING)
    private FormaPagamento formaPagamento;
}
