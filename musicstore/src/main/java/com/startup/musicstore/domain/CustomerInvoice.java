/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.domain;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Embeddable;

/**
 *
 * @author 212037943
 */
@Embeddable
public class CustomerInvoice {
    private Date invoicedate;
    private BigDecimal orderAmount;
    private String invoiceStatus;

    private CustomerInvoice(Builder aThis) {
        this.invoiceStatus = aThis.invoiceStatus;
        this.invoicedate = aThis.invoicedate;
        this.orderAmount = aThis.orderAmount;
    }

    public Date getInvoicedate() {
        return invoicedate;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public String getInvoiceStatus() {
        return invoiceStatus;
    }
    
    public static class Builder{
        private Date invoicedate;
        private BigDecimal orderAmount;
        private String invoiceStatus;

        public Builder(Date invoicedate) {
            this.invoicedate = invoicedate;
        }

        public Builder setInvoicedate(Date invoicedate) {
            this.invoicedate = invoicedate;
            return this;
        }

        public Builder setOrderAmount(BigDecimal orderAmount) {
            this.orderAmount = orderAmount;
            return this;
        }

        public Builder setInvoiceStatus(String invoiceStatus) {
            this.invoiceStatus = invoiceStatus;
            return this;
        }
        
        public CustomerInvoice build(){
            return new CustomerInvoice(this);
        }
    }
}
