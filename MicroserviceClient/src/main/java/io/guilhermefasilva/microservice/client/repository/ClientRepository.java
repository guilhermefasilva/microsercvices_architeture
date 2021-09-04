package io.guilhermefasilva.microservice.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.guilhermefasilva.microservice.client.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
