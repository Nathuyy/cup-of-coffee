package cup_of_coffee.project.controller;

import cup_of_coffee.project.model.Cliente;
import cup_of_coffee.project.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/novoCliente")
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente){
        System.out.println("Recebendo cliente: " + cliente);
        Cliente novoCliente = clienteService.novoCliente(cliente);
        System.out.println("Cliente salvo: " + novoCliente);
        return ResponseEntity.ok(novoCliente);
    }

}
