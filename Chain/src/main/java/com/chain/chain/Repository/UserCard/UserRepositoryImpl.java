package com.chain.chain.Repository.UserCard;


import com.chain.chain.Domain.Entity.User.PersonalCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

@Component
public class UserRepositoryImpl {
    @Autowired
    @Qualifier("userRepository")
    private UserRepository userRepository;

    public void flush() {
        userRepository.flush();
    }


    public <S extends PersonalCustomer> S saveAndFlush(S entity) {
        return null;
    }


    public <S extends PersonalCustomer> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    public void deleteAllInBatch(Iterable<PersonalCustomer> entities) {

    }

    public void deleteAllByIdInBatch(Iterable<UUID> uuids) {

    }

    public void deleteAllInBatch() {

    }

    public PersonalCustomer getOne(UUID uuid) {
        return null;
    }

    public PersonalCustomer getById(UUID uuid) {
        return null;
    }

    public PersonalCustomer getReferenceById(UUID uuid) {
        return null;
    }

    public <S extends PersonalCustomer> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    public <S extends PersonalCustomer> List<S> findAll(Example<S> example) {
        return null;
    }

    public <S extends PersonalCustomer> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    public <S extends PersonalCustomer> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    public <S extends PersonalCustomer> long count(Example<S> example) {
        return 0;
    }

    public <S extends PersonalCustomer> boolean exists(Example<S> example) {
        return false;
    }

    public <S extends PersonalCustomer, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
    @Transactional(readOnly = false)
    public <S extends PersonalCustomer> S save(S entity) {
        return userRepository.save(entity);
    }

    public <S extends PersonalCustomer> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    public Optional<PersonalCustomer> findById(UUID uuid) {
        return userRepository.findById(uuid);
    }

    public boolean existsById(UUID uuid) {
        return false;
    }

    @Transactional(readOnly = true)
    public List<PersonalCustomer> findAll() {
        return userRepository.findAll();
    }

    public List<PersonalCustomer> findAllById(Iterable<UUID> uuids) {
        return null;
    }

    public long count() {
        return 0;
    }

    public void deleteById(UUID uuid) {

    }

    public void delete(PersonalCustomer entity) {

    }

    public void deleteAllById(Iterable<? extends UUID> uuids) {

    }

    public void deleteAll(Iterable<? extends PersonalCustomer> entities) {

    }

    public void deleteAll() {

    }

    public List<PersonalCustomer> findAll(Sort sort) {
        return null;
    }

    public Page<PersonalCustomer> findAll(Pageable pageable) {
        return null;
    }

    public Optional<PersonalCustomer> findByNickName(String nickName) {
        return userRepository.findByNickName(nickName);
    }
}
