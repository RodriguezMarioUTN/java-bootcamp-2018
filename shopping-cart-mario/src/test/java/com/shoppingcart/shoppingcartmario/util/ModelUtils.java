package com.shoppingcart.shoppingcartmario.util;

import com.shoppingcart.shoppingcartmario.model.Client;
import com.shoppingcart.shoppingcartmario.model.Item;
import com.shoppingcart.shoppingcartmario.model.Order;
import com.shoppingcart.shoppingcartmario.model.Payment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ModelUtils {


    public static Client createDefaultClient() {
        return Client.builder()
                .id(1)
                .firstName("bla")
                .lastName("bla")
                .description("testDescription")
                .payments(Collections.singletonList(new Payment()))
                .build();
    }

    public static List<Client> createListDefaultClient() {
        List<Client> clients = new ArrayList<>();
        clients.add(createDefaultClient());
        return clients;
    }

    public static Order createDefaultOrder() {
        return Order.builder()
                .id(1)
                .name("bla")
                .items(Collections.singletonList(null))
                .build();
    }

    public static List<Order> createListDefaultOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(createDefaultOrder());
        return orders;
    }

    public static Item createDefaultItem() {
        return Item.builder()
                .id(0)
                .name("bla")
                .pedido(createDefaultOrder())
                .build();
    }

    public static List<Item> createListDefaultItem() {
        List<Item> items = new ArrayList<>();
        items.add(createDefaultItem());
        return items;
    }

    public static Payment createDefaultPayment() {
        return Payment.builder()
                .amount(22)
                .client(createDefaultClient())
                .order(createDefaultOrder())
                .id(1)
                .build();
    }

    public static List<Payment> createListDefaultPayment() {
        List<Payment> payments = new ArrayList<>();
        payments.add(createDefaultPayment());
        return payments;
    }
}
