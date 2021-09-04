package io.guilhermefasilva.microservice.adress.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.guilhermefasilva.microservice.adress.models.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
