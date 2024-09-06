package cup_of_coffee.project.service;

import cup_of_coffee.project.model.Cliente;
import cup_of_coffee.project.repository.ClienteRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente novoCliente(Cliente novoCliente) {
        return clienteRepository.save(novoCliente);
    }

    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }

     

    
}
