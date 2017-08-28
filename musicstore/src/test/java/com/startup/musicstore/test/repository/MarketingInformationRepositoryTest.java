/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.test.repository;

import com.startup.musicstore.domain.MarketingInformation;
import com.startup.musicstore.domain.Review;
import com.startup.musicstore.respository.MarketingInformationRepository;
import com.startup.musicstore.test.ConnectionConfigTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Kurvin Hendricks
 */
public class MarketingInformationRepositoryTest {
    
    private static ApplicationContext ctx;
    private Long id; 
    private MarketingInformationRepository repo;
    
    public MarketingInformationRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void hello() {
         repo = ctx.getBean(MarketingInformationRepository.class);
         
         Review r = new Review.Builder(5)
                   .setDescription("awesome")
                   .build();
         
         MarketingInformation info = new MarketingInformation.Builder("good")
                 .setReview(r)
                 .build();
         
         repo.save(info);
     }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfigTest.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
