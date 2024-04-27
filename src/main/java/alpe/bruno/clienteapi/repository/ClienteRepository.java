package alpe.bruno.clienteapi.repository;

import alpe.bruno.clienteapi.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author brunoabneves
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
