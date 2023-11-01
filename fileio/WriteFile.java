package  fileio;
import classes.*;
import interfaces.*;
import java.io.*;

public class WriteFile implements FileWriteOperations{
	public ProductInfo itemsx[] = new ProductInfo [100];
	
	public void InsertWrite(ProductInfo e)
	{
		int flag = 0;
		for(int i=0; i<itemsx.length; i++)
		{
			if(itemsx[i] == null)
			{
				itemsx[i] = e;
				break;
			}
		}
	}
	public ProductInfo getrevItem(String productName)
	{
		ProductInfo e = null;
		
		for(int i=0; i<itemsx.length; i++)
		{
			if(itemsx[i] != null)
			{
				if(itemsx[i].getProduct().equals(productName))
				{
					e = itemsx[i];
					break;
				}
			}
		}
		return e;
	}
	public void RemoveItem(ProductInfo e)
	{
		int flag = 0;
		for(int i=0; i<itemsx.length; i++)
		{
			if(itemsx[i] == e)
			{
				itemsx[i] = null;
				flag = 1;
				break;
			}
		}

	}

	public void Write1(String userName,double amountToBePaid, double paidWithDiscount){

		try{
			
			FileWriter bw = new FileWriter("PrintSlip/PrintSlip.txt");
			
			bw.write("Items Bought from SUPER VENDING MACHINE by "+userName+"\n\n");
			for(ProductInfo e : itemsx){
				if(e != null){
				bw.write("Name of Item: "+ e.getProduct());
				bw.write("\n 			Price: "+ e.getPrice()+" taka\n");
				}
			
			}
			bw.write("Totall Price was: "+amountToBePaid+" taka\n");	
			bw.write("With Discout Paid: "+paidWithDiscount+" taka");
			bw.write("\n\nThank You For using The SUPER VENDING MACHINE Please Come Again\n");
				
			bw.close();
			
		}
		catch(IOException io)
		{
			System.out.println("An error has just occured! :(");
			io.printStackTrace();
		}



	
	}
	public void Write(String userName,  double amountToBePaid, double change){

		try{
			
			FileWriter bw = new FileWriter("PrintSlip/PrintSlip.txt");
			bw.write("Items Bought from SUPER VENDING MACHINE by "+userName+"\n\n");
			for(ProductInfo e : itemsx){
				if(e != null){
				bw.write("Name of Item: "+ e.getProduct());
				bw.write("\n 			Price: "+ e.getPrice()+" taka\n");
				}
			
			}
			bw.write("You Paid: "+amountToBePaid+" taka\n");	
			bw.write("Your Change: "+change+" taka");
			bw.write("\n\nThank You For using The SUPER VENDING MACHINE Please Come Again\n");
				
			bw.close();
			
		}
		catch(IOException io)
		{
			System.out.println("An error has just occured! :(");
			io.printStackTrace();
		}



	
	}
}

