package scripts;
import static org.junit.jupiter.api.Assertions.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.junit.jupiter.api.Test;
import VMachine.VendingMachine;

class JUnit_Reset_Vending_Machine {

	@Test
	void test() {
		// Create Vending Machine Object & display the products for sale
		VendingMachine vm = new VendingMachine();
	
		//Collect Input from User using bufferReader
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
		//check if Vending Machine Supplier
		System.out.println("\nDo you want to RESET Vending Machine (y/n): ");
		try {
				String resetvm = reader.readLine();
				if(resetvm.equals("y")) 
				{
					System.out.println("Please Enter Admin Password:");
					String adminpwdinput = reader.readLine();
					boolean resetsuccess = vm.ResetVendingMachine(adminpwdinput);
					if(resetsuccess) 
					{
						System.out.println("\nVending Machine SUCCESSFULLY RESET\n");
					}
					else 
					{
						System.out.println("\nVending Machine NOT RESET\n");
					}                              
				}
				else
				{
					System.out.println("\nVending Machine NOT RESET\n");
				}
		} 
		catch (IOException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
