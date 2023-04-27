package com.chain.chain.Service;

import com.chain.chain.Domain.Entity.User.PersonalCustomer;

import java.util.Optional;
import java.util.UUID;

public interface UserRepositoryService {
    <S extends PersonalCustomer> S save(S entity);
    Optional<PersonalCustomer> findById(UUID uuid);
    Optional<PersonalCustomer> findByUsername(String username);
}
