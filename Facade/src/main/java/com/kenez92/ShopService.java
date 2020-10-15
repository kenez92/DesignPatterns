package com.kenez92;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ShopService {
    private final List<Order> orders = new ArrayList<>();
    private final Authenticator authenticator;
    private final ProductService productService;
    private final Random random = new Random();

    public ShopService(Authenticator authenticator, ProductService productService) {
        this.authenticator = authenticator;
        this.productService = productService;
    }

    public Long openOrder(Long userId) {
        if (authenticator.isAuthenticated(userId)) {
            Long maxOrder = orders.stream()
                    .mapToLong(Order::getOrderId)
                    .max().orElse(0);
            orders.add(new Order(maxOrder + 1, userId, productService));
            return maxOrder + 1;
        } else {
            return -1L;
        }
    }

    public void addItem(Long orderId, Long productId, double qty) {
        Order order = getOrder(orderId);
        order.getItems().add(new Item(productId, qty));
    }

    public boolean removeItem(Long orderId, Long productId) {
        Order order = getOrder(orderId);
        if (order != null) {
            for (int i = 0; i < order.getItems().size(); i++) {
                Item item = order.getItems().get(i);
                if (item.getProductId().equals(productId)) {
                    order.getItems().remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    public BigDecimal calculateValue(Long orderId) {
        Order order = getOrder(orderId);
        if (order == null) {
            return BigDecimal.ZERO;
        }
        return order.calculateValue();
    }

    public boolean doPayment(Long orderId) {
        Order order = getOrder(orderId);
        if (order.isPaid()) {
            return true;
        } else {
            order.setPaid(random.nextBoolean());
            return order.isPaid();
        }
    }

    public boolean verifyOrder(Long orderId) {
        Order order = getOrder(orderId);
        if (order == null) {
            return false;
        }
        boolean result = order.isPaid();
        if (!order.isVerified()) {
            order.setVerified(result && random.nextBoolean());
        }
        return order.isVerified();
    }

    public boolean submitOrder(Long orderId) {
        Order order = getOrder(orderId);
        if (order == null) {
            return false;
        }
        if (order.isVerified()) {
            order.setSubmitted(true);
        }
        return order.isSubmitted();
    }

    public void cancelOrder(Long orderId) {
        Order order = getOrder(orderId);
        orders.remove(order);
    }

    private Order getOrder(Long orderId) {
        if (orderId != null) {
            for (Order order : orders) {
                if (order.getOrderId().equals(orderId)) {
                    return order;
                }
            }
        }
        System.out.println("Order not found!");
        return null;
    }
}
