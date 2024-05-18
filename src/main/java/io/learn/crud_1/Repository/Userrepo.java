package io.learn.crud_1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.learn.crud_1.Model.User_1;

public interface Userrepo extends JpaRepository<User_1,Integer>{
    
}
