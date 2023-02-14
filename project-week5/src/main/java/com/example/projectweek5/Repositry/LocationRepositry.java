package com.example.projectweek5.Repositry;

import com.example.projectweek5.Model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepositry extends JpaRepository<Location,Integer> {
    Location findLocationById(Integer storeId);

    Location findAllById(Integer id);
}
