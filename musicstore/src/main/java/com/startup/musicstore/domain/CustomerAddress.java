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
public class CustomerAddress {
    private String streetAddress;
    private String postalAddress;

    public CustomerAddress() {
    }

    
    
    private CustomerAddress(Builder entity) {
        this.postalAddress = entity.postalAddress;
        this.streetAddress = entity.streetAddress;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getPostalAddress() {
        return postalAddress;
    }
    
    public static class Builder{
        private String streetAddress;
        private String postalAddress;

        public Builder(String streetAddress) {
            this.streetAddress = streetAddress;
        }

        public Builder setStreetAddress(String streetAddress) {
            this.streetAddress = streetAddress;
            return this;
        }

        public Builder setPostalAddress(String postalAddress) {
            this.postalAddress = postalAddress;
            return this;
        }
        
        public Builder customerAddress(CustomerAddress address){
            this.postalAddress = address.getPostalAddress();
            this.streetAddress = address.getStreetAddress();
            return this;
        }
        
        public CustomerAddress build(){
            return new CustomerAddress(this);
        }
    }
}
