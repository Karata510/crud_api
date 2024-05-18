package io.learn.crud_1.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.learn.crud_1.Model.User_1;
import io.learn.crud_1.Services.UserServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("api")
public class UserController {
  
    private final UserServices services;

    public UserController(UserServices services){
        this.services=services;
    }

    @PostMapping("add_user")
    public ResponseEntity<User_1> postUser(@RequestBody User_1  user) {
        //TODO: process POST request
        User_1 added = services.createUser(user);
        return ResponseEntity.ok(added);
    }
    

    @GetMapping("/users")
    public ResponseEntity<List<User_1>> getUsers(){
        List<User_1> users = services.getUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User_1> getUser(@PathVariable int id){
        User_1 users = services.getUsers(id);
        return ResponseEntity.ok(users);
    }

    @PutMapping("user/{id}")
    public ResponseEntity<User_1> putMethodName(@PathVariable int id, @RequestBody User_1 user) {
        //TODO: process PUT request
        User_1 users = services.updateUser(user, id);
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("delete_all")
    public ResponseEntity<String> deleteUsers(){
        services.deleteUsers();
        return ResponseEntity.ok("all deleted");
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        services.deleteUser(id);
        return ResponseEntity.ok("user deleted");
    }
}
