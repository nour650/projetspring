package com.example.pfa.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<AppUser, Long> {


    @Query(" select  user from users user where  user.email = :email ")
    AppUser findEmail(String email);



}
