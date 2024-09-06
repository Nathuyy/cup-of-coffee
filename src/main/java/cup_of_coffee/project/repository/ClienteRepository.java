package cup_of_coffee.project.repository;

import cup_of_coffee.project.model.Cliente;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
       UserDetails findByEmail(String email);


}
