/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.test.services;

import com.startup.musicstore.domain.AlbumCategory;
import com.startup.musicstore.domain.Albums;
import com.startup.musicstore.domain.MarketingInformation;
import com.startup.musicstore.domain.Review;
import com.startup.musicstore.respository.AlbumsCatergoryRepository;
import com.startup.musicstore.respository.AlbumsRepository;
import com.startup.musicstore.respository.MarketingInformationRepository;
import com.startup.musicstore.services.Returnratings;
import com.startup.musicstore.test.ConnectionConfigTest;
import java.math.BigDecimal;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author 212037943
 */
public class AlbumsServicesImplTest {
    
    private static ApplicationContext ctx;
    private Long id; 
    private Returnratings ratings;
    //private AlbumsRepository repo;
    private MarketingInformationRepository MIrepo;
    private AlbumsCatergoryRepository ACrepo;
    
    public AlbumsServicesImplTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test(enabled = true)
     public void hello() {
         //repo = ctx.getBean(AlbumsRepository.class);
           ratings = ctx.getBean(Returnratings.class);
           MIrepo = ctx.getBean(MarketingInformationRepository.class);
           ACrepo = ctx.getBean(AlbumsCatergoryRepository.class);
         
           
           Review r = new Review.Builder(5)
                   .setDescription("awesome")
                   .build();
                   
           MarketingInformation info = new MarketingInformation.Builder("good")
                   .setReview(r)
                   .build();
                    MIrepo.save(info);
                    
           AlbumCategory or2 = new AlbumCategory.Builder("Rock")
                    .build();
                    ACrepo.save(or2);
                   
         Albums or = new Albums.Builder("Elephantitas")
                 .setInventory(78)
                 .setSales(12)
                 .setUnitPrice(new BigDecimal(209))
                 .setInfo(info)
                 .setCategory(or2)
                 .build();
         
         ratings.persist(or);
         
         Assert.assertNotNull(r);
         Assert.assertNotNull(info.getId());
         Assert.assertNotNull(ratings.returnRatings("Elephantitas"));
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
