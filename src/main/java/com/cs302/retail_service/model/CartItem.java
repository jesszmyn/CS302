package com.cs302.retail_service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cart_id") // Foreign key to the Cart
    @JsonIgnore
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "watch_id") // Foreign key to the Watch
    private Watch watch;

    private int quantity;

    public CartItem() {}

    public CartItem(Watch watch, int quantity) {
        this.watch = watch;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Watch getWatch() {
        return watch;
    }

    public void setWatch(Watch watch) {
        this.watch = watch;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return watch.getPrice();
    }
}
