package alpe.bruno.clienteapi.client;

import alpe.bruno.clienteapi.domain.dto.NotaFiscalDTO;
import alpe.bruno.clienteapi.domain.enuns.FormaPagamento;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

/**
 * @author brunoabneves
 */
@FeignClient(name = "cliente-client", url = "${feign.client.url.notafiscal}")
public interface NotaFiscalClient {

    @PostMapping(value = "/notas-fiscais/receber-arquivos/{uuidCliente}", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    ResponseEntity<NotaFiscalDTO> receberArquivos(@RequestPart("xmlNotaFiscal") MultipartFile xmlNotaFiscal,
                                                        @RequestPart("pdfs") List<MultipartFile> pdfs,
                                                        @PathVariable("uuidCliente") UUID uuidCliente,
                                                        @RequestParam FormaPagamento formaPagamento);
}
