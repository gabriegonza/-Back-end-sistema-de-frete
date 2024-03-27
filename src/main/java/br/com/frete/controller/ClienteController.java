package br.com.frete.controller;

import br.com.frete.doamin.cliente.Cliente;
import br.com.frete.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/frete")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/criar")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Cliente> saveCliente (@RequestBody Cliente cliente) {
        Cliente novoCliente = clienteService.saveCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
    }

    @GetMapping("/all")
    public List<Cliente> listVehicle() {
        return clienteService.findAll();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Cliente> obterClientePorId(@PathVariable long id) {
        Cliente cliente = clienteService.findClienteById(id);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable @Validated long id, @RequestBody Cliente cliente) {
        cliente.setId(id);
        clienteService.update(cliente, id);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Cliente> delete(@PathVariable long id) {
        clienteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/page")
    public ResponseEntity <Page<Cliente>> list(@RequestParam(name = "page", defaultValue = "0") int page,
                                               @RequestParam(name = "size", defaultValue = "10") int size){
        Page<Cliente> list =  clienteService.listAll(PageRequest.of(page, size));
        return ResponseEntity.ok(list);
    }

}
