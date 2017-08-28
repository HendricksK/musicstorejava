/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author 212037943
 */
@Entity
public class OrderData implements Serializable{// had to rename it this to show in the database
 private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int Q;
    private Date date;
    @JoinColumn(name = "invoices")
    private CustomerInvoice invoice;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "items")
    List<OrderItem> items;

    public OrderData() {
    }
    
    

    private OrderData(Builder aThis) {
        this.Q = aThis.Q;
        this.id = aThis.id;
        this.date = aThis.date;
    }

    public Long getId() {
        return id;
    }

    public int getQ() {
        return Q;
    }

    public Date getDate() {
        return date;
    }

    public CustomerInvoice getInvoice() {
        return invoice;
    }

    public List<OrderItem> getItems() {
        return items;
    }
    
    
    
    public static class Builder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
     private int Q;
     private Date date;
     private CustomerInvoice invoice;
     private List<OrderItem> items;
     
        public Builder(int i) {
            Q = i;
        }

        public Builder setOrderDate(Date date) {
           this.date = date;
           return this;
        }

        public Builder setQ(int Q) {
            this.Q = Q;
            return this;
        }
        
        public OrderData build() {
            return new OrderData(this);
        }

        public Builder setInvoice(CustomerInvoice invoice) {
            this.invoice = invoice;
            return this;
        }

        public Builder setItems(List<OrderItem> items) {
            this.items = items;
            return this;
        }
        
        
        
        public Builder orderdata(OrderData od){
            this.Q = od.getQ();
            this.date = od.getDate();
            this.id = od.getId();
            this.invoice = od.getInvoice();
            return this;
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final OrderData other = (OrderData) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
