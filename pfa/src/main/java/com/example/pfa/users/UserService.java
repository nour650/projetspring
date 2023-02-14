package com.example.pfa.users;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
//    public User saveUser(User user) {
//        String hashPW= passwordEncoder().encode(user.getPassword());
//        user.setPassword("data");
//        userRepository.save(user) ;
//        return user ;
//
//    }

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void addUser( AppUser user) {
        String hashPW= passwordEncoder().encode(user.getPassword());
        user.setPassword(hashPW);
        userRepository.save(user);


    }

    public List<AppUser> getUser(){
        return userRepository.findAll();
    }
    public AppUser getUser(Long id){
        return userRepository.findById(id).get();
    }
    public void deleteUser(Long id){
        boolean exist=userRepository.existsById(id);
        if (exist){
            userRepository.deleteById(id);
        }
        else {
            throw new IllegalStateException(
                    "post with id" +id+ "does not exist"
            );
        }
    }
    public AppUser updateUser(Long id , AppUser user){
        boolean exist = userRepository.existsById(id);
        if (exist){
            //userRepository.save(user);
            AppUser oldUser=userRepository.findById(id).get();
            if(user.getName() != null) {
                oldUser.setName(user.getName());
            }
            if(user.getEmail() != null) {
                oldUser.setEmail(user.getEmail());
            }
            if(user.getAge() != null) {
                oldUser.setAge(user.getAge());
            }
            if(user.getNumber() != null) {
                oldUser.setNumber(user.getNumber());
            }
            return   userRepository.save(oldUser);
        }
        else {
            throw new IllegalStateException(
                    "post with id" +id+ "does not exist"
            );
        }
    }

//    public AppUser getUserByEmail(AppUser user){
//        AppUser newuser=userRepository.findEmail(user.getEmail());
//
//    boolean motdepasse= passwordEncoder().matches(user.getPassword(), newuser.getPassword()  );
//
//   if(motdepasse){
//       return newuser;
//   }
//    else {
//        throw new IllegalStateException("user does not exist");
//    }
//
//
//    }
    public AppUser getUserByLogin (Login login){
        AppUser user=userRepository.findEmail(login.getEmail());
        boolean exist = userRepository.existsById(user.getId());
        if(exist){
            boolean motdepasse= passwordEncoder().matches(login.getPassword(), user.getPassword()  );
        if(motdepasse){
            return user;
        }
        else {
            throw new IllegalStateException("user does not exist");
        }
        }
        else {
            throw new IllegalStateException("user does not exist");
        }


    }
    }

