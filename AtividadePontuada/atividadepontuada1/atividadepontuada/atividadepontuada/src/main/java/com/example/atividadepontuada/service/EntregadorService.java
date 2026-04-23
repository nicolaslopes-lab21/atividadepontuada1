package com.example.atividadepontuada.service;

import com.example.atividadepontuada.model.EntregadorModel;
import com.example.atividadepontuada.repository.EntregadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntregadorService {
    @Autowired
    private EntregadorRepository repository;

    public List<EntregadorModel> listarTodos() {
        return repository.findAll();
    }

    public EntregadorModel salvar(EntregadorModel entregador) {
        if (repository.findByPlaca(entregador.getPlaca()).isPresent()) {
            throw new RuntimeException("Entregador já cadastrado.");
        }
        return repository.save(entregador);
    }

    public EntregadorModel atualizarEntregador(Long id, EntregadorModel entregador) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Entregador não encontrado.");
        }
        entregador.setId(id);
        return repository.save(entregador);
    }

    public void excluir(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Entregador não encontrado.");
        }
        repository.deleteById(id);
    }
}
