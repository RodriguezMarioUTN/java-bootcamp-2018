package com.shoppingcart.shoppingcartmario.model;

import com.shoppingcart.shoppingcartmario.repository.ClientRepository;
import com.shoppingcart.shoppingcartmario.service.impl.ClientServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class ItemTest {

    @Mock
    private Order mockOrder;
    //@Mock
    @InjectMocks
    private Item mockItem;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void shouldCreateANewItem(){
        Item item = Item.builder().id(1).name("item1").pedido(mockOrder).build();
        assertEquals("item1", item.getName());
        assertEquals(1, item.getId());
    }
}