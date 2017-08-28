/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.test.repository;

import com.startup.musicstore.domain.OrderData;
import com.startup.musicstore.respository.OrderRepository;
import com.startup.musicstore.test.ConnectionConfigTest;
import java.util.Date;
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
public class OrderRepositoryTest {
    
    private static ApplicationContext ctx;
    private Long id; 
    private OrderRepository repo;
    
    public OrderRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test(enabled = true)
     public void create() {
         repo = ctx.getBean(OrderRepository.class);
         OrderData or = new OrderData.Builder(123)
                 .setOrderDate(new Date())
                 .build();
         
         repo.save(or);
         id = or.getId();
         Assert.assertNotNull(id);
     }

     @Test(dependsOnMethods = "create")
     public void read(){
         repo = ctx.getBean(OrderRepository.class);
         OrderData or = repo.findOne(id);
         Assert.assertEquals(or.getQ(), 123);
     }
     
     @Test(dependsOnMethods = "create")
     public void update(){
         repo = ctx.getBean(OrderRepository.class);
         OrderData or = repo.findOne(id);
         
         OrderData update = new OrderData.Builder(789)
                 .orderdata(or)
                 .setOrderDate(new Date())
                 .setQ(456)
                 .build();
         
         repo.save(update);
          OrderData check = repo.findOne(id);
          Assert.assertEquals(check.getQ(), 456);
     }
     
     @Test(dependsOnMethods ="read")
     public void delete(){
         repo = ctx.getBean(OrderRepository.class);
         repo.delete(id);
          OrderData check = repo.findOne(id);
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
