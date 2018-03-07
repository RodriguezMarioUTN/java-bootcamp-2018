package com.shoppingcart.shoppingcartmario.service.impl;

import com.shoppingcart.shoppingcartmario.model.Client;
import com.shoppingcart.shoppingcartmario.repository.ClientRepository;
import com.shoppingcart.shoppingcartmario.service.ClientService;
import com.shoppingcart.shoppingcartmario.util.ModelUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.JUnit38ClassRunner;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class ClientServiceImplTest {

    @Mock
    private ClientRepository mockClientReository;

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
//        when(mockClientReository.save(client)).thenReturn(client);
//        Client returnedClient = clientService.createClient(client);
//        Assert.assertEquals(1, returnedClient.getId());
        clientService.createClient(client);
        Mockito.verify(mockClientReository, times(1)).save(client);

    }


    @Test
    public void shouldGetClientByParameterTest() {
        when(mockClientReository.findById(1)).thenReturn(Optional.of(ModelUtils.createDefaultClient()));
        clientService.getClient(1);
        Mockito.verify(mockClientReository, times(1)).findById(1);
        Mockito.verify(mockClientReository, times(1)).getOne(1);
    }
    //este Utest deberia validar tmb el fi=uncionamiento interno del metodo como la llamada al metodo privado client exist?
    //o los UT solo chequean que la salida osea el return del metodo si lo tiene sea el correcto y si es un void?`


}