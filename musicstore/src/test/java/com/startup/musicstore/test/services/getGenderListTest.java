/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.test.services;

import com.startup.musicstore.domain.Customer;
import com.startup.musicstore.respository.CustomerRepository;
import com.startup.musicstore.services.GenderListService;
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
 * @author Kurvin Hendricks
 */
public class getGenderListTest {
    
    private static ApplicationContext ctx;
    private Long id; 
    private GenderListService gls;
    private CustomerRepository cust;
    
    public getGenderListTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void hello() {
         cust = ctx.getBean(CustomerRepository.class);
         gls = ctx.getBean(GenderListService.class);
     
         
         Assert.assertEquals(gls.getGenderList("Elephantitas", "female"), 0);
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
