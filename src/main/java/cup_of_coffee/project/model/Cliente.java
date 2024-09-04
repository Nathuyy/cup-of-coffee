package cup_of_coffee.project.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String nomeCliente;
    private String email;
    private String senha;

    @OneToMany(mappedBy = "cliente")
    private Set<Pedido> pedidos;
}
