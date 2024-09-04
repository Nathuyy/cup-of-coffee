package cup_of_coffee.project.model;

import jakarta.persistence.*;

@Entity
public class Itens {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String nomeItem;
    private Integer quantidade;
    private Double precoUnidade;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;
}
