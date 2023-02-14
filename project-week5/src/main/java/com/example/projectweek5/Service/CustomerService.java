package com.example.projectweek5.Service;

import com.example.projectweek5.Exeption.Api;
import com.example.projectweek5.Model.Customer;
import com.example.projectweek5.Model.Store;
import com.example.projectweek5.Repositry.CustomerRepositry;
import com.example.projectweek5.Repositry.StoreRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepositry customerRepositry;
    private final StoreRepositry storeRepositry;

    public List<Customer> getCustomer() {
        return customerRepositry.findAll();
    }

    public void addCustomer(Customer Customer) {
        customerRepositry.save(Customer);
    }

    public void UpdateCustomer(Integer id, Customer Customer) {
        Customer m = customerRepositry.findCustomerById(id);

        if (m == null) {
            throw new Api("this id is not here");
        }


    }

    public void deletecustomer(Integer id) {
        Customer m = customerRepositry.findCustomerById(id);

        if (m == null) {
            throw new Api("id not here");

        }

        customerRepositry.delete(m);

    }
    public void assign(Integer s_id,Integer c_id){
        Store store= storeRepositry.findStoreById(s_id);
        Customer customer=customerRepositry.findCustomerById(c_id);
        if (store==null||customer==null){
            throw new Api("id not here");
        }
        customer.getStores().add(store);
        store.getCustomers().add(customer);
        customerRepositry.save(customer);
        storeRepositry.save(store);
    }
}
