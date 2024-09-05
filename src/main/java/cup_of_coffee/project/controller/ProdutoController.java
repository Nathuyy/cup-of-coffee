package cup_of_coffee.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cup_of_coffee.project.model.Produto;
import cup_of_coffee.project.service.ProdutoService;

import java.util.List;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/novoProduto")
    public ResponseEntity<Produto> cadastrarProduto(@RequestBody Produto produto) {
        System.out.println("Recebendo produto " + produto);
        Produto novoProduto = produtoService.cadastrarProduto(produto); 
        System.out.println("Produto salvo " + novoProduto);
        return ResponseEntity.ok(novoProduto);
    }

    @GetMapping("/produtosInfos")
    public ResponseEntity<List<Produto>> listarProdutos() {
        List<Produto> produtos = produtoService.listarProdutos(); 
        return ResponseEntity.ok(produtos);
    }
}
