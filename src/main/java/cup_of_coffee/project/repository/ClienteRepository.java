package cup_of_coffee.project.repository;

import cup_of_coffee.project.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
