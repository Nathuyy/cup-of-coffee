package cup_of_coffee.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cup_of_coffee.project.model.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    
}
