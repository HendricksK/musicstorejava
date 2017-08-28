/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

/**
 *
 * @author 212037943
 */
@Entity
public class Track implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int tracknumber;
    private String trackTitle;
    @JoinColumn(name = "URL")
    private SampleClip sample;

    public Track() {
    }

    private Track(Builder aThis) {
        this.id = aThis.id;
        this.sample = aThis.sample;
        this.trackTitle = aThis.trackTitle;
        this.tracknumber = aThis.tracknumber;
    }
    
    public static class Builder{
        private Long id;
        private int tracknumber;
        private String trackTitle;
        private SampleClip sample;

        public Builder(String trackTitle) {
            this.trackTitle = trackTitle;
        }
        
        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setTracknumber(int tracknumber) {
            this.tracknumber = tracknumber;
            return this;
        }

        public Builder setTrackTitle(String trackTitle) {
            this.trackTitle = trackTitle;
            return this;
        }

        public Builder setSample(SampleClip sample) {
            this.sample = sample;
            return this;
        }
        
        public Track build(){
            return new Track(this);
        }
        
        public Builder Track(Track ac){
            this.id = ac.id;
            this.sample = ac.sample;
            this.tracknumber = ac.tracknumber;
            return this;
        }
        
    }

    public Long getId() {
        return id;
    }

    public int getTracknumber() {
        return tracknumber;
    }

    public String getTrackTitle() {
        return trackTitle;
    }

    public SampleClip getSample() {
        return sample;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Track other = (Track) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
