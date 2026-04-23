package com.example.atividadepontuada.repository;

import com.example.atividadepontuada.model.EntregadorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EntregadorRepository extends JpaRepository<EntregadorModel, Long> {
    Optional<EntregadorModel> findByPlaca(String placa);

}
