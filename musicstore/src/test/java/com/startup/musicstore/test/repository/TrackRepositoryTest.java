/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.test.repository;

import com.startup.musicstore.domain.SampleClip;
import com.startup.musicstore.domain.Track;
import com.startup.musicstore.respository.TrackRepository;
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
public class TrackRepositoryTest {
    
    private static ApplicationContext ctx;
    private Long id; 
    private TrackRepository tr;
    
    public TrackRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void hello() {
         tr = ctx.getBean(TrackRepository.class);
         
         SampleClip sm = new SampleClip.Builder("http://SkylitDrive/CaliBuds.com")
                 .build();
         
        Track track = new Track.Builder("Cali Buds")
                 .setSample(sm)
                 .setTracknumber(1)
                 .build();
        
        tr.save(track);
        id = track.getId();
        
        Assert.assertNotNull(id);
     }
     
     @Test(dependsOnMethods = "hello")
     public void read(){
         tr = ctx.getBean(TrackRepository.class);
         Track track = tr.findOne(id);
         Assert.assertEquals(track.getTrackTitle(), "Cali Buds");
     }
     
     @Test(dependsOnMethods = "hello")
     public void update(){
         tr = ctx.getBean(TrackRepository.class);
         Track track = tr.findOne(id);
         
         SampleClip sm = new SampleClip.Builder("http://SkylitDrive/YourMistake.com")
                 .build();
         
         Track update = new Track.Builder("Your Mistake")
                 .Track(track)
                 .build();
         
         tr.save(update);
         Track check = tr.findOne(id);
         Assert.assertEquals(check.getTrackTitle(), "Your Mistake");
     }
     
     @Test(dependsOnMethods ="read")
     public void delete(){
         tr = ctx.getBean(TrackRepository.class);
         tr.delete(id);
          Track check = tr.findOne(id);
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
