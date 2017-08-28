/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.services;

import com.startup.musicstore.domain.Albums;
import com.startup.musicstore.domain.Review;
import java.util.List;

/**
 *
 * @author 212037943
 */
public interface Returnratings extends Services<Albums, Long>{
    public List<Review> returnRatings(String name);
}
