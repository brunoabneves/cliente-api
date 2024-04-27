package alpe.bruno.clienteapi.service;

import alpe.bruno.clienteapi.client.NotaFiscalClient;
import alpe.bruno.clienteapi.domain.dto.ClienteDTO;
import alpe.bruno.clienteapi.domain.dto.NotaFiscalDTO;
import alpe.bruno.clienteapi.domain.enuns.FormaPagamento;
import alpe.bruno.clienteapi.domain.model.Cliente;
import alpe.bruno.clienteapi.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

/**
 * @author brunoabneves
 */
@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository repository;
    @Autowired
    private NotaFiscalClient notaFiscalClient;
    @Override
    public NotaFiscalDTO enviarArquivos(UUID uuidCliente, MultipartFile xmlNotaFiscal,
                                        List<MultipartFile> pdfs, FormaPagamento formaPagamento) {

        return notaFiscalClient.receberArquivos(xmlNotaFiscal, pdfs, uuidCliente, formaPagamento).getBody();
    }

    @Override
    public ClienteDTO buscarPorId(Long id) {
        Cliente cliente = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
        return toDTO(cliente);
    }

    @Override
    public Page<ClienteDTO> listar(Pageable paginacao) {
        var pageCliente = repository.findAll(paginacao);
        return pageCliente.map(this::toDTO);
    }

    private ClienteDTO toDTO(Cliente cliente) {
        return ClienteDTO.builder()
                .id(cliente.getId())
                .uuid(cliente.getUuid())
                .nome(cliente.getNome())
                .email(cliente.getEmail())
                .endereco(cliente.getEndereco())
                .build();
    }
}
