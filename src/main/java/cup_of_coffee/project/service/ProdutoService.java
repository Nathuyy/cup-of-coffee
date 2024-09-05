package cup_of_coffee.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cup_of_coffee.project.model.Produto;
import cup_of_coffee.project.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto cadastrarProduto(Produto novoProduto) {
        return produtoRepository.save(novoProduto);
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }
}
