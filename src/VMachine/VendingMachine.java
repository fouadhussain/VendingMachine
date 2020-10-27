package VMachine;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {
	
	//private int penny = 1;
	//private int nickel =5;
	//private int dime =10;
	//private int quarter =25;
	
	private Map<String, List<String>> hashmapvmproducts;
	//private int costprice;
	private int sumofcoinsentered=0;

	
	//private int refundmoney=0;
	//private int vendProductCost=0;
	
	private String pname;
	private String pcost;
	
	public VendingMachine(){
		
		hashmapvmproducts = new HashMap<>();
		
		//2D array to store products and price
		ArrayList<String> vmproducts=new ArrayList<>();
 		vmproducts.add("1.Coke 25");
 		vmproducts.add("2.Pepsi 35");
 		vmproducts.add("3.Soda 45");
 		
 		int arraysize = vmproducts.size();
 		
 		hashmapvmproducts.put("drinkproducts",vmproducts);
 		
 		for (int i=0;i<arraysize;i++) {
 			System.out.println(hashmapvmproducts.get("drinkproducts").get(i));
 		}
 		
	}
	
	//public String[] displayProducts() {
		//Print the products to the console
		//System.out.println("Displaying Products \n");
		//for(int i = 0; i<totalproducts; i++) {
			//System.out.println("Product " + i + ":"+products[i].toString() );
		//}
		
		//return products;
	//}
	
	public String getProductName(int pcode) {
		
		String selectionstring = hashmapvmproducts.get("drinkproducts").get(pcode);
		//System.out.println("You Selected: "+selectionstring);
		
		int y = selectionstring.length();		
		String[] splitString = selectionstring.split(" ");
		String partone = splitString[0];
		pcost = splitString[1];
		
		pname = partone.substring(2);
		//System.out.println(partonetrim);
		//System.out.println(parttwo);
		
		System.out.println("You Selected: "+pname);
		System.out.println("Please Pay: "+pcost+"Cent");
		System.out.println("\nAccepted Coins: \n" + "Penny(1); Nickel(5); Dime(10); Quarter(25)");

		return pname;
	}
	
	
	public void cancelRequest(String[] coinsentered) {
		
		//return money entered into vending machine
		int x=0;
		System.out.println("\nRequest cancelled, NO product dispensed - Returning Your Money: ");
		while (coinsentered[x] !=null) {
			System.out.println(coinsentered[x]);
			
			x++;
		}
	
	}
	
	public boolean vendProduct(String[] coinsentered) {
		
		//vend success flag
		boolean vendSuccess=true;
		//vend the change, if required
		
		//Check cost of product
		//1. sum the coins entered
		int x = 0;
		while (coinsentered[x] !=null) {
			//System.out.println(coinsentered[x]);
			if (coinsentered[x].equals("penny")) {
				sumofcoinsentered = sumofcoinsentered+1;
			}
			//use the contains function instead of equals to allow for more flex during user input
			else if (coinsentered[x].contains("kel")) {
				sumofcoinsentered = sumofcoinsentered+5;
			}
			else if (coinsentered[x].contains("ime")) {
				sumofcoinsentered = sumofcoinsentered+10;
			}
			else if (coinsentered[x].contains("rter")) {
				sumofcoinsentered = sumofcoinsentered+25;
			}
			else {
				System.out.println("Invalid Coin/Amount Entered - Returning Any Money Entered");
				vendSuccess=false;
				break;
			}
			//increment array counter
			x++;
		}
		//logic to dispense the product
		System.out.println("Total Value of Coins="+sumofcoinsentered);
		//parse the product cost to INT
		int selectioncost = Integer.parseInt(pcost);
		if (sumofcoinsentered==selectioncost) {
			//Dispense the product with no change
			vendSuccess=true;
		}
		else if (sumofcoinsentered>selectioncost) {
			//Dispense product with change
			vendSuccess=true;
			int change = sumofcoinsentered-selectioncost;
			System.out.println("Vend Success: "+pname);
			System.out.println("Change Given: "+change);
			String[] changetoreturnuser = ChangeArray(change);
			DispenseChange(changetoreturnuser);
		}
		else if(sumofcoinsentered<selectioncost) {
			//Do not dispense the product
			vendSuccess=false;
		}
		return vendSuccess;
	

	}
	
	private void DispenseChange(String[] change) {
		//method to return the change to user - takes the changearray as input
		//return money entered into vending machine
		int x=0;
		if (change[x]!=null) {
			System.out.println("\nReturning Coins (Change): ");
		}
		else {
			System.out.println("No Change to Dispense");
		}
			
		//vend the change
		while (change[x] !=null) {
			System.out.println(change[x]);
			
			x++;
		}
	}
	
	
	private String[] ChangeArray(int change) {
		
		//array to store the change
		String[] changearray = new String[25];
		
		//How much to dispense
		int changetodispense=change;
		int changearraycounter=0;
		//while changetodispense is not equal to zero
		while (changetodispense !=0) {
			//If changetodispense greater than or equal 25 then
			//add a quarter to the change array
			//subtract 25 from changetodispense
			
			if (changetodispense>=25) {
				changearray[changearraycounter]="quarter";
				changetodispense=changetodispense-25;
				//increment the array counter to next position
				changearraycounter++;
			}
			else if(changetodispense<25 && changetodispense>=10) {
				//else if changetodispense < 25 && changetodispense>10
				//add a dime to the array
				//subtract 10 from changetodispense
				changearray[changearraycounter]="dime";
				changetodispense=changetodispense-10;
				//increment the array counter to next position
				changearraycounter++;
			}
			else if(changetodispense<10 && changetodispense>=5) {
				//else if changetodispense<=10 && changetodispense>=5
				//add a nickel to the array
				//subtract 10 from changetodispense
				changearray[changearraycounter]="nickel";
				changetodispense=changetodispense-5;
				//increment the array counter to next position
				changearraycounter++;
			}
			else if(changetodispense<5 &&changetodispense>0) {
				//else if changetodispense < 25 && changetodispense>10
				//add a nickel to the array
				//subtract 10 from changetodispense
				changearray[changearraycounter]="penny";
				changetodispense=changetodispense-1;
				//increment the array counter to next position
				changearraycounter++;
			}
			else if(changetodispense==0) {
				//exit
				break;
			}
			
		}
			
		//return the change array
		return changearray;
	}
	
	public boolean ResetVendingMachine(String pwd) {
		
		boolean reset = false;
		//check that the password supplied by technician
		if(pwd.equals("vendingADMIN")) {
			//code here to perform any Vending Machine reset activities
			reset=true;
		}
		return reset;
	}
		

}
