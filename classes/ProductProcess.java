package  classes;
import java.lang.*;
import interfaces.*;
import fileio.*;
import java.io.*;
public class ProductProcess implements  ProductOperations{
	public ProductInfo items[] = new ProductInfo [100];
	private int producList=0;
	public void insertItem(ProductInfo e)
	{
		int flag = 0;
		for(int i=0; i<items.length; i++)
		{
			if(items[i] == null)
			{
				items[i] = e;
				flag = 1;
				break;
			}
		}
		if(flag == 1)
		{
			System.out.println(" is Added");
		}
		else
		{
			System.out.println("Can Not Add");
		}
	}
	
	public void removeItem(ProductInfo e)
	{
		int flag = 0;
		for(int i=0; i<items.length; i++)
		{
			if(items[i] == e)
			{
				items[i] = null;
				flag = 1;
				break;
			}
		}
		if(flag == 1){
			System.out.println("Item Removed");
			System.out.println("");
		}
		else{
			System.out.println("Can Not Remove");
			System.out.println("");
		}
	}
	public void showAllItem()
	{
		System.out.println("____FULL list of Your Shopping____\n");

		for(ProductInfo e : items)
		{
			if(e != null)
			{
				System.out.println("Name of Item: "+ e.getProduct());
				System.out.println("			Price: "+ e.getPrice()+" taka\n");
			}
			
		}
		System.out.println("-------------------------------\n");
	}
	
	public int ProductList(){
		for(ProductInfo e : items){
			
			if(e != null){
				producList = 1;
			}
		}
		return producList;
		
	}

	public ProductInfo getItem(String productName)
	{
		ProductInfo e = null;
		
		for(int i=0; i<items.length; i++)
		{
			if(items[i] != null)
			{
				if(items[i].getProduct().equals(productName))
				{
					e = items[i];
					break;
				}
			}
		}
		if(e != null)
		{
			System.out.println("Items Found");
			System.out.println("");
		}
		else
		{
			System.out.println("Items Not Found");
			System.out.println("");
		}
		return e;
	}
	public double calculate()
	{
		
		double sum=0;
		for(ProductInfo e : items)
		{
			if(e != null)
			{
				sum = sum+e.getPrice();
				
			}
		}
		return sum;
	}
	
	public double cardTransactions(){
		double sum=0;
		for(ProductInfo e : items)
		{
			if(e != null)
			{
				sum = sum+e.getPrice()-(e.getPrice()*0.1);
				
			}
		}
		
		
		return sum;
	}


}