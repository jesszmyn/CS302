package com.cs302.retail_service.model;

import jakarta.persistence.*;
import java.time.Year;

@Entity
@Table(name = "watches")
public class Watch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelName;
    private String brand;
    private String modelFamily;
    private String serialNumber;
    private double price;
    private Year manufacturingYear;
    private int stock;

    @Embedded
    private Dimensions dimensions;

    @Embedded
    private Specifications specifications;

    public Watch() {}

    public Watch(String modelName, String brand, String modelFamily, String serialNumber,
                 double price, Year manufacturingYear, int stock,
                 Dimensions dimensions, Specifications specifications) {
        this.modelName = modelName;
        this.brand = brand;
        this.modelFamily = modelFamily;
        this.serialNumber = serialNumber;
        this.price = price;
        this.manufacturingYear = manufacturingYear;
        this.stock = stock;
        this.dimensions = dimensions;
        this.specifications = specifications;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModelFamily() {
        return modelFamily;
    }

    public void setModelFamily(String modelFamily) {
        this.modelFamily = modelFamily;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Year getManufacturingYear() {
        return manufacturingYear;
    }

    public void setManufacturingYear(Year manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public Specifications getSpecifications() {
        return specifications;
    }

    public void setSpecifications(Specifications specifications) {
        this.specifications = specifications;
    }
}
