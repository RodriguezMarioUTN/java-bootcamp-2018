package com.shoppingcart.shoppingcartmario.util;

import com.shoppingcart.shoppingcartmario.dto.ItemDTO;
import com.shoppingcart.shoppingcartmario.dto.PaymentDTO;
import com.shoppingcart.shoppingcartmario.model.Item;
import com.shoppingcart.shoppingcartmario.model.Payment;

public final class DTOUtils {

    public static ItemDTO toItemDTO(int id, String name) {
        return ItemDTO.builder()
                .id(id)
                .name(name)
                .build();
    }

    public static ItemDTO toItemDTO(Item item) {
        return ItemDTO.builder()
                .id(item.getId())
                .name(item.getName())
                .orderId(item.getPedido().getId())
                .build();
    }


//    public static PaymentDTO toPaymentDTO(String paymentId, String orderId, String amount) {
//        return PaymentDTO.builder()
//                .id(paymentId)
//                .orderId(orderId)
//                .amount(amount)
//                .build();
//    }
//
    public static PaymentDTO toPaymentDTO(Payment payment) {
        return PaymentDTO.builder()
                .id(payment.getId())
                .orderId(payment.getOrder().getId())
                .clientId(payment.getClient().getId())
                .amount(payment.getAmount())
                .build();
    }
}
