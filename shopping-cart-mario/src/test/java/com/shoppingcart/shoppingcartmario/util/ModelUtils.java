package com.shoppingcart.shoppingcartmario.util;

import com.shoppingcart.shoppingcartmario.model.Client;
import com.shoppingcart.shoppingcartmario.model.Payment;

import java.util.ArrayList;
import java.util.Collections;

public final class ModelUtils {


    public static Client createDefaultClient() {
        return Client.builder()
//                .id(1)
                .firstName("bla")
                .lastName("bla")
                .description("testDescription")
                .payments(Collections.singletonList(new Payment()))
                .build();
    }
}
