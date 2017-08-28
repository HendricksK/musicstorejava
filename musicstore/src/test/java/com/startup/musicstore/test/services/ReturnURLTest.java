/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.test.services;

import com.startup.musicstore.domain.AlbumCategory;
import com.startup.musicstore.domain.Albums;
import com.startup.musicstore.domain.SampleClip;
import com.startup.musicstore.domain.Track;
import com.startup.musicstore.respository.AlbumsCatergoryRepository;
import com.startup.musicstore.respository.TrackRepository;
import com.startup.musicstore.services.ReturnURL;
import com.startup.musicstore.test.ConnectionConfigTest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
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
public class ReturnURLTest {
    
    private static ApplicationContext ctx;
    private Long id; 
    private ReturnURL url;
    private TrackRepository tr;
    private AlbumsCatergoryRepository ACrepo;

    public ReturnURLTest() {
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void hello() {
         url = ctx.getBean(ReturnURL.class);
         tr = ctx.getBean(TrackRepository.class);
          ACrepo = ctx.getBean(AlbumsCatergoryRepository.class);
        
        SampleClip sm = new SampleClip.Builder("http://SkylitDrive/CaliBuds.com")
                 .build();
         
        Track track = new Track.Builder("Cali Buds")
                 .setSample(sm)
                 .setTracknumber(1)
                 .build();
        
        tr.save(track);
        
        SampleClip sm2 = new SampleClip.Builder("http://SkylitDrive/500Days.com")
                 .build();
         
        Track track2 = new Track.Builder("500 days of bummer")
                 .setSample(sm)
                 .setTracknumber(4)
                 .build();
        
        tr.save(track2);
        
        List<Track> tracks = new ArrayList<>();
        tracks.add(track);
        tracks.add(track2);
        
         AlbumCategory or2 = new AlbumCategory.Builder("Rock")
                    .build();
                    ACrepo.save(or2);
        
        Albums or = new Albums.Builder("Skylit Drive")
                 .setInventory(78)
                 .setSales(12)
                 .setUnitPrice(new BigDecimal(229))
                 .setTracks(tracks)
                .setCategory(or2)
                 .build();
        
        url.persist(or);
        Assert.assertNotNull(or);
        Assert.assertNotNull(url.getURL("Cali Buds"));
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
