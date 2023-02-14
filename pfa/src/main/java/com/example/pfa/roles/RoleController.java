package com.example.pfa.roles;
import com.example.pfa.posts.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "api/")
public class RoleController {
    private final RoleService roleService;


    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }
    @PostMapping("roles/")
    public Role addRole(@RequestBody Role role){
        roleService.addRole(role);
        return role;
    }
    @GetMapping("roles/")
    public List<Role> getRoles(){
        return roleService.getRoles();
    }
    @GetMapping("roles/{id}")
    public Role getRole(@PathVariable Long id){
        return roleService.getRole(id);
    }
    @DeleteMapping("roles/{id}")
    public void deleteRole(@PathVariable("id") Long id){
       roleService.deleteRole(id);
    }
    @PatchMapping("roles/{id}")
    public void updateRole(@PathVariable("id") Long id , @RequestBody Role role){

        roleService.updateRole(id,role);
    }

}
