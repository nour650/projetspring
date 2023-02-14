package com.example.pfa.users;


import com.example.pfa.roles.Role;
import com.example.pfa.roles.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "api/")
//@CrossOrigin(origins = "*")
public class UserController {
    private final UserService userService;
    private RoleService roleService;
    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService= roleService ;
    }
    @PostMapping("users/roles/{id}")
    public AppUser addUser(@RequestBody AppUser user, @PathVariable Long id){
      Role role= roleService.getRole(id);
      user.setRole(role);
      userService.addUser(user);
        return user;
    }

    @GetMapping("users/")
    public List<AppUser> getUsers(){
        return userService.getUser();
    }
    @GetMapping("users/{id}")
    public AppUser getUser (@PathVariable Long id){
        return userService.getUser(id);
    }
    @DeleteMapping("users/{id}")
    public void deleteUser(@PathVariable("id") Long id){
       userService.deleteUser(id);
    }

    @PostMapping ("users/{id}")
    public AppUser updateUser(@PathVariable("id") Long id , @RequestBody AppUser user){

       return userService.updateUser(id,user);
    }
//    @PostMapping("login/")
//    public AppUser login(@RequestBody AppUser user){
//        AppUser newuser=userService.getUserByEmail(user);
//        return newuser;
//    }

    @PostMapping("login/")
    public AppUser login(@RequestBody Login login){
        AppUser newuser=userService.getUserByLogin(login);
        return newuser;
    }

}

