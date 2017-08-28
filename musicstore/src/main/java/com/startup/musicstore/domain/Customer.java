/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author 212037943
 */
@Entity
public class Customer implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String customerNumber;
    @JoinColumn(name = "name")
    private Name name;
    @JoinColumn(name = "contact")
    private Contact contact;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "CreditCard")
    private List<CreditCard> creditCards;
    @JoinColumn(name = "CustomerAddress")
    private CustomerAddress customerAddress;
    @JoinColumn(name = "Demographic")
    private Demographic demographic;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "Orders")
    private List<OrderData> orders;
    
    

    public Customer() {
    }
    
    

    private Customer(Builder entity) {
        this.customerNumber = entity.customerNumber;
        this.contact = entity.contact;
        this.creditCards = entity.creditCards;
        this.customerAddress = entity.customerAddress;
        this.customerNumber = entity.customerNumber;
        this.demographic = entity.demographic;
        this.id = entity.id;
        this.name = entity.name;
        this.orders = entity.orders;
    }

    public List<OrderData> getOrders() {
        return orders;
    }
    
    public Long getId() {
        return id;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public Name getName() {
        return name;
    }

    public Contact getContact() {
        return contact;
    }

    public List<CreditCard> getCreditCards() {
        return creditCards;
    }

    public CustomerAddress getCustomerAddress() {
        return customerAddress;
    }

    public Demographic getDemographic() {
        return demographic;
    }
    
    public static class Builder{
        private Long id;
        private String customerNumber;
        private Name name;
        private Contact contact;
        private List<CreditCard> creditCards;
        private CustomerAddress customerAddress;
        private Demographic demographic;
        private List<OrderData> orders;

       
        

        public Builder(String customerNumber) {
            this.customerNumber = customerNumber;
        }

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setCustomerNumber(String customerNumber) {
            this.customerNumber = customerNumber;
            return this;
        }

        public Builder setName(Name name) {
            this.name = name;
            return this;
        }

        public Builder setContact(Contact contact) {
            this.contact = contact;
            return this;
        }

        public Builder setCreditCards(List<CreditCard> creditCards) {
            this.creditCards = creditCards;
            return this;
        }

        public Builder setCustomerAddress(CustomerAddress customerAddress) {
            this.customerAddress = customerAddress;
            return this;
        }

        public Builder setDemographic(Demographic demographic) {
            this.demographic = demographic;
            return this;
        }

        public Builder setOrders(List<OrderData> orders) {
            this.orders = orders;
            return this;
        }
        

        public Builder Customer(Customer customer){
            this.customerNumber = customer.getCustomerNumber();
            this.id = customer.getId();
            this.contact = customer.getContact();
            this.creditCards = customer.getCreditCards();
            this.customerAddress = customer.getCustomerAddress();
            this.demographic = customer.getDemographic();
            this.name = customer.getName();
            this.orders = customer.getOrders();
            return this;
        }
        
        public Customer build(){
            return new Customer(this);
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.id);
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
        final Customer other = (Customer) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", customerName=" + customerNumber + '}';
    }
}
