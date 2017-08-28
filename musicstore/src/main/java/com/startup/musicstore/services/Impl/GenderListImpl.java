/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.services.Impl;

import com.startup.musicstore.domain.Customer;
import com.startup.musicstore.respository.CustomerRepository;
import com.startup.musicstore.services.GenderListService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 *
 * @author Kurvin Hendricks
 */
@Service
public class GenderListImpl implements GenderListService {

    @Autowired
    private CustomerRepository cust;
    
    @Override
    public int getGenderList(String albumName, String Gender) {
        int number = 0;
       List<Customer> custList = new ArrayList<>();
            custList = cust.findAll();
            for(int x = 0; x < custList.size(); x++)
                if(custList.get(x).getDemographic().equals(Gender)){
                    if(custList.get(x).getOrders().get(x).getItems().get(x).getAlbums().get(x).getAlbumTitle().equals(albumName)){
                        number++;
                }
        }
            return number;
    }

    @Override
    public Customer find(Long id) {
        return cust.findOne(id);
    }

    @Override
    public Customer persist(Customer entity) {
       return cust.save(entity);
    }

    @Override
    public Customer merge(Customer entity) {
       if (entity.getId() != null) {
            return cust.save(entity);
        }
        return null;
    }

    @Override
    public void remove(Customer entity) {
         cust.delete(entity);
    }

    @Override
    public List<Customer> findAll() {
        return cust.findAll();
    }
    }
