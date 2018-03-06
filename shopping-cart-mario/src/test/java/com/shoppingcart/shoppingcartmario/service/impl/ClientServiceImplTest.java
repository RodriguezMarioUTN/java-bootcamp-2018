package com.shoppingcart.shoppingcartmario.service.impl;

import com.shoppingcart.shoppingcartmario.model.Client;
import com.shoppingcart.shoppingcartmario.repository.ClientRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ClientServiceImplTest {

/*    @Mock
    private Client mockCli;*/

    private Client mockCli = mock(Client.class);

/*    @Mock*/
    private ClientRepository mockClientReository = mock(ClientRepository.class);

/*    @Mock*/
    private ClientServiceImpl mockClientService = mock(ClientServiceImpl.class);

    //hay muchas formas de instanciar un mock este no esta instanciado
//    @Before
//    public void setUp() {
//        initMocks(this);
//    }

    @Test
    public void shouldSaveAddClientByParameter() {
/*        mockCli = Client.builder().id(99).firstName("mario")
                .lastName("rodriguez").description("futuro java dev").build();*/
        when(mockClientReository.save(mockCli)).thenReturn(mockCli);
    mockClientService.createClient(mockCli);
    }

    @Test
    public void shouldGetClientByParameter() {
/*        mockCli = Client.builder().id(99).firstName("mario")
                .lastName("rodriguez").description("futuro java dev").build();*/
        int MOCK_ID_CLIENT = 1;
        when(mockClientReository.getOne(MOCK_ID_CLIENT)).thenReturn(mockCli);
        mockClientService.getClient(MOCK_ID_CLIENT);
    }


}