package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImpl implements MenuItemDao{
	
		public static final String GET_ALL_MENUITEM_ADMIN="select * from menu_item";
		
		
		public  ArrayList<MenuItem> getMenuItemListAdmin(){
			ArrayList<MenuItem> menuItemList=new ArrayList<>();
			Connection connection = ConnectionHandler.getConnection();
			PreparedStatement preparedStatement=null;
			try {
				preparedStatement = connection.prepareStatement(GET_ALL_MENUITEM_ADMIN);
				ResultSet resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					MenuItem menu_item=new MenuItem();
					menu_item.setId(resultSet.getLong("me_id"));
					menu_item.setName(resultSet.getString("me_name"));
					menu_item.setPrice(resultSet.getFloat("me_price"));
					menu_item.setDateOfLaunch(resultSet.getDate("me_date_of_Launch"));
					menu_item.setActive(resultSet.getString("me_active").equals("yes"));
					menu_item.setCategory(resultSet.getString("me_category"));
					menu_item.setFreeDelivery((resultSet).getString("me_free_delivery").equals("yes"));
					menuItemList.add(menu_item);
				}
			}
				catch(SQLException e) {
					e.printStackTrace();
				}
		finally {
			try {
			     if(preparedStatement != null) {
			    	 preparedStatement.close();
			     }
			     if(connection != null) {
			    	 connection.close();
			     }
						}catch(SQLException e) {
			}
		}
			
			return menuItemList;
		}


	
		
		public static final String GET_ALL_MENUITEM_CUSTOMER="SELECT * FROM truyum.menu_item where me_date_of_launch > curdate() and  me_active = 'yes';";
		public ArrayList<MenuItem> getMenuItemListCustomer() {
			ArrayList<MenuItem>menuItemList=new ArrayList<>();
			Connection connection = ConnectionHandler.getConnection();
			PreparedStatement preparedStatement=null;
			try {
				preparedStatement = connection.prepareStatement(GET_ALL_MENUITEM_CUSTOMER);
				ResultSet resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					MenuItem menu_item=new MenuItem();
					menu_item.setId(resultSet.getLong("me_id"));
					menu_item.setName(resultSet.getString("me_name"));
					menu_item.setPrice(resultSet.getFloat("me_price"));
					menu_item.setDateOfLaunch(resultSet.getDate("me_date_of_Launch"));
					menu_item.setActive(resultSet.getString("me_active").equals("yes"));
					menu_item.setCategory(resultSet.getString("me_category"));
					menu_item.setFreeDelivery((resultSet).getString("me_free_delivery").equals("yes"));
					menuItemList.add(menu_item);
				}
			}
				catch(SQLException e) {
					e.printStackTrace();
				}
		finally {
			try {
			     if(preparedStatement != null) {
			    	 preparedStatement.close();
			     }
			     if(connection != null) {
			    	 connection.close();
			     }
						}catch(SQLException e) {
			}
		}
			
			return menuItemList;
		}
			
			
	
		public static final String MODIFY_MENU_ITEM="update truyum.menu_item set me_name=?,me_price=?,me_active=?,me_date_of_Launch=?,me_category=?,me_free_delivery=? where me_id=?;";
		public void modifyMenuItems(MenuItem menuItem) {
			Connection connection = ConnectionHandler.getConnection();
			PreparedStatement preparedStatement=null;
			try {
				preparedStatement=connection.prepareStatement(MODIFY_MENU_ITEM);
				preparedStatement.setString(1, menuItem.getName());
				preparedStatement.setFloat(2,menuItem.getPrice());
				preparedStatement.setString(3,menuItem.getActive() ?"yes":"no");
				preparedStatement.setDate(4,new DateUtil().convertToSqlDate(menuItem.getDateOfLaunch()));
				preparedStatement.setString(5,menuItem.getCategory());
				preparedStatement.setString(6,menuItem.getFreeDelivery() ?"yes":"no");
				//preparedStatement.setString(6,menuItem.getFreeDelivery()?"yes":"no");
				preparedStatement.setLong(7,menuItem.getId());
				preparedStatement.executeUpdate();
				
			}catch (SQLException e) {
				
				e.printStackTrace();
		}
			finally {
				try {
				     if(preparedStatement != null) {
				    	 preparedStatement.close();
				     }
				     if(connection != null) {
				    	 connection.close();
				     }
							}catch(SQLException e) {
				}
			}
				
			}



		public static final String GET_MENU_ITEM="SELECT * FROM truyum.menu_item where me_id = ?;";
		public MenuItem getMenuItem(Long menuItemId) {
			Connection connection = ConnectionHandler.getConnection();
			PreparedStatement preparedStatement=null;
			ResultSet resultset = null;
			MenuItem menu_item =null;
			try {
				preparedStatement = connection.prepareStatement(GET_MENU_ITEM);
				preparedStatement.setLong(1,menuItemId);
				ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				menu_item = new MenuItem();
				menu_item.setId(resultSet.getLong("me_id"));
				menu_item.setName(resultSet.getString("me_name"));
				menu_item.setPrice(resultSet.getFloat("me_price"));
				menu_item.setDateOfLaunch(resultSet.getDate("me_date_of_Launch"));
				menu_item.setActive(resultSet.getString("me_active").equals("yes"));
				menu_item.setCategory(resultSet.getString("me_category"));
				menu_item.setFreeDelivery((resultSet).getString("me_free_delivery").equals("yes"));
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
	finally {
		try {
		     if(resultset != null) {
		    	 resultset.close();
		     }
		     if(preparedStatement != null) {
		    	 preparedStatement.close();
		     }
		     if(connection != null) {
		    	 connection.close();
		     }
					}catch(SQLException e) {
		}
	}
		
		return menu_item;
						
}
}
