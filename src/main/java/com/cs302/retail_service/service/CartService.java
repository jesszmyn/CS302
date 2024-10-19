package com.cs302.retail_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs302.retail_service.model.Cart;
import com.cs302.retail_service.model.CartItem;
import com.cs302.retail_service.model.Watch;
import com.cs302.retail_service.repository.CartRepository;
import com.cs302.retail_service.repository.WatchRepository;

import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private WatchRepository watchRepository;

    private static final Logger logger = LoggerFactory.getLogger(CartService.class);

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public Cart addToCart(Long cartId, Long watchId, int quantity) {
        Cart cart = cartRepository.findById(cartId).orElse(new Cart());
        
        // Initialize the cart item list if it's null
        if (cart.getItems() == null) {
            cart.setItems(new ArrayList<>());
        }
        
        Watch watch = watchRepository.findById(watchId)
            .orElseThrow(() -> new RuntimeException("Watch not found"));

        if (watch.getStock() < quantity) {
            throw new RuntimeException("Not enough stock available");
        }

        CartItem cartItem = new CartItem();
        cartItem.setWatch(watch);
        cartItem.setQuantity(quantity);
        cartItem.setCart(cart);

        cart.getItems().add(cartItem);

        return cartRepository.save(cart);
    }

    @Transactional
    public String checkout(Long cartId) {
        Cart cart = cartRepository.findById(cartId)
            .orElseThrow(() -> new RuntimeException("Cart not found"));

        for (CartItem item : cart.getItems()) {
            Watch watch = item.getWatch();
            int quantity = item.getQuantity();

            logger.info("Watch before checkout: " + watch.getModelName() + " - Stock: " + watch.getStock());

            if (watch.getStock() < quantity) {
                throw new RuntimeException("Not enough stock for watch: " + watch.getModelName());
            }

            // Reduce stock after successful checkout
            watch.setStock(watch.getStock() - quantity);
            watchRepository.save(watch);

            logger.info("Watch after checkout: " + watch.getModelName() + " - Stock: " + watch.getStock());

        }

        return "Checkout successful for cart ID: " + cartId;
    }

    public Cart viewCart(Long cartId) {
        return cartRepository.findById(cartId).orElse(new Cart());
    }
}
