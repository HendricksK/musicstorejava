/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.respository;

import com.startup.musicstore.domain.MarketingInformation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author 212037943
 */
public interface MarketingInformationRepository extends JpaRepository<MarketingInformation, Long>{
    
}
