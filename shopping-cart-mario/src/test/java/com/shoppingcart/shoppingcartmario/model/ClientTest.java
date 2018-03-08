package com.shoppingcart.shoppingcartmario.model;

import com.shoppingcart.shoppingcartmario.model.Client;
import com.shoppingcart.shoppingcartmario.util.ModelUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class ClientTest {

    private Client client;

    @Test
    public void shouldCreateANewItem(){
        Client client = ModelUtils.createDefaultClient();
        assertEquals("bla", client.getFirstName());
        assertEquals(1, client.getId());
    }
}