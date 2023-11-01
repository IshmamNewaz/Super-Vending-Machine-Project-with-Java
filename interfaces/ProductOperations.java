package interfaces;
import classes.*;
public interface ProductOperations
{
	void insertItem(ProductInfo e);
	void removeItem(ProductInfo e);
	ProductInfo getItem(String productName);
	void showAllItem();
}