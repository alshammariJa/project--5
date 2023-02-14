package com.example.projectweek5.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    private  String name;
    @NonNull
    private String phoneNumber;
    @Email
    @NonNull
    private String email;
  @ManyToMany
  @JsonIgnore
  Set<Store> stores;
}
