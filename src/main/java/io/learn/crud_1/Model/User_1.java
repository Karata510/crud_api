package io.learn.crud_1.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User_1 {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @Column(unique = true)
    private String email;
    private int age;
}
