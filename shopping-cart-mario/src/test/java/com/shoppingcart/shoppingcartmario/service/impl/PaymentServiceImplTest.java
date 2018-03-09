package com.shoppingcart.shoppingcartmario.service.impl;

import com.shoppingcart.shoppingcartmario.model.Client;
import com.shoppingcart.shoppingcartmario.model.Order;
import com.shoppingcart.shoppingcartmario.model.Payment;
import com.shoppingcart.shoppingcartmario.repository.ClientRepository;
import com.shoppingcart.shoppingcartmario.repository.OrderRepository;
import com.shoppingcart.shoppingcartmario.repository.PaymentRepository;
import com.shoppingcart.shoppingcartmario.util.DTOUtils;
import com.shoppingcart.shoppingcartmario.util.ModelUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.Model;

import javax.jws.WebParam;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;


@RunWith(MockitoJUnitRunner.class)
public class PaymentServiceImplTest {

    @Mock
    private PaymentRepository mockPaymentRepository;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private PaymentServiceImpl paymentService;

    private Payment payment;

    @Before
    public void setUp() {
        initMocks(PaymentServiceImplTest.class);
        payment = ModelUtils.createDefaultPayment();
    }

    @Test
    public void createPaymentTest() {
        Client client   = ModelUtils.createDefaultClient();
        Order order = ModelUtils.createDefaultOrder();
        System.out.println("Client credo x UTIL MODEL  = "+client.toString());
        when(clientRepository.getOne(client.getId())).thenReturn(client);
        when(orderRepository.getOne(order.getId())).thenReturn(order);
        paymentService.createPayment(DTOUtils.toPaymentDTO(payment));
        Mockito.verify(clientRepository, times(1)).getOne(client.getId());
        Mockito.verify(orderRepository, times(1)).getOne(order.getId());
        Mockito.verify(mockPaymentRepository, times(1)).save(payment);

    }

    @Test
    public void getPaymentTest() {
        when(mockPaymentRepository.findOne(1)).thenReturn(ModelUtils.createDefaultPayment());
        paymentService.getPayment(1);
        Mockito.verify(mockPaymentRepository, times(1)).findOne(1);
        Mockito.verify(mockPaymentRepository, times(1)).getOne(1);
    }

    @Test
    public void getAllPaymentsTest() {
        when(mockPaymentRepository.findAll()).thenReturn(ModelUtils.createListDefaultPayment());
        paymentService.getAllPayments();
        Mockito.verify(mockPaymentRepository, times(1)).findAll();
    }

    @Test
    public void updatePaymentTest() {
        Payment payment = ModelUtils.createDefaultPayment();
        when(mockPaymentRepository.findOne(1)).thenReturn(payment);
        doNothing().when(mockPaymentRepository)
                .update(payment.getAmount(), payment.getId());
        paymentService.updatePayment(payment);
        Mockito.verify(mockPaymentRepository, times(1)).findOne(1);
        Mockito.verify(mockPaymentRepository, times(1)).update(payment.getAmount(), payment.getId());
    }

    @Test
    public void deletePaymentTest() {
        doNothing().when(mockPaymentRepository)
                .delete(1);
        paymentService.deletePayment(1);
        Mockito.verify(mockPaymentRepository, times(1)).delete(1);

    }
}