/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.musicstore.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author 212037943
 */
@Embeddable
public class ArtistInformation implements Serializable{
    private String statusOfInformation;
}
