Code Challenge - Module 1 - Vending Machine
-----------------------------------------------------------------------------------
Author: Fouad Hussain


JUnit Tests
------------------------------------------------------------------------------------


1. JUnit_No_VMReset_and_Cancel_Request_for_Soda.java
----------------------------------------------------
Test Description: 

-Do not reset the Vending Machine. 

-Then order a Soda but Cancel the Request when checking out

Test Input Data:

-Input the value = "n" when prompted to reset Vending Machine

-Input the value="3" when prompted what product to purchase (soda)

-Input the values {quarter, quarter} --> i.e. enter 2 coins only of type quarter

-Input the value = "y" when prompted to cancel the request

Expected result:

-The Product IS NOT dispensed

-Coins Returned {quarter, quarter} (total value=50)

2.JUnit_No_VMReset_and_Purchase_Coke_With_ChangeDispensed.java
----------------------------------------------------
Test Description: 

-Do not reset the Vending Machine. 

-Then order a Coke by inserting 2 dimes and 1 quarter (total=45)

Test Input Data:

-Input the value = "n" when prompted to reset Vending Machine

-Input the value="1" when prompted what product to purchase (soda)

-Input the values {dime, dime, quarter} --> i.e. enter 3 coins only

-Input the value = "n" when prompted to cancel the request

Expected result:

-The Product IS dispensed

-Total Change Given = 20cent

-Coins Returned {dime; dime} i.e. 20 cent

