package com.example.projectweek5.Service;

import com.example.projectweek5.Exeption.Api;
import com.example.projectweek5.Model.Customer;
import com.example.projectweek5.Model.Store;
import com.example.projectweek5.Repositry.StoreRepositry;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepositry storeRepositry;
      public List<Store> getStores(){
          return storeRepositry.findAll();
      }

      public void addStore(Store store){
          storeRepositry.save(store);
      }

      public  void updateStore( Integer id, Store store){
         Store store1= storeRepositry.findStoreById(id);
         if ( store1==null ){
             throw new Api("id wrong");
         }
         store1.setName(store.getName());
          storeRepositry.save(store1);
      }
      public void deleteStore(Integer id){
          Store store1= storeRepositry.findStoreById(id);
          if ( store1==null ){
              throw new Api("id wrong");
          }
          storeRepositry.deleteById(id);
      }
    public Store findStore(Integer id){
        Store m=storeRepositry.findAllById(id);
        if (m == null) {
            throw new Api("id not here");

        }
        return m;
    }
    public Set<Customer> getAllCustomersForStore(Integer storeId){
        Store store = storeRepositry.findStoreById(storeId);
        return store.getCustomers();
    }





}
