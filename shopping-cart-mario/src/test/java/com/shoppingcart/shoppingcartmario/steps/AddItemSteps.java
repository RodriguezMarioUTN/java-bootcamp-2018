package com.shoppingcart.shoppingcartmario.steps;

import com.shoppingcart.shoppingcartmario.model.Client;
import com.shoppingcart.shoppingcartmario.model.Item;
import com.shoppingcart.shoppingcartmario.model.Order;
import com.shoppingcart.shoppingcartmario.repository.ClientRepository;
import com.shoppingcart.shoppingcartmario.repository.OrderRepository;
import com.shoppingcart.shoppingcartmario.service.ClientService;
import com.shoppingcart.shoppingcartmario.service.ItemService;
import com.shoppingcart.shoppingcartmario.util.DTOUtils;
import com.shoppingcart.shoppingcartmario.util.ModelUtils;
import org.jbehave.core.annotations.*;
import org.jbehave.core.junit.JUnitStory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;


import static org.junit.Assert.assertEquals;

@Steps
public class AddItemSteps {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Given("I have created a client and an order")
    public void createClientAndOrder() {
        Client cli = ModelUtils.createDefaultClient();
        clientRepository.save(cli);
        Order order = ModelUtils.createDefaultOrder();
        orderRepository.save(order);
    }

    @When("I create a new item for that this order")
    public void addItem() {
    Item item = ModelUtils.createDefaultItem();
    itemService.createItem(DTOUtils.toItemDTO(item));
    }

    @Then("Then the item is registered being associated with the order to which it belongs")
    public void getItem() {
        Item itemExpective = ModelUtils.createDefaultItem();
        itemExpective.setId(1);
        Item item = itemService.getItem(1);
        assertEquals(itemExpective, item);
    }

}