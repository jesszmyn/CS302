package com.cs302.retail_service.model;

import javax.persistence.Embeddable;

@Embeddable
public class Specifications {
    private int waterResistanceRating;

    public Specifications() {}

    public Specifications(int waterResistanceRating) {
        this.waterResistanceRating = waterResistanceRating;
    }

    public int getWaterResistanceRating() {
        return waterResistanceRating;
    }

    public void setWaterResistanceRating(int waterResistanceRating) {
        this.waterResistanceRating = waterResistanceRating;
    }
}