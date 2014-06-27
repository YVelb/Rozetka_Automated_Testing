Narrative:
In order to purchase goods
As a registrated user at http://rozetka.com.ua/
I want to make shure delivery cost calculator works as expected

Scenario: Delivery is 35 hrn when you spend less then 1500 hrn.
Given home page of http://rozetka.com.ua/
And successful login
When the user has found goods
And added goods for less then 1500 hrn to his shopping cart
And proceeded to checkout
Then verify delivery cost is 35 hryvnas

Scenario: Delivery is free when you spend 1500 hrn.
Given home page of http://rozetka.com.ua/
And successful login
When the user has found goods
And added goods for 1500 hrn or more to his shopping cart
And proceeded to checkout
Then verify delivery is free

Scenario: Gift is given when you spend 20000 hrn.
Given home page of http://rozetka.com.ua/
And successful login
When the user has found goods
And added goods for more then 20000 hrn to his shopping cart
And proceeded to checkout
Then verify that free present is granted

Scenario: Delivery to the nearest Nova Poshta filia is 35 hrn when you spend less then 1500 hrn.
Given home page of http://rozetka.com.ua/
And successful login
When the user has found goods
And added goods for less then 1500 hrn to his shopping cart
And proceeded to checkout
Then verify delivery cost to the nearest Nova Poshta filia is 35 hryvnas