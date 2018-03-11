Narrative:
As a Client
I want to register the items I add to an Order
So that I can see what items I am about to buy

Lifecycle:
Before:

Scenario: scenario add Items to Order
Given i have created a client and an order
When i create a new item for that this order
Then the item is registered being associated with the order to which it belongs

