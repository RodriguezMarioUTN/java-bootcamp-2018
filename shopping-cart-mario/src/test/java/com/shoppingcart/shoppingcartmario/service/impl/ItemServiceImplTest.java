package com.shoppingcart.shoppingcartmario.service.impl;

import com.shoppingcart.shoppingcartmario.model.Item;
import com.shoppingcart.shoppingcartmario.model.Order;
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

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceImplTest {

    @Mock
    private ItemRepository itemRepository;

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
        when(itemRepository.findByName(item.getName())).thenReturn(null);
        when(orderRepository.getOne(order.getId())).thenReturn(order);
        itemService.createItem(DTOUtils.toItemDTO(item));
        Mockito.verify(itemRepository, times(1)).findByName(item.getName());
        Mockito.verify(orderRepository, times(1)).getOne(order.getId());
        Mockito.verify(itemRepository, times(1)).save(item);
    }

    @Test
    public void getItemTest() {
        when(itemRepository.findOne(1)).thenReturn(ModelUtils.createDefaultItem());
        itemService.getItem(1);
        Mockito.verify(itemRepository, times(1)).findOne(1);
        Mockito.verify(itemRepository, times(1)).getOne(1);
    }

    @Test
    public void getAllItemsTest() {
        when(itemRepository.findAll()).thenReturn(ModelUtils.createListDefaultItem());
        itemService.getAllItems();
        Mockito.verify(itemRepository, times(1)).findAll();
    }

    @Test
    public void updateItemTest() {
        Item item = ModelUtils.createDefaultItem();
        when(itemRepository.findOne(item.getId())).thenReturn(item);
        doNothing().when(itemRepository)
                .update(item.getName(), item.getId());
        itemService.updateItem(item);
        Mockito.verify(itemRepository, times(1)).findOne(item.getId());
        Mockito.verify(itemRepository, times(1)).update(item.getName(), item.getId());
    }

    @Test
    public void deleteItemTest() {
        doNothing().when(itemRepository)
                .delete(1);
        itemService.deleteItem(1);
        Mockito.verify(itemRepository, times(1)).delete(1);

    }
}