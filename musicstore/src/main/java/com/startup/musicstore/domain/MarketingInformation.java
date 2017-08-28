/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author 212037943
 */
@Entity
public class MarketingInformation implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String statusOfInformation;
    private Artist artist;
    private Review review;
    
    public MarketingInformation(){}

    public MarketingInformation(Builder aThis) {
        this.artist = aThis.artist;
        this.id = aThis.id;
        this.review = aThis.review;
        this.statusOfInformation = aThis.statusOfInformation;
    }

    public Long getId() {
        return id;
    }

    public String getStatusOfInformation() {
        return statusOfInformation;
    }

    public Artist getArtist() {
        return artist;
    }

    public Review getReview() {
       return review;
    }

    public static class Builder{
        private Long id;
        private String statusOfInformation;
        private Artist artist;
        private Review review;

        public Builder(String statusOfInformation) {
            this.statusOfInformation = statusOfInformation;
        }

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setArtist(Artist artist) {
            this.artist = artist;
            return this;
        }

       public Builder setReview(Review review) {
            this.review = review;
            return this;
        }
        
        public MarketingInformation build(){
            return new MarketingInformation(this);
        }
        
        public Builder MarketingInformation(MarketingInformation a){
            this.artist = a.getArtist();
            this.id = a.getId();
            this.review = a.getReview();
            this.statusOfInformation = a.getStatusOfInformation();
            return this;
        }
        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final MarketingInformation other = (MarketingInformation) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
