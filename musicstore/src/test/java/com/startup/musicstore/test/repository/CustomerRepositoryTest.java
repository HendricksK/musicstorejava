/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.test.repository;

import com.startup.musicstore.domain.Contact;
import com.startup.musicstore.domain.CreditCard;
import com.startup.musicstore.domain.Customer;
import com.startup.musicstore.domain.CustomerAddress;
import com.startup.musicstore.domain.Demographic;
import com.startup.musicstore.domain.Name;
import com.startup.musicstore.domain.OrderData;
import com.startup.musicstore.respository.CustomerRepository;
import com.startup.musicstore.test.ConnectionConfigTest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
public class CustomerRepositoryTest {
    
    private static ApplicationContext ctx;
    private Long id; 
    private CustomerRepository repo;
    
    public CustomerRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test(enabled = true)
     public void create() {
         repo = ctx.getBean(CustomerRepository.class);
         
         List<CreditCard> cards = new ArrayList<>();
         List<OrderData> orders = new ArrayList<>();
         
         
         CreditCard cc = new CreditCard.Builder("789-456-789")
                 .balance(new BigDecimal(8900.65))
                 .expiryDate(new Date())
                 .nameOnCreditCard("J Valentine").build();
         
         
         Contact contact = new Contact.Builder("0217894561")
                 .setCellNumber("0735141397").build();
         
         Name nme = new Name.Builder("Janice").setLastName("Valentine").build();
         
         
         
         CustomerAddress address = new CustomerAddress.Builder("28 Manhattan Road").setPostalAddress("28 Manhattan Road")
                 .build();
         
         Demographic dg = new Demographic.Builder(new Date()).setGender("female").setRace("coloured").build();
         
         Customer cust = new Customer.Builder("123456879")
                 .setContact(contact)
                 .setCreditCards(cards)
                 .setCustomerAddress(address)
                 .setName(nme)
                 .setDemographic(dg)
                 .setOrders(orders)
                 .build();
         
         repo.save(cust);
         id = cust.getId();
         
         Assert.assertNotNull(id);
     }
     
     @Test(dependsOnMethods = "create")
     public void read(){
          repo = ctx.getBean(CustomerRepository.class);
          Customer cust = repo.findOne(id);
          Assert.assertEquals(cust.getName().getFirstName(), "Janice");
          
     }
     
     @Test(dependsOnMethods = "create", enabled = true)
     public void update(){
          repo = ctx.getBean(CustomerRepository.class);
          Customer cust = repo.findOne(id);
          Name nme = new Name.Builder("Ashley").setLastName("Berathian").build();
          
          Customer update = new Customer.Builder("789456123")
                  .Customer(cust)
                  .setName(nme)
                  .build();
          
          repo.save(update);
          Customer check = repo.findOne(id);
          Assert.assertEquals(check.getName().getFirstName(), "Ashley");
     }
     
     @Test(dependsOnMethods = "read", enabled = true)
     public void delete(){
         repo = ctx.getBean(CustomerRepository.class);
         repo.delete(id);
         
         Customer cust = repo.findOne(id);
         
         Assert.assertNull(cust);
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
