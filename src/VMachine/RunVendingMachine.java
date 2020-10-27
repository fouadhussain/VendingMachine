package VMachine;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Arrays;

public class RunVendingMachine {

	@SuppressWarnings("null")
	public static void main(String[] args) {
		// Create Vending Machine Object & display the products for sale
			VendingMachine vm = new VendingMachine();
		
		//Collect Input from User using bufferReader
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//check if Vending Machine Supplier
		System.out.println("\nDo you want to RESET Vending Machine (y/n): ");
		try {
			String resetvm = reader.readLine();
			if(resetvm.equals("y")) {
				System.out.println("Please Enter Admin Password:");
				String adminpwdinput = reader.readLine();
				boolean resetsuccess = vm.ResetVendingMachine(adminpwdinput);
				if(resetsuccess) {
					System.out.println("\nVending Machine SUCCESSFULLY RESET\n");
				}
				else {
					System.out.println("\nVending Machine NOT RESET\n");
				}
			}
			else
			{
				System.out.println("\nVending Machine NOT RESET\n");
			}
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
				
		try {
			//Ask the user to select a product 
			System.out.println("\nPlease select product, by entering the number: \n");
			//read line
			String pcode = reader.readLine();
			int code = Integer.parseInt(pcode)-1;
			String pname = vm.getProductName(code);
			
			//Enter the Coins
			boolean morecoinstoenter = true;
			String morecoins=" ";
			int coincounter=0;
			int coinsinputcounter=1;
			//String[] coininput=morecoins.split(" ");
			
			//Create Array to capture coins
			String[] coinarray = new String[50];
			
			while(morecoinstoenter) {
				System.out.println("\nEnter Coin "+coinsinputcounter+"-"+"(penny|nickel|dime|quarter)"+": ");
				coinarray[coincounter]= reader.readLine();
				System.out.println("More Coins to Enter: y/n");
				morecoins=reader.readLine();
				if (morecoins.equals("n")){
					morecoinstoenter=false;
					System.out.println("Do you wish to Cancel the Request");
					String request = reader.readLine();
					//if yes, then call the vending machine cancelRequest method and pass the coins entered array
					//if no, then call the vending machine proceedToChechout 
					//method and pass the string array containing the coins entered
					if (request.equals("y")) {
						//cancel the request and return the money entered into the machine
						vm.cancelRequest(coinarray);
						break;
					}
					
					//vend the product and return any change
					if(vm.vendProduct(coinarray)) {
						System.out.println("Item has been Dispensed");
					}
					else
					{
						//If vend not success then return the money and terminate program
						vm.cancelRequest(coinarray);
					}
					//exit loop
					break;
				}
				else{
					coinsinputcounter++;
					coincounter++;
				}
				
			}
			
			System.out.println("\nProgram Ended - Have a nice day :)");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
