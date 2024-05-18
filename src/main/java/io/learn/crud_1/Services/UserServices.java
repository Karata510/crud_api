package io.learn.crud_1.Services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import io.learn.crud_1.NofFound;
import io.learn.crud_1.Model.User_1;
import io.learn.crud_1.Repository.Userrepo;

@Service
public class UserServices {
    private final Userrepo userrepo;

    public UserServices(Userrepo userrepo) {
        this.userrepo = userrepo;
    }

    public User_1 createUser(User_1 user){
        User_1 added = userrepo.save(user);
        return added;
    }

    public List<User_1> getUsers(){
        List<User_1> users = new ArrayList<>();
        users = userrepo.findAll();
        return users;
    }

    public User_1 getUser(int id){
        User_1 users = userrepo.findById(id).orElseThrow(()-> new NofFound("NO user of this id" +id));
        return users;
    }

    public User_1 updateUser(User_1 user,int id){
        User_1 users = userrepo.findById(id).orElseThrow(()-> new NofFound("NO user of this id" +id));
        users.setAge(user.getAge());
        users.setEmail(user.getEmail());
        users.setName(user.getName());
        return userrepo.save(users);
        
    }

    public void deleteUsers(){
        userrepo.deleteAll();
    }

    public void deleteUser(int id){
        userrepo.deleteById(id);
    }

    public User_1 getUsers(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUsers'");
    }
}
