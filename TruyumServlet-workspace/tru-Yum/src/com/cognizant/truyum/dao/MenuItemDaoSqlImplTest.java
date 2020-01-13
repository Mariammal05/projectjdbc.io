package com.cognizant.truyum.dao;

//import java.sql.Connection;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {

	public static void display(List<MenuItem>menuItemList) {
		DecimalFormat df = new DecimalFormat("##,###.00");
		 SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		 System.out.format("\n%15s%15s%15s%15s%15s%15s%15s\n","ID", "NAME", "PRICE", "	 DATE OF LAUNCH", "ACTIVE", "CATEGORY",
                 "	FREE DELIVERY");
          for (MenuItem menu_item : menuItemList) {
        	  String freeDelivery=menu_item.getFreeDelivery() ? "yes" : "no";	
		        String active = menu_item.getActive() ? "yes" : "no";

    System.out.format("\n%15s%15s%15s%15s%15s%15s%15s\n",menu_item.getId(),menu_item.getName(),df.format(menu_item.getPrice()),sdf.format(menu_item.getDateOfLaunch()),
             active,menu_item.getCategory(),freeDelivery);
           }
	}
	
	
		 public static void testGetMenuItemListAdmin() {		 
	
	 ArrayList<MenuItem> menuItemListAdmin = new MenuItemDaoSqlImpl().getMenuItemListAdmin();
	 System.out.println("ADMIN");
	   display(menuItemListAdmin) ;
	 }
		 public static void testGetMenuItemListCustomer() {	
			 ArrayList<MenuItem> menuItemListCustomer = new MenuItemDaoSqlImpl().getMenuItemListCustomer();
			 System.out.println("Customer");
			 display(menuItemListCustomer);
		     }
		 public static void testGetModifyMenuItemList() {	
		
			
			 MenuItem menuItem = new MenuItem(1L,"Gulab",156.23f,true,new DateUtil().convertToDate("15/03/2017"),"Dessert",true);
			new MenuItemDaoSqlImpl().modifyMenuItems(menuItem);
			 System.out.println("MODIFIED");
			 testGetMenuItemListAdmin();
		   
		 }
		 public static void testGetMenuItemList() {	
			 long menuItemId = 3;
			 MenuItem menu_item = new MenuItemDaoSqlImpl().getMenuItem(menuItemId);
			 DecimalFormat df = new DecimalFormat("##,###.00");
			 SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
			 System.out.format("\n%15s%15s%15s%15s%15s%15s%15s\n","ID", "NAME", "PRICE", "	 DATE OF LAUNCH", "ACTIVE", "CATEGORY",
	                 "	FREE DELIVERY");
			 String freeDelivery=menu_item.getFreeDelivery() ? "yes" : "no";	
		        String active = menu_item.getActive() ? "yes" : "no";
	    System.out.format("\n%15s%15s%15s%15s%15s%15s%15s\n",menu_item.getId(),menu_item.getName(),df.format(menu_item.getPrice()),sdf.format(menu_item.getDateOfLaunch()),
	             active,menu_item.getCategory(),freeDelivery);
			 
		 }
		 public static void main(String args[]) {
			 
			// Connection connection = ConnectionHandler.getConnection();
			
			testGetMenuItemListAdmin();
			testGetMenuItemListCustomer();
			testGetModifyMenuItemList();
			testGetMenuItemList();
		 }
}
