/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.domain;

import java.io.Serializable;
import java.math.BigDecimal;
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
public class Albums implements Serializable{ // had to rename it this to show in the database
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String albumTitle;
    private BigDecimal unitPrice;
    private int inventory;
    private int sales;
    @OneToOne()
    @JoinColumn(name = "category")
    private AlbumCategory category;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "tracks")
    private List<Track> tracks;
    @OneToOne()
    @JoinColumn(name = "marketing")
    private MarketingInformation info;
    
    public Albums() {
    }

    
    
    private Albums(Builder aThis) {
        this.albumTitle = aThis.albumTitle;
        this.id = aThis.id;
        this.inventory = aThis.inventory;
        this.sales = aThis.sales;
        this.unitPrice = aThis.unitPrice;
        this.info = aThis.info;
        this.tracks = aThis.tracks;
        this.category = aThis.category;
    }

    public AlbumCategory getCategory() {
        return category;
    }
    
    public MarketingInformation getInfo() {
        return info;
    }

    public Long getId() {
        return id;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public int getInventory() {
        return inventory;
    }

    public int getSales() {
        return sales;
    }

    public List<Track> getTracks() {
        return tracks;
    }
    
    public static class Builder{
         private Long id;
    
    private String albumTitle;
    private BigDecimal unitPrice;
    private int inventory;
    private int sales;
    private AlbumCategory category;
    private List<Track> tracks;
    private MarketingInformation info;

        public Builder(String albumTitle) {
            this.albumTitle = albumTitle;
        }

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setAlbumTitle(String albumTitle) {
            this.albumTitle = albumTitle;
            return this;
        }

        public Builder setUnitPrice(BigDecimal unitPrice) {
            this.unitPrice = unitPrice;
            return this;
        }

        public Builder setInventory(int inventory) {
            this.inventory = inventory;
            return this;
        }

        public Builder setSales(int sales) {
            this.sales = sales;
            return this;
        }

        public Builder setInfo(MarketingInformation info) {
            this.info = info;
            return this;
        }

        public Builder setTracks(List<Track> tracks) {
            this.tracks = tracks;
            return this;
        }

        public Builder setCategory(AlbumCategory category) {
            this.category = category;
            return this;
        }
        
        
        
        public Albums build(){
            return new Albums(this);
        }
        
        public Builder albums(Albums a){
            this.albumTitle = a.getAlbumTitle();
            this.id = a.getId();
            this.inventory = a.getInventory();
            this.sales = a.getSales();
            this.unitPrice = a.getUnitPrice();
            this.info = a.info;
            this.tracks = a.tracks;
            this.category = a.category;
            return this;
        }
    
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.id);
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
        final Albums other = (Albums) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
