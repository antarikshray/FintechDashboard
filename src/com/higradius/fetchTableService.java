package com.higradius;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.higradius.PredictedTable;

public class fetchTableService {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/highradius";
	
	static final String USER = "root";
	static final String PASS = "";
	
	public List<PredictedTable> getAllTables(){
		Connection conn = null;
		Statement stmt = null;
		
		List <PredictedTable> fetchedTable = new ArrayList<PredictedTable>();
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM PredictedTablef");
			
			while(rs.next()) {
				PredictedTable tabl = new PredictedTable();
				tabl.setKey_0(rs.getInt("key_0"));
				tabl.setName_customer(rs.getString("name_customer"));
				tabl.setCust_number(rs.getString("cust_number"));
				tabl.setInvoice_id(rs.getDouble("invoice_id"));
				tabl.setTotal_open_amount(rs.getDouble("total_open_amount"));
				tabl.setDue_in_date(rs.getDate("due_in_date"));
				tabl.setPredicted_payment_date(rs.getDate("predicted_payment_date"));
				fetchedTable.add(tabl);
			}
			
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}
			try{
				if(conn!=null)
				conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
		return fetchedTable;
	}
	
	public List<PredictedTable> getonInvoiceID(double invoiceId){
		Connection conn = null;
		Statement stmt = null;
		
		List <PredictedTable> fetchedTable = new ArrayList<PredictedTable>();
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			
			stmt = conn.createStatement();
			String query = "SELECT * FROM PredictedTablef where invoice_id =" + invoiceId;
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				PredictedTable tabl = new PredictedTable();
				tabl.setKey_0(rs.getInt("key_0"));
				tabl.setName_customer(rs.getString("name_customer"));
				tabl.setCust_number(rs.getString("cust_number"));
				tabl.setInvoice_id(rs.getDouble("invoice_id"));
				tabl.setTotal_open_amount(rs.getDouble("total_open_amount"));
				tabl.setDue_in_date(rs.getDate("due_in_date"));
				tabl.setPredicted_payment_date(rs.getDate("predicted_payment_date"));
				fetchedTable.add(tabl);
			}
			
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}
			try{
				if(conn!=null)
				conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
		return fetchedTable;
	}
}
