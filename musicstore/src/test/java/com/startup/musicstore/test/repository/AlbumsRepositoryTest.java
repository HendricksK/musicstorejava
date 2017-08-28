/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.test.repository;

import com.startup.musicstore.domain.Albums;
import com.startup.musicstore.respository.AlbumsRepository;
import com.startup.musicstore.test.ConnectionConfigTest;
import java.math.BigDecimal;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author 212037943
 */
public class AlbumsRepositoryTest {
    
    private static ApplicationContext ctx;
    private Long id; 
    private AlbumsRepository repo;
    
    public AlbumsRepositoryTest() {
    }

     @Test(enabled = true)
     public void create() {
         repo = ctx.getBean(AlbumsRepository.class);
         
         
         Albums or = new Albums.Builder("Elepehantitas")
                 .setInventory(78)
                 .setSales(12)
                 .setUnitPrice(new BigDecimal(209))
                 .build();
         
         repo.save(or);
         id = or.getId();
         Assert.assertNotNull(id);
     }

     @Test(dependsOnMethods = "create")
     public void read(){
         repo = ctx.getBean(AlbumsRepository.class);
         Albums or = repo.findOne(id);
         Assert.assertEquals(or.getAlbumTitle(), "Elepehantitas");
     }
     
     @Test(dependsOnMethods = "create")
     public void update(){
         repo = ctx.getBean(AlbumsRepository.class);
         Albums or = repo.findOne(id);
         
         Albums update = new Albums.Builder("Steal this album")
                 .albums(or)
                 .setAlbumTitle("Hypnotic")
                 .build();
         
         repo.save(update);
          Albums check = repo.findOne(id);
          Assert.assertEquals(check.getAlbumTitle(), "Hypnotic");
     }
     
     @Test(dependsOnMethods ="read")
     public void delete(){
         repo = ctx.getBean(AlbumsRepository.class);
         repo.delete(id);
          Albums check = repo.findOne(id);
          Assert.assertEquals(check, null);
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
