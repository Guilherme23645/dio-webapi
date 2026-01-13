package com.depaula.web_api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.depaula.web_api.model.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
