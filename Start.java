import java.util.*;
import java.lang.*;
import java.io.*;
import fileio.*;
import interfaces.*;
import classes.*;

public class Start{
	
	public static void main(String[] args){
    	Boolean key=true;
    	int retLogKey;
    	Scanner input = new Scanner(System.in);
    	ProductProcess p = new ProductProcess();
    	AboutUs aboutUs = new AboutUs();
		UserLogin uL = new UserLogin();
		LoginInfo lI = new LoginInfo();
		CardChecker cCheck = new CardChecker();
		WriteFile pS= new WriteFile();
		
			
		
		while(key){
			System.out.println("\n-------Login To Proceed Further-------\n");
			System.out.println("	Please Enter your Name: ");
			String userName=input.nextLine();
			System.out.println("	Please Enter your Pass: ");
			String userPass=input.nextLine();
			lI.GetinputUserName(userName);
			lI.GetinputPass(userPass);
			
			uL.UserLoginCheck(lI);
			if(uL.ReturnLogKey()){
				key=false;
			}
			else{
				System.out.println("\n WARNING!!! Please Enter Your CORRECT ID/Pass\n");
			}
			}
			if(uL.ReturnLogKey()){
				retLogKey =1;
				System.out.println("-----------User Loogged in-----------");
			}
			else{
				retLogKey = 2;
			}
			
			boolean newkey=true;
			while(newkey){
			switch(retLogKey){
				case 1:
					
					System.out.println("Welcome "+"'"+lI.ReturnInputUserName()+"'"+" To the SUPER VENDING MACHINE"+"\n");;
					System.out.println("What would you like to do today?");
					System.out.println("	1. Buy Products");
					System.out.println("	2. Show The Product List Only");
					System.out.println("	3. Remove Product");
					System.out.println("	4. Transaction");
					System.out.println("	5. Abous Us");
					System.out.println("	6. Exit The Program\n");
					System.out.println("Enter Your Choice Please:");
					int selection =input.nextInt();
					
					switch(selection){

						case 1:
							boolean buyFact = true;
							
							while(buyFact){
							System.out.println("\n-----Add Products to Cart-----\n");
							System.out.println("	1. Lux Soap: 100tk");
							System.out.println("	2. Clear Shampoo: 300tk");
							System.out.println("	3. Beverage: 50tk");
							System.out.println("	4. Tissue: 10tk");
							System.out.println("	5. Sharpe Blade: 90tk\n");
							System.out.println("	6. Want To Go back\n");
							System.out.println("Enter Your choice: ");
							String productName;
							double price;
							ProductInfo e = new ProductInfo();
							int buyNum=input.nextInt();
							
							switch(buyNum){
									case 1:
										System.out.print("Lux Soap");
										productName = "Lux Soap";							
										price = 100;
										e.setProduct(productName);
										e.setPrice(price);
										pS.InsertWrite(e);
										p.insertItem(e);
										break;
							
									case 2:
										System.out.print("Clear Shampoo");
										productName = "Clear Shampoo";
										price = 300;

										e.setProduct(productName);
										e.setPrice(price);
										pS.InsertWrite(e);
										p.insertItem(e);
										break;

							
									case 3:
										System.out.print("Beverage");
										productName = "Beverage";
										price = 50;
									
							
										e.setProduct(productName);
										e.setPrice(price);
										pS.InsertWrite(e);
										p.insertItem(e);
										break;

							
									case 4:
										System.out.print("Tissue");
										productName = "Tissue";
								
										price = 10;
							
										e.setProduct(productName);
										e.setPrice(price);
										pS.InsertWrite(e);
										p.insertItem(e);
										break;

							
									case 5:
										System.out.print("Sharpe Blade");
										productName = "Sharpe Blade";
								
										price = 90;
							
										e.setProduct(productName);
										e.setPrice(price);
										pS.InsertWrite(e);
										p.insertItem(e);
										break;


							
									case 6: 
											System.out.println("You have Selected to Go Back");
											buyFact=false;
											break;
											
									default:
											System.out.println("Invalid Input");
											break;
									}
									
									p.showAllItem();

								}

							break;
						
						case 2:
							if(p.ProductList()!=1){
								System.out.println("____FULL list of Your Shopping____");
								System.out.println("!!!NO PRODUCT Added Returning to Main Page!!");
								System.out.println("----------------------------------");
							}
							else{
								p.showAllItem();
							}
							
							break;
						case 3:
							
							Scanner x = new Scanner(System.in);
							System.out.println("What Product you would like to Remove\n");
							System.out.print("Enter Product Name: ");
							
							String productName = x.nextLine();
							p.removeItem(p.getItem(productName));
							pS.RemoveItem(pS.getrevItem(productName));
							p.showAllItem();

							
							break;
							
						case 4:
							if(p.ProductList()!=1){
								System.out.println("\n\n!!PLEASE Add Some Products BEFORE PAYING!!\n\n");
							}
							else{
								
								System.out.println("");
								System.out.println("-----Awesome Deal Get 10% off with Credit Card-----\n");
								System.out.println("The Totall Price is: "+p.calculate()+" taka");
								System.out.println("What kind of Transaction you would like?\n");
								System.out.println("	1. Credit Card");
								System.out.println("	2. Money");
								int choice = input.nextInt();
								
								if(choice==1){
									Scanner num = new Scanner(System.in);
									System.out.println("	Please Enter Card Number: ");
									String cardNum = num.nextLine();
									cCheck.userCardCheck(cardNum);
									if(cCheck.ReturnCardKey()){
										
										System.out.println("\n CONGRATULATIONS Your Card is Valid, Proceeding to paying\n");
										System.out.println("################################\n");
										System.out.println("Totall Price was:"+p.calculate()+" taka");
										System.out.println("Amount Paid with discount: "+ p.cardTransactions()+" taka");
										System.out.println("\n################################");
										

										System.out.println("Proceed For Printing Slip?\n");
										System.out.println("	1.Yes");
										System.out.println("	2.No");

										Scanner CHOICE = new Scanner(System.in);
										int printSlipChoice = CHOICE.nextInt();

										if(printSlipChoice==1){
											 
											 pS.Write1(lI.ReturnInputUserName(), p.calculate(), p.cardTransactions());
											 System.out.println("\n\nThank You For using The SUPER VENDING MACHINE Please Come Again\n");
			
										}
										else{
											System.out.println("\n\nThank You For using The SUPER VENDING MACHINE Please Come Again\n");
										}

									}
									else{
										System.out.println("Card Missmatch");
									}
								}
								else if(choice==2){
									System.out.println("How Much Amount you want to give: ");

									double money = input.nextDouble();
									if(money==p.calculate() || money>p.calculate()){
										money = money - p.calculate();
										System.out.println("");
										System.out.println("################################");
										System.out.println("You Paid: "+p.calculate()+" taka");
										System.out.println("Your Change is: "+money+" taka");
										System.out.println("################################\n");

										System.out.println("Proceed For Printing Slip?\n");
										System.out.println("	1.Yes");
										System.out.println("	2.No");

										Scanner CHOICEFORMONEY = new Scanner(System.in);
										int printSlipChoice = CHOICEFORMONEY.nextInt();



										if(printSlipChoice==1){
											 
											 pS.Write(lI.ReturnInputUserName(), p.calculate(), money);
											 System.out.println("\n\nThank You For using The SUPER VENDING MACHINE Please Come Again\n");
			
										}
										else{
											System.out.println("\n\nThank You For using The SUPER VENDING MACHINE Please Come Again\n");
										}
									}
									else{
										System.out.println("\nPLEASE Give the Tight Amount of Money\n");
									}
								
								}

								else{
									System.out.println("Invalid input");
								}
							}
							break;
			
						case 5:
							aboutUs.aboutUsMethod();
							System.out.println("\n");
							break;
						case 6:
							System.out.println("You Have choose to quit the program.");
							System.out.println("........Quitting........");
							newkey =  false;
							break;


						default:
							System.out.println("Invalid Input");
							break;
					}


					break;
				

				case 2:
					System.out.println("-----Wrong Input Please Try Again-----");
					break;
				default:
					System.out.println("Invalid Input");
			}
		}
	}
}


