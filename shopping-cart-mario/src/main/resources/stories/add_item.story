Meta:

Narrative:
As a Client
I want to register the items I add to an Order
So that I can see what items I am about to buy

Scenario: scenario add Items to Order
Given I have created a user and an order
When I create a new item for that this order
Then Then the item is registered being associated with the order to which it belongs