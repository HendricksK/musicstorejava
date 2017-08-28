/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author 212037943
 */
@Entity
public class OrderItem implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int quantity;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "tracks")
    private List<Albums> albums;

    public OrderItem() {
    }

    private OrderItem(Builder aThis){
        this.id = aThis.id;
        this.quantity = aThis.quantity;
        this.albums = aThis.albums;
    }

    public Long getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public List<Albums> getAlbums() {
        return albums;
    }
    
    public static class Builder{
        private Long id;
        private int quantity;
        private List<Albums> albums;

        public Builder(int quantity) {
            this.quantity = quantity;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public void setAlbums(List<Albums> albums) {
            this.albums = albums;
        }
        
        public OrderItem build(){
            return new OrderItem(this);
        }
        
        public Builder OrderItem(OrderItem item){
            this.id = item.getId();
            this.quantity = item.getQuantity();
            this.albums = item.albums;
            return this;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final OrderItem other = (OrderItem) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
