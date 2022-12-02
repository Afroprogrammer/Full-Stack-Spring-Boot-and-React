package com.example.fullstackspringbootandreact.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(exported = false)
public interface UserRepository extends CrudRepository<PrincipalUser, Long> {
    Optional<PrincipalUser> findByUsername(String username);

    @Override
    Iterable<PrincipalUser> findAll();
}

