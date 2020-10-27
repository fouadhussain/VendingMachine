Code Challenge - Module 1 - Vending Machine
-----------------------------------------------------------------------------------
Author: Fouad Hussain
Project Notes: 

-JUnit 5 and JavaSE_14
-Src has 2 sub dir - scripts (JUnit) and VMachine (frameowrk and main program)
-You can run the program by choosing a JUnit test to run (use below notes for guidance)
- You can run the main program from VMachine package - RunVendingMachine.java

------------------------------------------------------------------------------------
JUnit Tests
------------------------------------------------------------------------------------

----------------------------------------------------
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


----------------------------------------------------
2. JUnit_No_VMReset_and_Purchase_Coke_With_ChangeDispensed.java
----------------------------------------------------
Test Description: 

-Do not reset the Vending Machine. 

-Then order a Coke by inserting 2 dimes and 1 quarter (total=45)

Test Input Data:

-Input the value = "n" when prompted to reset Vending Machine

-Input the value="1" when prompted what product to purchase (coke)

-Input the values {dime, dime, quarter} --> i.e. enter 3 coins only

-Input the value = "n" when prompted to cancel the request

Expected result:

-The Product IS dispensed

-Total Change Given = 20cent

-Coins Returned {dime; dime} i.e. 20 cent




----------------------------------------------------
3. JUnit_No_VMReset_and_Purchase_Pepsi_for_TenCent.java
----------------------------------------------------
Test Description: 

-Do not reset the Vending Machine. 

-Then order a Pepsi by inserting 1 nickel and 5 penny (total=10)

Test Input Data:

-Input the value = "n" when prompted to reset Vending Machine

-Input the value="2" when prompted what product to purchase (pepsi)

-Input the values {nickel, penny, penny, penny, penny, penny} --> i.e. enter 6 coins only

-Input the value = "n" when prompted to cancel the request

Expected result:

-The Product IS NOT dispensed

-Request is Cancelled

-Coins Returned {nickel, penny, penny, penny, penny, penny} i.e. 10 cent

----------------------------------------------------
4. JUnit_Reset_Vending_Machine.java
----------------------------------------------------
Test Description: 

-Reset the Vending Machine successfully. 

Test Input Data:

-Input the value = "y" when prompted to reset Vending Machine

-Input the value="vendingADMIN" when prompted for password

Expected result:

-The Vending Machine is Successfully reset

----------------------------------------------------
4. JUnit_Reset_Vending_Machine.java
----------------------------------------------------
Test Description: 

-Reset the Vending Machine Unsuccessfully. 

Test Input Data:

-Input the value = "y" when prompted to reset Vending Machine

-Input the value="ADMIN" when prompted for password

Expected result:

-The Vending Machine is NOT Successfully reset

----------------------------------------------------
5. JUnit_Reset_VM_and_Purchase_Soda_with_Exact_Money.java
----------------------------------------------------
Test Description: 

-Reset the Vending Machine Successfully. 

-Then order a Soda by inserting {1xquarter, 3xNickel, 5xpenny} (total=45)

Test Input Data:

-Input the value = "y" when prompted to reset Vending Machine

-Input the value="vendingADMIN" when prompted for password

-Input the value="3" when prompted what product to purchase (soda)

-Input the values {quarter; nickel; nickel; nickel; penny; penny; penny; penny; penny} --> i.e. enter 9 coins only

-Input the value = "n" when prompted to cancel the request

Expected result:

-The Product IS dispensed

-No Change Returned
