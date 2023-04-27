package com.chain.chain.Repository.UserCard;




import com.chain.chain.Domain.Entity.User.PersonalCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;


@Component(value = "userRepository")
public interface UserRepository extends JpaRepository<PersonalCustomer, UUID> {
    Optional<PersonalCustomer> findByNickName(String nickName);
}
