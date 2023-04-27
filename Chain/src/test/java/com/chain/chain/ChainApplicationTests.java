package com.chain.chain;

import com.chain.chain.Domain.DTO.User.PersonalCustomerDTO;
import com.chain.chain.Domain.Entity.User.PersonalCustomer;
import com.chain.chain.Repository.UserCard.UserRepository;
import com.chain.chain.Repository.UserCard.UserRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
class ChainApplicationTests {

    @Autowired
    private UserRepositoryImpl userRepository;

    @Test
    void contextLoads() {
        UUID seletUUID = UUID.randomUUID();
                                                                                                //
        PersonalCustomerDTO personalCustomerDTO = PersonalCustomerDTO.builder()
                .birth("20220521")
                .email("kimdole29@iclodu.com")
                .name("이서율")
                .nickName("kimdole29")
                .password("kimdole29##2829")
                .phoneNumber("010-7568-2928")
                .build();
        PersonalCustomer s = personalCustomerDTO.toEntity();
        s.setId(seletUUID);
        userRepository.save(s);
         Optional<PersonalCustomer> res = userRepository.findById(seletUUID);
         res.ifPresent(a -> {
             System.out.println(a.getId());
         });
    }
}
