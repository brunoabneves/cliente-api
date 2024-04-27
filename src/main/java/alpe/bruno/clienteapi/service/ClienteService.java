package alpe.bruno.clienteapi.service;

import alpe.bruno.clienteapi.domain.dto.ClienteDTO;
import alpe.bruno.clienteapi.domain.dto.NotaFiscalDTO;
import alpe.bruno.clienteapi.domain.enuns.FormaPagamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

/**
 * @author brunoabneves
 */
public interface ClienteService {

    NotaFiscalDTO enviarArquivos(UUID uuidCliente, MultipartFile xmlNotaFiscal,
                                 List<MultipartFile> pdfs, FormaPagamento formaPagamento);
    ClienteDTO buscarPorId(Long id);

    Page<ClienteDTO> listar(Pageable paginacao);
}
