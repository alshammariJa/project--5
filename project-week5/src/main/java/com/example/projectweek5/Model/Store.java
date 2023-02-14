package com.example.projectweek5.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    private  String name;
  @OneToOne(cascade = CascadeType.ALL,mappedBy = "store")
  @PrimaryKeyJoinColumn
   Location location;
  @OneToMany(cascade =CascadeType.ALL,mappedBy = "store")
  Set<Book> books;

  @ManyToMany
  Set<Customer>customers;



}



