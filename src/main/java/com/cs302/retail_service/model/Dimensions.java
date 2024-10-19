package com.cs302.retail_service.model;

import javax.persistence.Embeddable;

@Embeddable
public class Dimensions {
    private double diameter;
    private double lugToLugDistance;
    private double thickness;

    public Dimensions() {}

    public Dimensions(double diameter, double lugToLugDistance, double thickness) {
        this.diameter = diameter;
        this.lugToLugDistance = lugToLugDistance;
        this.thickness = thickness;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public double getLugToLugDistance() {
        return lugToLugDistance;
    }

    public void setLugToLugDistance(double lugToLugDistance) {
        this.lugToLugDistance = lugToLugDistance;
    }

    public double getThickness() {
        return thickness;
    }

    public void setThickness(double thickness) {
        this.thickness = thickness;
    }
}
