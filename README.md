Code Challenge - Module 1 - Vending Machine

Author: Fouad Hussain

JUnit Tests

1. JUnit_No_VMReset_and_Cancel_Request_for_Soda.java
*Test Description: 
Do not reset the Vending Machine. 
Then order a Soda but Cancel the Request when checking out
*Test Input Data:
Input the value = "n" when prompted to reset Vending Machine
Input the value="3" when prompted what product to purchase (soda)
Input the values {quarter, quarter} --> i.e. enter 2 coins only of type quarter
Input the value = "y" when prompted to cancel the request
*Expected result:
Product IS NOT dispensed
Two coins are returned of type Quarter (total value=50)

