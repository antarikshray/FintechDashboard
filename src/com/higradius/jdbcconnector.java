package com.higradius;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbcconnector{
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/highradius";
	// Database credentials
	static final String USER = "root";
	static final String PASS = "";
	public static void main(String[] args) {
	Connection conn = null;
	Statement stmt = null;
	try{
	//STEP 2: Register JDBC driver
	Class.forName("com.mysql.jdbc.Driver");
	//STEP 3: Open a connection
	conn = DriverManager.getConnection(DB_URL,USER,PASS);
	//STEP 4: Execute a query
	stmt = conn.createStatement();
	String sql;
	sql = "SELECT * FROM predictedTable";
	ResultSet rs = stmt.executeQuery(sql);

	//STEP 5: Extract data from result set
	while(rs.next()){
	//Retrieve by column name
	float invoice_id = rs.getFloat("invoice_id");
	String name_customer = rs.getString("name_customer");
	float first = rs.getFloat("total_open_amount");
//	String last = rs.getSt("due_in_date");
	//Display values
	System.out.print("ID: " + invoice_id);
	System.out.print(", Age: " + name_customer);
	System.out.print(", First: " + first);
//	System.out.println(", Last: " + last);
	}
	//STEP 6: Clean-up environment
	rs.close();
	stmt.close();
	conn.close();
	}catch(SQLException se){
	//Handle errors for JDBC
	se.printStackTrace();
	}catch(Exception e){
	//Handle errors for Class.forName
	e.printStackTrace();
	}finally{
	//finally block used to close resources
	try{
	if(stmt!=null)
	stmt.close();
	}catch(SQLException se2){
	}// nothing we can do
	try{
	if(conn!=null)
	conn.close();
	}catch(SQLException se){
	se.printStackTrace();
	}
	}
	System.out.println("Goodbye!");
	}
	}
