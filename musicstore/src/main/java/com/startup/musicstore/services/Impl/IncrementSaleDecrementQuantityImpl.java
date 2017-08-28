/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.services.Impl;

import com.startup.musicstore.domain.OrderData;
import com.startup.musicstore.respository.OrderRepository;
import com.startup.musicstore.services.IncrementSalesDecrementQuantity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kurvin Hendricks
 */
@Service
public class IncrementSaleDecrementQuantityImpl implements IncrementSalesDecrementQuantity{

    @Autowired
    private OrderRepository repo;
    
    @Override
    public boolean sales(Long id) {
        OrderData a = repo.findOne(id);
        int s;
        int qBefore = 0;
        int qAfter = 0;
            for(int x =0; x < a.getItems().size(); x++){
                s = a.getItems().get(x).getAlbums().get(x).getSales();
                qBefore = a.getItems().get(x).getAlbums().get(x).getInventory();
                qAfter = (qBefore - s);
            }
        if(qBefore < qAfter){
            return true;
        }else
            return false;
    }
    
    @Override
    public OrderData find(Long id) {
       return repo.findOne(id);
    }

    @Override
    public OrderData persist(OrderData entity) {
       return repo.save(entity);
    }

    @Override
    public OrderData merge(OrderData entity) {
        if (entity.getId() != null) {
            return repo.save(entity);
        }
        return null;
    }

    @Override
    public void remove(OrderData entity) {
         repo.delete(entity);
    }

    @Override
    public List<OrderData> findAll() {
        return repo.findAll();
    }

    
    
}
