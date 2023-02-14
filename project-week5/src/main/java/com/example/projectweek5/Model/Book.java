package com.example.projectweek5.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    private  String name;
    @NonNull
    private Integer bookCount;
    @NonNull
    private String genre;
@ManyToOne
@JsonIgnore
@JoinColumn(name = "store_id" ,referencedColumnName  ="id")
     Store store;



}
