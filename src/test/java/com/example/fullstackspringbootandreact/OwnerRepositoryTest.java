package com.example.fullstackspringbootandreact;

import com.example.fullstackspringbootandreact.domain.Owner;
import com.example.fullstackspringbootandreact.domain.OwnerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class OwnerRepositoryTest {
    @Autowired
    private OwnerRepository repository;

//    @Test
//    void deleteOwners() {
//        repository.save(new Owner("Lisa", "Morrison"));
//        repository.deleteAll();
//        assertThat(repository.count()).isEqualTo(0);

}
