/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.services;

import com.startup.musicstore.domain.Customer;

/**
 *
 * @author Kurvin Hendricks
 */
public interface GenderListService extends Services<Customer, Long>{
    public int getGenderList(String albumName, String Gender);
}
