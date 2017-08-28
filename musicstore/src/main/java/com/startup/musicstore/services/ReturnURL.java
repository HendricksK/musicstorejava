/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.services;

import com.startup.musicstore.domain.Albums;

/**
 *
 * @author Kurvin Hendricks
 */
public interface ReturnURL extends Services<Albums, Long>{
    public String getURL(String track);
}
