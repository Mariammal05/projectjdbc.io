package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImpl implements CartDao{

	
	public static final String ADD_MENUITEM_TO_CART="Insert into `truyum`.`cart`(ct_us_id,ct_me_id) values(?,?);";
	public void addCartItem(long userId, long menuItemId) {
		 Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement= null;
		 try {
			 statement = connection.prepareStatement(ADD_MENUITEM_TO_CART);
			 statement.setLong(1,userId);
			 statement.setLong(2,menuItemId);
			 int noOfRows = statement.executeUpdate();
			 System.out.println("Number of Rows Affected -> " + noOfRows);
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }finally {
				try {
					statement.close();
					connection.close();
				}catch (SQLException e) {
					System.out.println("Unable to connect with database");
				}
			}
		
	}

	public static final String GET_CART_ITEM="select * from truyum.menu_item inner join  truyum.cart on ct_me_id=me_id\r\n" + 
			"where  ct_us_id=?";
	public static final String GET_TOTAL="select sum(me_price) as total from truyum.menu_item inner join truyum.cart \r\n" + 
			"on   ct_me_id=me_id\r\n" + 
			"where  ct_us_id=?;";
	
	public Cart getAllCartItems(long userId) throws CartEmptyException {
		ArrayList<MenuItem> menuItemList=new ArrayList<>();      
		Connection  connection = ConnectionHandler.getConnection();
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatementTotal = null;
		ResultSet resultset = null;
        ResultSet resultSetTotal = null;
        MenuItem menuItem=null;
        Cart cart=new Cart();
        try {
        preparedStatement=connection.prepareStatement(GET_CART_ITEM);
        preparedStatement.setLong(1, userId);
        resultset=preparedStatement.executeQuery();
        
            while(resultset.next()) {
                 
                 menuItem=new MenuItem();
                 menuItem.setId(resultset.getLong("me_id"));
                 menuItem.setName(resultset.getString("me_name"));
                 menuItem.setPrice(resultset.getFloat("me_price"));
                menuItem.setActive(resultset.getString("me_active").equals("1"));
                menuItem.setDateOfLaunch(resultset.getDate("me_date_of_launch"));
                 menuItem.setCategory(resultset.getString("me_category"));
            menuItem.setFreeDelivery(resultset.getString("me_free_delivery").equals("1"));
                 menuItemList.add(menuItem);
            }
            if(menuItemList.size()==0) {
                 throw new CartEmptyException();
            }
            cart.setMenuItemList(menuItemList);
            preparedStatementTotal=connection.prepareStatement(GET_TOTAL);
            preparedStatementTotal.setLong(1, userId);
           resultSetTotal = preparedStatementTotal.executeQuery();
           double total=0.0;
           while (resultSetTotal.next()) {
                total = resultSetTotal.getDouble("total");
              //  System.out.println("------------Total--------------  ="+total);
           }
           cart.setTotal(total);
        }catch(SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                 if(resultset != null) {
                      resultset.close();
                 }
                 if(preparedStatement != null)    {
                 preparedStatement.close();
                 }
                 if(connection !=null) {
         			connection.close();
         			}
            }catch(SQLException e) {
                 
            }
        }
        return cart; 
	}  
 

		

	public static final String DELETE_MENUITEM_TO_CART="delete from truyum.cart where ct_us_id=? and ct_me_id=? limit 1;";
	public void removeCartItem(long userID, long menuItemId) {
		 Connection connection = ConnectionHandler.getConnection();
			PreparedStatement statement= null;
			 try {
				 statement = connection.prepareStatement(DELETE_MENUITEM_TO_CART);
				 statement.setLong(1,userID);
				 statement.setLong(2,menuItemId);
				 int noOfRows = statement.executeUpdate();
				 System.out.println("Number of Rows Affected -> " + noOfRows);
			 }catch(SQLException e) {
				 e.printStackTrace();
			 }finally {
					try {
						statement.close();
						connection.close();
					}catch (SQLException e) {
						System.out.println("Unable to connect with database");
					}
				}
		
		
	}

}
