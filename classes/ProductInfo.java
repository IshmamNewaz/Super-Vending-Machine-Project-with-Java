package  classes;
import java.lang.*;

public class ProductInfo
{
	private String productName;
	private double price;
	
	public void setProduct(String productName){this.productName = productName;}
	public void setPrice(double price){this.price = price;}
	
	public String getProduct(){return productName;} 
	public double getPrice(){return price;} 
}