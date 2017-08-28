/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.services.Impl;

import com.startup.musicstore.domain.Albums;
import com.startup.musicstore.domain.Review;
import com.startup.musicstore.respository.AlbumsRepository;
import com.startup.musicstore.services.Returnratings;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 212037943
 */
@Service
public class AlbumsServiceImpl implements Returnratings{
    
    @Autowired
    private AlbumsRepository albumRepo;
    
    @Override
    public List<Review> returnRatings(String name) {
        List<Albums> a = albumRepo.findAll();
        List<Review> r = new ArrayList<>();
        for (Albums a1 : a) {
            if (a1.getAlbumTitle().equals(name)) {
                r.add(a1.getInfo().getReview());
            }
        }
            return r;
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

    @Override
    public List<Albums> findAll() {
        return albumRepo.findAll();
    }
    
}
