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
public class Contact {
    private String phonenumber;
    private String cellNumber;

    public Contact() {
    }
    
    
    private Contact(Builder entity) {
       this.cellNumber = entity.cellNumber;
       this.phonenumber = entity.phonenumber;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getCellNumber() {
        return cellNumber;
    }
    
    public static class Builder{
         private String phonenumber;
        private String cellNumber;

        public Builder(String phonenumber) {
            this.phonenumber = phonenumber;
        }

        public Builder setPhonenumber(String phonenumber) {
            this.phonenumber = phonenumber;
            return this;
        }

        public Builder setCellNumber(String cellNumber) {
            this.cellNumber = cellNumber;
            return this;
        }
        
        public Builder contact(Contact contact){
            this.cellNumber = contact.getCellNumber();
            this.phonenumber = contact.phonenumber;
            return this;
        }
        
        public Contact build(){
            return new Contact(this);
        }
    }
    
    
}
