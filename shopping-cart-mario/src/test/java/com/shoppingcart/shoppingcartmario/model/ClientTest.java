package com.shoppingcart.shoppingcartmario.model;

import com.shoppingcart.shoppingcartmario.model.Client;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ClientTest {
    static int MOCK_ID = 99;
    static String MOCK_FIRST_NAME = "Mario";
    static String MOCK_LAST_NAME = "Rodriguez";
    static String MOCK_DESCRIPTION = "Futuro Java Dev";
    static List<Payment> MOCK_PAYMENTS;
    @Test
    public void shouldCreateANewClient(){
        Client cli = Client.builder().id(MOCK_ID).firstName(MOCK_FIRST_NAME)
                .lastName(MOCK_LAST_NAME).description(MOCK_DESCRIPTION).payments(MOCK_PAYMENTS).build();
        assertEquals(MOCK_FIRST_NAME, cli.getFirstName()); //assertThat
        assertEquals(MOCK_LAST_NAME, cli.getLastName());
        assertEquals(MOCK_DESCRIPTION, cli.getDescription());
        assertEquals(MOCK_ID, cli.getId());
        //- como hago assert de un objeto de un tipo especifico? private List<Payment> payments;
    }


}