package com.example.atividadepontuada.service;

import com.example.atividadepontuada.model.ProdutoModel;
import com.example.atividadepontuada.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public List<ProdutoModel> listarTodos() {
        return repository.findAll();
    }

    public ProdutoModel salvar(ProdutoModel produto) {
        if (repository.findByLote(produto.getLote()).isPresent()) {
            throw new RuntimeException("Produto já cadastrado.");
        }
        return repository.save(produto);
    }

    public ProdutoModel atualizarProduto(Long id, ProdutoModel produto) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Produto não encontrado.");
        }
        produto.setId(id);
        return repository.save(produto);
    }

    public void excluir(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Produto não encontrado.");
        }
        repository.deleteById(id);
    }
}
