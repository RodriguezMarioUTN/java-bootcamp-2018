package com.shoppingcart.shoppingcartmario.service.impl;

import com.shoppingcart.shoppingcartmario.model.Client;
import com.shoppingcart.shoppingcartmario.repository.ClientRepository;
import com.shoppingcart.shoppingcartmario.util.ModelUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class ClientServiceImplTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientServiceImpl clientService;

    private Client client;

    @Before
    public void setUp() {
        initMocks(ClientServiceImplTest.class);
        client = ModelUtils.createDefaultClient();
    }

    @Test
    public void shouldSaveAddClientByParameterTest() {
        clientService.createClient(client);
        Mockito.verify(clientRepository, times(1)).save(client);
    }

    @Test
    public void shouldGetClientByParameterTest() {
        when(clientRepository.findOne(1)).thenReturn(ModelUtils.createDefaultClient());
        clientService.getClient(1);
        Mockito.verify(clientRepository, times(1)).findOne(1);
        Mockito.verify(clientRepository, times(1)).getOne(1);
    }

    @Test
    public void getAllClientsTest() {
        when(clientRepository.findAll()).thenReturn(ModelUtils.createListDefaultClient());
        clientService.getAllClients();
        Mockito.verify(clientRepository, times(1)).findAll();
    }

    @Test
    public void updateClientTest() {
        Client client = ModelUtils.createDefaultClient();
        when(clientRepository.findOne(1)).thenReturn(client);
        doNothing().when(clientRepository)
                .update(client.getFirstName(), client.getLastName(),
                        client.getDescription(), client.getId());
        clientService.updateClient(client);
        Mockito.verify(clientRepository, times(1)).findOne(1);
        Mockito.verify(clientRepository, times(1)).update(client.getFirstName(), client.getLastName(), client.getDescription(), client.getId());
    }

    @Test
    public void deleteClientTest() {
        doNothing().when(clientRepository)
                .delete(1);
        clientService.deleteClient(1);
        Mockito.verify(clientRepository, times(1)).delete(1);
    }





}