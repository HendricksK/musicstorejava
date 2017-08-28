/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author 212037943
 */
@Entity
public class AlbumCategory implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String categoryName;

    public AlbumCategory() {
    }
    
    private AlbumCategory(Builder aThis) {
        this.categoryName = aThis.categoryName;
        this.id = aThis.id;
    }

    public Long getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public static class Builder{
        private Long id;
        private String categoryName;

        public Builder(String categoryName) {
            this.categoryName = categoryName;
        }

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setCategoryName(String categoryName) {
            this.categoryName = categoryName;
            return this;
        }
        
        public AlbumCategory build(){
            return new AlbumCategory(this);
        }
        
        public Builder albumcategory(AlbumCategory ac){
            this.categoryName = ac.categoryName;
            this.id = ac.id;
            return this;
        }
        
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final AlbumCategory other = (AlbumCategory) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
