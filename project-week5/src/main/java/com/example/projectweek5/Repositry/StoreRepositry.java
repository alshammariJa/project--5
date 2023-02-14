package com.example.projectweek5.Repositry;

import com.example.projectweek5.Model.Store;
import org.hibernate.internal.util.collections.Stack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepositry extends JpaRepository<Store,Integer> {
  Store findStoreById(Integer id);

  Store findAllById(Integer id);
}
