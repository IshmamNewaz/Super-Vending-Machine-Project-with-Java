package interfaces;
import classes.*;
public interface FileWriteOperations
{
	void InsertWrite(ProductInfo e);
	void Write1(String userName, double amountToBePaid, double paidWithDiscount);
	void Write(String userName, double amountToBePaid, double change);
	void RemoveItem(ProductInfo e);
	ProductInfo getrevItem(String productName);

}