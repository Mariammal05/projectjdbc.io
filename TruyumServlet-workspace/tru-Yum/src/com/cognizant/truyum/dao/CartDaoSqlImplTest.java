package com.cognizant.truyum.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImplTest {

	private static Scanner scan;

	public static void main(String args[]) throws IOException, ParseException, CartEmptyException {
		testAddCartItem(); 
		testRemoveCartItem();
		testAllCartItems();
		}
	public static void testAddCartItem()throws IOException,ParseException
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Enter the User Id to Add");
	long userId=Long.parseLong(bf.readLine());
		System.out.println("Enter the Cart Id to Add");
		long menuItemId=Long.parseLong(bf.readLine());
		new CartDaoSqlImpl().addCartItem(userId, menuItemId);
	}
public static void testAllCartItems()throws IOException,ParseException, CartEmptyException
	{
	     scan = new Scanner(System.in);
         System.out.println("Enter the USER ID: ");
        long userId = scan.nextLong();
        Cart cart=new CartDaoSqlImpl().getAllCartItems(userId);
        double total = cart.getTotal();
        List<MenuItem> menu_item = cart.getMenuItemList();
        DecimalFormat df = new DecimalFormat("##,###.00");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.format("\n%15s%15s%15s%15s%15s%15s%15s\n","ID", "NAME", "PRICE", "	 DATE OF LAUNCH", "ACTIVE", "CATEGORY",
                "	FREE DELIVERY");
        
        for(MenuItem menu_Item : menu_item) {
        String freeDelivery=menu_Item.getFreeDelivery() ? "yes" : "no";	
        String active = menu_Item.getActive() ? "yes" : "no";
        System.out.format("\n%15s%15s%15s%15s%15s%15s%15s\n",menu_Item.getId(),menu_Item.getName(),df.format(menu_Item.getPrice()),sdf.format(menu_Item.getDateOfLaunch()),
                active,menu_Item.getCategory(),freeDelivery);
        	
        }
        System.out.println("Total  ----------->>   "+total);

    } 

	public static void testRemoveCartItem()throws IOException,ParseException
	
	{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the User Id to Delete");
		long userId=Long.parseLong(bf.readLine());
			System.out.println("Enter the Cart Id to Delete");
			long menuItemId=Long.parseLong(bf.readLine());
			new CartDaoSqlImpl().removeCartItem(userId, menuItemId);
	}
	
}
