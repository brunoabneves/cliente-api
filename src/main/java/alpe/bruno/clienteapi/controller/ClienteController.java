package alpe.bruno.clienteapi.controller;

import alpe.bruno.clienteapi.domain.dto.ClienteDTO;
import alpe.bruno.clienteapi.domain.dto.NotaFiscalDTO;
import alpe.bruno.clienteapi.domain.enuns.FormaPagamento;
import alpe.bruno.clienteapi.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

/**
 * @author brunoabneves
 */
@RestController
@RequestMapping("/clientes")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClienteController {

    private ClienteService service;

    @Operation(summary = "Enviar arquivos", description = "Envia nota fiscal e pdfs para o sistema de notas fiscais.")
    @PostMapping(value = "/enviar-arquivos/{uuidCliente}", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<NotaFiscalDTO> enviarArquivos(@RequestPart("xmlNotaFiscal") MultipartFile xmlNotaFiscal,
                                                        @RequestPart("pdfs") List<MultipartFile> pdfs,
                                                        @PathVariable("uuidCliente") UUID uuidCliente,
                                                        @RequestParam FormaPagamento formaPagamento) {

        return ResponseEntity.ok(service.enviarArquivos(uuidCliente, xmlNotaFiscal, pdfs, formaPagamento));
    }

    @Operation(summary = "Visualizar um cliente.", description = "Busca um cliente pelo seu id.")
    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> visualizar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @Operation(summary = "Lista todos os clientes.", description = "Retorna uma lista paginada com todos os clientes.")
    @GetMapping("/listar-todos")
    public ResponseEntity<Page<ClienteDTO>> listarTodos(
            @ParameterObject @PageableDefault(sort = "id", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable paginacao) {
        return ResponseEntity.ok(service.listar(paginacao));
    }
}
