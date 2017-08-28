/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.services;

import com.startup.musicstore.domain.Contact;
import com.startup.musicstore.domain.Customer;
import com.startup.musicstore.domain.CustomerAddress;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kurvin Hendricks
 */
public interface GetCustDetails extends Services<Customer, Long>{
    public CustomerAddress getCustAddress(String custNumber);
    public Contact getCustContact(String custNumber);
}
