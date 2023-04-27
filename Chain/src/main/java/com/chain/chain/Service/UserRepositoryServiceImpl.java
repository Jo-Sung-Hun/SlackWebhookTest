package com.chain.chain.Service;

import com.chain.chain.Domain.Entity.User.PersonalCustomer;
import com.chain.chain.Repository.UserCard.UserRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class UserRepositoryServiceImpl implements UserRepositoryService{
    private static final Logger logger = LoggerFactory.getLogger(UserRepositoryServiceImpl.class);
    private final UserRepositoryImpl userRepository;

    @Autowired
    public UserRepositoryServiceImpl(UserRepositoryImpl userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public <S extends PersonalCustomer> S save(S entity) {
        return userRepository.save(entity);
    }

    @Override
    public Optional<PersonalCustomer> findById(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public Optional<PersonalCustomer> findByUsername(String username) {
        return userRepository.findByNickName(username);
    }
}
