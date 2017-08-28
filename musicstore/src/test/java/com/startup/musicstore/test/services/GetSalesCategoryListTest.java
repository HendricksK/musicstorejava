/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.test.services;

import com.startup.musicstore.domain.AlbumCategory;
import com.startup.musicstore.domain.Albums;
import com.startup.musicstore.respository.AlbumsCatergoryRepository;
import com.startup.musicstore.respository.AlbumsRepository;
import com.startup.musicstore.respository.OrderItemsRepository;
import com.startup.musicstore.services.GetSalesCategoryList;
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
 * @author Kurvin Hendricks
 */
public class GetSalesCategoryListTest {
    
    
    private static ApplicationContext ctx;
    private Long id; 
    private AlbumsRepository repo;
    private GetSalesCategoryList gsc;
    private AlbumsCatergoryRepository ACrepo;
    
    public GetSalesCategoryListTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void hello() {
         repo = ctx.getBean(AlbumsRepository.class);
         gsc = ctx.getBean(GetSalesCategoryList.class);
         ACrepo = ctx.getBean(AlbumsCatergoryRepository.class);
         
         AlbumCategory or = new AlbumCategory.Builder("Rock")
                 .build();
         ACrepo.save(or);
         
         
          Albums a = new Albums.Builder("DGD")
                 .setInventory(78)
                 .setSales(12)
                 .setUnitPrice(new BigDecimal(209))
                 .setCategory(null)
                 .setCategory(or)
                 .build();
         
         repo.save(a);
         
         int check = gsc.getList();
         
         Assert.assertNotNull(check);
     
     
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
