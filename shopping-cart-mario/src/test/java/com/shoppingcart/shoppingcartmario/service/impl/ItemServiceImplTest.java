package com.shoppingcart.shoppingcartmario.service.impl;

import com.shoppingcart.shoppingcartmario.model.Client;
import com.shoppingcart.shoppingcartmario.model.Item;
import com.shoppingcart.shoppingcartmario.model.Order;
import com.shoppingcart.shoppingcartmario.repository.ClientRepository;
import com.shoppingcart.shoppingcartmario.repository.ItemRepository;
import com.shoppingcart.shoppingcartmario.repository.OrderRepository;
import com.shoppingcart.shoppingcartmario.util.DTOUtils;
import com.shoppingcart.shoppingcartmario.util.ModelUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.jws.WebParam;
import java.sql.DataTruncation;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceImplTest {

    @Mock
    private ItemRepository mockItemRepository;

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private ItemServiceImpl itemService;

    private Item item;

    @Before
    public void setUp() {
        initMocks(ItemServiceImplTest.class);
        item = ModelUtils.createDefaultItem();
    }

    @Test
    public void createItemTest() {
        Item item = ModelUtils.createDefaultItem();
        Order order = ModelUtils.createDefaultOrder();
        when(mockItemRepository.findByName(item.getName())).thenReturn(null);
        when(orderRepository.getOne(order.getId())).thenReturn(order);
        itemService.createItem(DTOUtils.toItemDTO(item));
        Mockito.verify(mockItemRepository, times(1)).findByName(item.getName());
        Mockito.verify(orderRepository, times(1)).getOne(order.getId());
        Mockito.verify(mockItemRepository, times(1)).save(item);
    }

    @Test
    public void getItemTest() {
        when(mockItemRepository.findOne(1)).thenReturn(ModelUtils.createDefaultItem());
        itemService.getItem(1);
        Mockito.verify(mockItemRepository, times(1)).findOne(1);
        Mockito.verify(mockItemRepository, times(1)).getOne(1);
    }

    @Test
    public void getAllItemsTest() {
        when(mockItemRepository.findAll()).thenReturn(ModelUtils.createListDefaultItem());
        itemService.getAllItems();
        Mockito.verify(mockItemRepository, times(1)).findAll();
    }

    @Test
    public void updateItemTest() {
        Item item = ModelUtils.createDefaultItem();
        when(mockItemRepository.findOne(item.getId())).thenReturn(item);
        doNothing().when(mockItemRepository)
                .update(item.getName(), item.getId());
        itemService.updateItem(item);
        Mockito.verify(mockItemRepository, times(1)).findOne(item.getId());
        Mockito.verify(mockItemRepository, times(1)).update(item.getName(), item.getId());
    }

    @Test
    public void deleteItemTest() {
        doNothing().when(mockItemRepository)
                .delete(1);
        itemService.deleteItem(1);
        Mockito.verify(mockItemRepository, times(1)).delete(1);

    }
}