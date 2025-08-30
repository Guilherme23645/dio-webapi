package com.depaula.web_api.service.impl;

import com.depaula.web_api.model.Cliente;
import com.depaula.web_api.model.ClienteRepository;
import com.depaula.web_api.model.Endereco;
import com.depaula.web_api.model.EnderecoRepository;
import com.depaula.web_api.service.ClienteService;
import com.depaula.web_api.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteBanco = clienteRepository.findById(id);
        if (clienteBanco.isPresent()) {
            salvarClienteComCep(cliente);
        }
    }

    @Override
    public void deletar(Long id) {
        Optional<Cliente> clienteBanco = clienteRepository.findById(id);
        if (clienteBanco.isPresent()) {
            clienteRepository.deleteById(id);
        }
    }

    private void salvarClienteComCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }
}
