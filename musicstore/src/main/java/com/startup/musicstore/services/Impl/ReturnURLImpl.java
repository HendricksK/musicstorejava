/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.services.Impl;

import com.startup.musicstore.domain.Albums;
import com.startup.musicstore.domain.SampleClip;
import com.startup.musicstore.domain.Track;
import com.startup.musicstore.respository.AlbumsRepository;
import com.startup.musicstore.services.ReturnURL;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kurvin Hendricks
 */
@Service
public class ReturnURLImpl implements ReturnURL{

    @Autowired
    private AlbumsRepository albumRepo;
    
    String URL;
    
    @Override
    public String getURL(String track) {
         List<Albums> a = albumRepo.findAll();
         SampleClip sm = new SampleClip();
        for (Albums a1 : a) {
            List<Track> ts = a1.getTracks();
             for (Track t : ts) {
                 if(t.getTrackTitle().equals(track)){
                     URL = t.getSample().getSampleURL();
                 }
             }
        }
       return URL;
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
