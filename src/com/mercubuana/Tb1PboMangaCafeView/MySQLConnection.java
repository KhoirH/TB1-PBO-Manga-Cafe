package com.mercubuana.Tb1PboMangaCafeView;

//Step 1: Use interfaces from java.sql package 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnection {
  //static reference to itself
  private static MySQLConnection instance = new MySQLConnection();
  public static final String URL = "jdbc:mysql://localhost:3306/manga_cafe";
  public static final String USER = "root";
  public static final String PASSWORD = "";
  public static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver"; 
   
  //private constructor
  private MySQLConnection() {
      try {
          //Step 2: Load MySQL Java driver
          Class.forName(DRIVER_CLASS);
      } catch (ClassNotFoundException e) {
          e.printStackTrace();
      }
  }
   
  private Connection createConnection() {

      Connection connection = null;
      try {
          //Step 3: Establish Java MySQL connection
          connection = DriverManager.getConnection(URL, USER, PASSWORD);
      } catch (SQLException e) {
          System.out.println("ERROR: Unable to Connect to Database.");
      }
      return connection;
  }   
   
  public static Connection getConnection() {
      return instance.createConnection();
  }
  
  public static ResultSet SelectData(String query) {
	  ResultSet rs = null;
		try {
			Statement statement = instance.createConnection().createStatement();
	        rs = statement.executeQuery(query);
		} catch (SQLException e) {
	          System.out.println("ERROR: " + e.toString() );
		}        
        return rs;
  }
  
  public static int executeUpdate(String query) {
	  int rs = 0;
		try {
			Statement statement = instance.createConnection().createStatement();
	        rs = statement.executeUpdate(query);
		} catch (SQLException e) {
	          System.out.println("ERROR: " + e.toString() );
		}        
        return rs;
  }
}