package com.cs302.retail_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cs302.retail_service.model.Cart;
import com.cs302.retail_service.service.CartService;
import java.util.List;


@RestController
@RequestMapping("/api/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/{cartId}/add")
    public Cart addToCart(@PathVariable Long cartId, @RequestParam Long watchId, @RequestParam int quantity) {
        return cartService.addToCart(cartId, watchId, quantity);
    }

    @GetMapping
    public List<Cart> getAllCarts() {
        return cartService.getAllCarts();
    }

    @GetMapping("/{cartId}")
    public Cart viewCart(@PathVariable Long cartId) {
        return cartService.viewCart(cartId);
    }

    @DeleteMapping("/{cartId}/items/{cartItemId}")
    public Cart deleteCartItem(@PathVariable Long cartId, @PathVariable Long cartItemId) {
        return cartService.deleteItemFromCart(cartId, cartItemId);
    }

    @PutMapping("/{cartId}/items/{cartItemId}")
    public Cart updateCartItemQuantity(@PathVariable Long cartId, @PathVariable Long cartItemId, @RequestParam int newQuantity) {
        return cartService.updateCartItemQuantity(cartId, cartItemId, newQuantity);
    }

    @PostMapping("/{cartId}/checkout")
    public String checkout(@PathVariable Long cartId) {
        return cartService.checkout(cartId);
    }
}
