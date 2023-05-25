package com.academy.ticketservice.repository;

import com.academy.ticketservice.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Boolean existsByPhoneNumber(String phoneNumber);

    Optional<User> getUserByCredential_Email(String email);

    Optional<User> getUserByPhoneNumber(String phoneNumber);

    Boolean existsByCredentialEmail(String credential_email);

    @Query("select (count(u) > 0) from User u " +
            "where u.credential.email = ?1 " +
            "and u.phoneNumber = ?2")
    Boolean existsByEmailAndPhoneNumber(String email, String phoneNumber);

    Optional<User> getUserByFirstNameAndSurname(String firstName, String lastName);


}
