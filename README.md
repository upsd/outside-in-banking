# Outside-in Banking
An example of undertaking the below Kata whilst using an Outside-in methodology.

* The objective is to define a design for the first story of a new product we will be launching soon.
* We will be creating a design using CRC cards, following OO design principles such as SOLID, DRY, YAGNI, 
Tell Don’t Ask, etc.
* The product is a personal savings ATM machine like this:
    * For the first release
        * We will disregard the card reader and user authentication, safe, money counting.
        * We will implement the Deposit, Withdraw and Print Statement operations.
    
We have the following GTW definition for our first user story:
```
Given a kid makes a deposit of 10 on 10-01-2012
And a deposit of 20 on 13-01-2012
And a withdrawal of 5 on 14-01-2012
When they print their bank statement

Then they would see:
date || credit || debit || balance
14/01/2012 || || 5.00 || 25.00
13/01/2012 || 20.00 || || 30.00
10/01/2012 || 10.00 || || 10.00
```