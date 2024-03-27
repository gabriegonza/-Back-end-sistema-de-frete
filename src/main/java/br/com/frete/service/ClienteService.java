package br.com.frete.service;

import br.com.frete.doamin.cliente.Cliente;
import br.com.frete.doamin.endereco.Endereco;
import br.com.frete.exception.BadRequestException;
import br.com.frete.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente saveCliente(Cliente cliente){
        validarCliente(cliente);
        verificarCnpj(cliente.getCnpj());
        return clienteRepository.save(cliente);
    }

    public List<Cliente> findAll() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    public Cliente findClienteById(Long id){
       Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElseThrow(()-> new BadRequestException("Cliente nao encontrado!"));
    }

    private void validarCliente(Cliente cliente) {
        if (cliente.getNome() == null || cliente.getCnpj() == null || cliente.getEndereco() == null) {
            throw new BadRequestException("Um cliente não pode ser cadastrado \n" +
                    "sem nome, CNPJ e endereço com localização.");
        }
    }

    private void verificarCnpj(String cnpj) {
        if (clienteRepository.findByCnpj(cnpj) != null) {
            throw new BadRequestException("CNPJ já existente.");
        }
    }

    public void update(@RequestBody Cliente cliente, @RequestBody long id ) {
        Cliente clienteId = clienteRepository.getById(id);

        if (clienteId == null) {
            throw new BadRequestException("Cliente não encontrado com o ID: " + id);
        }
        if (!clienteId.getNome().equals(cliente.getNome())
                || !clienteId.getCnpj().equals(cliente.getCnpj())) {
            throw new BadRequestException("Não é possivel fazer alteração no nome e CNPJ");
        }

        if (cliente.getEndereco() != null) {
            clienteId.getEndereco().setLat(cliente.getEndereco().getLat());
            clienteId.getEndereco().setLonge(cliente.getEndereco().getLonge());
        }
        clienteRepository.save(clienteId);
    }


    public  ResponseEntity<Void> deleteById(long id) {
        if (!clienteRepository.existsById(id)) {
            throw new BadRequestException("Cliente não encontrado!");
        }
        clienteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    public Page<Cliente> listAll(Pageable pageable) {
        Page<Cliente> page = clienteRepository.findAll(pageable);
        return page;
    }

}
