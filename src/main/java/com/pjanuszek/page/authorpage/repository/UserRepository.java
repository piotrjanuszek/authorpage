package com.pjanuszek.page.authorpage.repository;

import com.pjanuszek.page.authorpage.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
//    List<User> findByLastName(String lastName);
    User findById(long id);
    Optional<User> findByEmail(String email);
    User findByUsername(String username);
}
