/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author 212037943
 */
@Embeddable 
public class SampleClip implements Serializable {
    private String sampleURL;

    public SampleClip() {
    }

    private SampleClip(Builder aThis) {
        this.sampleURL = aThis.sampleURL;
    }
    
    public static class Builder{
        private String sampleURL;

        public Builder(String URL) {
            this.sampleURL = URL;
        }
        
        public SampleClip build(){
            return new SampleClip(this);
        }
    }

    public String getSampleURL() {
        return sampleURL;
    }
    
}
