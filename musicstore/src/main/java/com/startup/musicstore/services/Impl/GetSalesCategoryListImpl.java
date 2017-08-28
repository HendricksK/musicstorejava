/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.services.Impl;

import com.startup.musicstore.domain.Albums;
import com.startup.musicstore.domain.OrderItem;
import com.startup.musicstore.respository.AlbumsRepository;
import com.startup.musicstore.respository.OrderItemsRepository;
import com.startup.musicstore.services.GetSalesCategoryList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kurvin Hendricks
 */
@Service
public class GetSalesCategoryListImpl implements GetSalesCategoryList{

    @Autowired
    private AlbumsRepository albumRepo;
    
    String category = null;
    int counter = 0;
    int keeper = 0;
    
    @Override
    public int getList() {
        List<Albums> albums = albumRepo.findAll();
            for(int x = 0; x < albums.size(); x++){
                category = albums.get(x).getCategory().getCategoryName();
                    for(int i = 0; i < albums.size(); i++){
                        if(category.equals(albums.get(i).getCategory().getCategoryName())){
                            counter++;
                            if(counter > keeper){
                                keeper = counter;
                            }
                        }
                    }
            }
            return counter;
    }

    @Override
    public List findAll() {
        return albumRepo.findAll();
    }

    @Override
    public Albums find(Long id) {
         return albumRepo.findOne(id);
    }

    @Override
    public Albums persist(Albums entity) {
        return albumRepo.save(entity);
    }

    @Override
    public Albums merge(Albums entity) {
        if (entity.getId() != null) {
            return albumRepo.save(entity);
        }
        return null;
    }

    @Override
    public void remove(Albums entity) {
        albumRepo.delete(entity);
    }
    
}
