package com.shoppingcart.shoppingcartmario.service.impl;

import com.shoppingcart.shoppingcartmario.model.Order;
import com.shoppingcart.shoppingcartmario.repository.OrderRepository;
import com.shoppingcart.shoppingcartmario.util.ModelUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderServiceImpl orderService;

    private Order order;

    @Before
    public void setUp() {
        initMocks(OrderServiceImplTest.class);
        order = ModelUtils.createDefaultOrder();
    }

    @Test
    public void createOrderTest() {
        orderService.createOrder(order);
        Mockito.verify(orderRepository, times(1)).save(order);

    }

    @Test
    public void getOrderTest() {
        when(orderRepository.findOne(1)).thenReturn(ModelUtils.createDefaultOrder());
        orderService.getOrder(1);
        Mockito.verify(orderRepository, times(1)).findOne(1);
        Mockito.verify(orderRepository, times(1)).getOne(1);
    }

    @Test
    public void getAllOrdersTest() {
        when(orderRepository.findAll()).thenReturn(ModelUtils.createListDefaultOrder());
        orderService.getAllOrders();
        Mockito.verify(orderRepository, times(1)).findAll();
    }

    @Test
    public void updateOrderTest() {
        Order order = ModelUtils.createDefaultOrder();
        when(orderRepository.findOne(1)).thenReturn(order);
        doNothing().when(orderRepository)
                .update(order.getName(), order.getId());
        orderService.updateOrder(order);
        Mockito.verify(orderRepository, times(1)).findOne(1);
        Mockito.verify(orderRepository, times(1)).update(order.getName(), order.getId());
    }

    @Test
    public void deleteOrderTest() {
        doNothing().when(orderRepository)
                .delete(1);
        orderService.deleteOrder(1);
        Mockito.verify(orderRepository, times(1)).delete(1);

    }
}