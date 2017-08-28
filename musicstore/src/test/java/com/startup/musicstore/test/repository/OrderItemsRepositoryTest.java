/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.test.repository;

import com.startup.musicstore.domain.OrderItem;
import com.startup.musicstore.respository.OrderItemsRepository;
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
public class OrderItemsRepositoryTest {
    
    private static ApplicationContext ctx;
    private Long id; 
    private OrderItemsRepository repo;
    
    public OrderItemsRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test(enabled = true)
     public void create() {
         repo = ctx.getBean(OrderItemsRepository.class);
         OrderItem or = new OrderItem.Builder(123)
                 .setQuantity(12)
                 .build();
                
         repo.save(or);
         id = or.getId();
         Assert.assertNotNull(id);
     }

     @Test(dependsOnMethods = "create")
     public void read(){
         repo = ctx.getBean(OrderItemsRepository.class);
         OrderItem or = repo.findOne(id);
         
         Assert.assertEquals(or.getQuantity(), 12);
     }
     
     @Test(dependsOnMethods = "create")
     public void update(){
         repo = ctx.getBean(OrderItemsRepository.class);
         OrderItem or = repo.findOne(id);
         
         OrderItem update = new OrderItem.Builder(789)
                 .OrderItem(or)
                 .setQuantity(45)
                 .build();
         
         
         repo.save(update);
          OrderItem check = repo.findOne(id);
          Assert.assertEquals(check.getQuantity(), 45);
     }
     
     @Test(dependsOnMethods ="read")
     public void delete(){
         repo = ctx.getBean(OrderItemsRepository.class);
         repo.delete(id);
          OrderItem check = repo.findOne(id);
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
