package com.springboot_project2.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name = "Users")
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class User {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private String name;
    private String email;
    private String password;
    private String about;

}
