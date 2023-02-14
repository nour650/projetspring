package com.example.pfa.roles;


import com.example.pfa.posts.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    private final RoleRepository roleRepository;
    @Autowired
    public RoleService(RoleRepository roleRepository) {

        this.roleRepository = roleRepository;
    }
    public void addRole(Role role){
        roleRepository.save(role);

    }
    public List<Role> getRoles(){
        return roleRepository.findAll();
    }
    public Role getRole(Long id){
        return roleRepository.findById(id).get();
    }
    public void deleteRole(Long id){
        boolean exist=roleRepository.existsById(id);
        if (exist){
            roleRepository.deleteById(id);
        }
        else {
            throw new IllegalStateException(
                    "post with id" +id+ "does not exist"
            );
        };
    }
    public void updateRole(Long id , Role role){
        boolean exist = roleRepository.existsById(id);
        if (exist){
            roleRepository.save(role);

        }
        else {
            throw new IllegalStateException(
                    "post with id" +id+ "does not exist"
            );
        }
    }

}
