/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.services.Impl;

import com.startup.musicstore.domain.Contact;
import com.startup.musicstore.domain.Customer;
import com.startup.musicstore.domain.CustomerAddress;
import com.startup.musicstore.respository.CustomerRepository;
import com.startup.musicstore.services.GetCustDetails;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kurvin Hendricks
 */
@Service
public class getCustDetailsImpl implements GetCustDetails{

    @Autowired
    private CustomerRepository custRepo;
    
    
    
    @Override
    public CustomerAddress getCustAddress(String custNumber) {
        List<Customer> custDetials = custRepo.findAll();
       for(int x = 0; x < custDetials.size(); x++){
           if(custDetials.get(x).getCustomerNumber().equals(custNumber)){
               return custDetials.get(x).getCustomerAddress();
           }
       }
       return null;
    }

    @Override
    public Contact getCustContact(String custNumber) {
        List<Customer> custDetials = custRepo.findAll();
        for(int x = 0; x < custDetials.size(); x++){
           if(custDetials.get(x).getCustomerNumber().equals(custNumber)){
               return custDetials.get(x).getContact();
           }
       }
       return null;
    }

    @Override
    public Customer find(Long id) {
        return custRepo.findOne(id);
    }

    @Override
    public Customer persist(Customer entity) {
        return custRepo.save(entity);
    }

    @Override
    public Customer merge(Customer entity) {
         if (entity.getId() != null) {
            return custRepo.save(entity);
        }
        return null;
    }

    @Override
    public void remove(Customer entity) {
        custRepo.delete(entity);
    }

    @Override
    public List<Customer> findAll() {
        return custRepo.findAll();
    }
    
}
