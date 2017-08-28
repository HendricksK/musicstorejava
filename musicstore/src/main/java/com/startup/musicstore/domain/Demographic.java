/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.domain;

import java.util.Date;
import javax.persistence.Embeddable;

/**
 *
 * @author 212037943
 */
@Embeddable
public class Demographic {
    private String gender;
    private String race; 
    private Date dateOfBirth;

    public Demographic() {
    }
    
    
    
    private Demographic(Builder aThis) {
        this.dateOfBirth = aThis.dateOfBirth;
        this.gender = aThis.gender;
        this.race = aThis.race;
    }

    public String getGender() {
        return gender;
    }

    public String getRace() {
        return race;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    
    public static class Builder{
        private String gender;
        private String race; 
        private Date dateOfBirth;

        public Builder(Date dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public Builder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder setRace(String race) {
            this.race = race;
            return this;
        }

        public Builder setDateOfBirth(Date dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }
        
        public Builder demographic(Demographic demo){
            this.dateOfBirth = demo.getDateOfBirth();
            this.gender = demo.getGender();
            this.race = demo.getRace();
            return this;
        }
        
        public Demographic build(){
            return new Demographic(this);
        }
    }
}
