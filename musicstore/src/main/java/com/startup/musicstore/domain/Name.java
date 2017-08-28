/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.domain;

import javax.persistence.Embeddable;

/**
 *
 * @author 212037943
 */
@Embeddable
public class Name {
    private String firstName;
    private String lastName;

    public Name() {
    }
    
    private Name(Builder entity) {
        this.firstName = entity.firstName;
        this.lastName = entity.lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    public static class Builder{
        private String firstName;
        private String lastName;

        public Builder(String firstName) {
            this.firstName = firstName;
        }
        
        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        
        public Builder name(Name nme){
            this.firstName = nme.getFirstName();
            this.lastName = nme.getLastName();
            return this;
        }
        
        public Name build(){
            return new Name(this);
        }
    }
}
