/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.test.repository;

import com.startup.musicstore.domain.AlbumCategory;
import com.startup.musicstore.respository.AlbumsCatergoryRepository;
import com.startup.musicstore.respository.AlbumsRepository;
import com.startup.musicstore.test.ConnectionConfigTest;
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
public class AlbumCatergoryRepositoryTest {
    
    private static ApplicationContext ctx;
    
    private Long id; 
    private AlbumsCatergoryRepository repo;
    
    public AlbumCatergoryRepositoryTest() {
    }

    @Test(enabled = true)
     public void create() {
         repo = ctx.getBean(AlbumsCatergoryRepository.class);
         AlbumCategory or = new AlbumCategory.Builder("Rock")
                 .build();
         
         repo.save(or);
         id = or.getId();
         Assert.assertNotNull(id);
     }

     @Test(dependsOnMethods = "create")
     public void read(){
         repo = ctx.getBean(AlbumsCatergoryRepository.class);
         AlbumCategory or = repo.findOne(id);
         Assert.assertEquals(or.getCategoryName(), "Rock");
     }
     
     @Test(dependsOnMethods = "create")
     public void update(){
         repo = ctx.getBean(AlbumsCatergoryRepository.class);
         AlbumCategory or = repo.findOne(id);
         
         AlbumCategory update = new AlbumCategory.Builder("Jazz")
                 .albumcategory(or)
                 .setCategoryName("pop")
                 .build();
         
         repo.save(update);
          AlbumCategory check = repo.findOne(id);
          Assert.assertEquals(check.getCategoryName(), "pop");
     }
     
     @Test(dependsOnMethods ="read")
     public void delete(){
         repo = ctx.getBean(AlbumsCatergoryRepository.class);
         repo.delete(id);
         
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
