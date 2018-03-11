package com.shoppingcart.shoppingcartmario.integratiotest.tests.ingest;


import com.shoppingcart.shoppingcartmario.model.Client;
import com.shoppingcart.shoppingcartmario.model.Item;
import com.shoppingcart.shoppingcartmario.model.Order;
import com.shoppingcart.shoppingcartmario.repository.ClientRepository;
import com.shoppingcart.shoppingcartmario.repository.OrderRepository;
import com.shoppingcart.shoppingcartmario.service.ClientService;
import com.shoppingcart.shoppingcartmario.service.ItemService;
import com.shoppingcart.shoppingcartmario.service.OrderService;
import com.shoppingcart.shoppingcartmario.util.DTOUtils;
import com.shoppingcart.shoppingcartmario.util.ModelUtils;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class LoadSteps extends Steps {

    @Autowired
    private ItemService itemService;

//    @Autowired
//    private ClientService clientService;
//
//    @Autowired
//    private OrderService orderService;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private OrderRepository orderRepository;

    Client cli = ModelUtils.createDefaultClient();
    Order order = ModelUtils.createDefaultOrder();

    @Given("i have created a client and an order")
    public void loadData() {
//        clientRepository.save(cli);
//        orderRepository.save(order);
    }

    @When("i create a new item for that this order")
    public void addItem() {
    }

    @Then("the item is registered being associated with the order to which it belongs")
    public void checkItem() {

    }


//    @Given("i have created a client and an order")
//    public void createClientAndOrder() {
////        Client cli = ModelUtils.createDefaultClient();
////        clientRepository.save(cli);
////        Order order = ModelUtils.createDefaultOrder();
////        orderRepository.save(order);
//        System.out.println("Termino el Give_?");
//    }
//
//    @When("i create a new item for that this order")
//    public void addItem() {
////        Item item = ModelUtils.createDefaultItem();
////        itemService.createItem(DTOUtils.toItemDTO(item));
//        System.out.println("algo");
//    }
//
//    @Then("the item is registered being associated with the order to which it belongs")
//    public void getItesam() {
//        Item itemExpective = ModelUtils.createDefaultItem();
//        Item item = ModelUtils.createDefaultItem();
////        itemExpective.setId(1);
////        Item item = itemService.getItem(1);
//        assertEquals(itemExpective, item);
//    }


}
