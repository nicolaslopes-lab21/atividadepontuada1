package com.example.atividadepontuada.service;

import com.example.atividadepontuada.model.ClienteModel;
import com.example.atividadepontuada.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    public List<ClienteModel> listarTodos() {
        return repository.findAll();
    }
    public ClienteModel salvar(ClienteModel cliente) {
        if (repository.findByEmail(cliente.getEmail()).isPresent()) {
            throw new RuntimeException("Cliente já cadastrado.");
        }
        return repository.save(cliente);
    }
    public ClienteModel atualizarCliente(Long id, ClienteModel cliente) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Cliente não encontrado.");
        }
        cliente.setId(id);
        return repository.save(cliente);
    }
    public void excluir(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Funcionário não encontrado.");
        }
        repository.deleteById(id);
    }
}
