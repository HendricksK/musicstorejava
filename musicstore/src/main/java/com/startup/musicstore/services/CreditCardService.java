/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.services;

import com.startup.musicstore.domain.CreditCard;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author hashcode
 */

public interface CreditCardService extends Services<CreditCard, Long>{
     public String processPayment(String number, BigDecimal amount,Date expiryDate);
    
}
