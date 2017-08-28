/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.services.Impl;

import com.startup.musicstore.domain.Albums;
import com.startup.musicstore.respository.AlbumsRepository;
import com.startup.musicstore.services.RateAlbumCOR;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kurvin Hendricks
 */
@Service
public class RateAlbumCorImpl implements RateAlbumCOR{
    
    @Autowired
    private AlbumsRepository albumRepo;
    
    @Override
    public char setAlbumRating(int votes) {
        return ' ';
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
