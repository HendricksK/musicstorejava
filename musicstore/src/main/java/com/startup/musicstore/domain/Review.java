/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author 212037943
 */
@Embeddable
public class Review implements Serializable {
    private String description;
    private int rating;

    public Review() {
    }

    private Review(Builder aThis) {
        this.description = aThis.description;
        this.rating = aThis.rating;
    }

    public String getDescription() {
        return description;
    }

    public int getRating() {
        return rating;
    }
    
    
    public static class Builder{
        private String description;
        private int rating;

        public Builder(int rating) {
            this.rating = rating;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setRating(int rating) {
            this.rating = rating;
            return this;
        }
        
        public Review build(){
            return new Review(this);
        }
    }
}
