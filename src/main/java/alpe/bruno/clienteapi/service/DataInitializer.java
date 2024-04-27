package alpe.bruno.clienteapi.service;

import alpe.bruno.clienteapi.domain.model.Cliente;
import alpe.bruno.clienteapi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author brunoabneves
 */
@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void run(String... args) throws Exception {
        Cliente cliente1 = new Cliente();
        cliente1.setId(1L);
        cliente1.setNome("Eren Yeager");
        cliente1.setEmail("eren@email.com");
        cliente1.setEndereco("Distrito de Shiganshina");

        Cliente cliente2 = new Cliente();
        cliente2.setId(2L);
        cliente2.setNome("Finrod Felagund");
        cliente2.setEmail("felagund@email.com");
        cliente2.setEndereco("Beleriand");

        clienteRepository.saveAll(Arrays.asList(cliente1, cliente2));
    }
}
