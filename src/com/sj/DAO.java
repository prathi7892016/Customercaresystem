package com.sj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAO {
Connection con;
Statement stmt;
PreparedStatement pstmt;
ResultSet rsltst;
public DAO() {
	super();
	con= new DBConnector().getConn();
}
public List<Customer>viewAllCustomer(){
	try {
		stmt= con.createStatement();
		rsltst= stmt.executeQuery("select*from customer");
		List<Customer>clist = new ArrayList<Customer>();
		while(rsltst.next()) {
			Person p= new Person(); 
			p.id= rsltst.getInt(1);
			p.name= rsltst.getString(2);
			clist.add(p);
		
		}
		return clist;
	}catch(SQLException e) {
		e.printStackTrace();
		
	}
	return null;
}
public List<Complaint> viewComplaintsById(int id){
	try {
		pstmt= con.prepareStatement("select *from customer where customerid=?");
			pstmt.setInt(1, id);
			ResultSet rsltst= pstmt.executeQuery();
			boolean b=rsltst.next();
			if(b) {
				pstmt=con.prepareStatement("select *from complaint where customerid=?");
				pstmt.setInt(1, id);
				rsltst=pstmt.executeQuery();
				 List<Complaint> clist= new ArrayList<Complaint>();
				 while(rsltst.next()) {
					 Complaint c= new Complaint();
					 c.cid=rsltst.getInt(1);
					 c.title=rsltst.getString(2);
					 c.description=rsltst.getString(3);
					 c.status=rsltst.getInt(4);
					 c.customerId=rsltst.getInt(5);
					 clist.add(c);
				 }
				 return clist;
			}
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return null;
}
public Complaint viewComplaintStatus(int id){
	try {
		pstmt= con.prepareStatement("select *from complaint where cid=?");
			pstmt.setInt(1, id);
			ResultSet rsltst= pstmt.executeQuery();
			 while(rsltst.next()) {
				 Complaint c= new Complaint();
				 c.cid=rsltst.getInt(1);
				 c.title=rsltst.getString(2);
				 c.description=rsltst.getString(3);
				 c.status=rsltst.getInt(4);
				 c.customerId=rsltst.getInt(5);
				return c;
			 }
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return null;
}
public boolean registerNewComplaint(Person p){
	try {
		pstmt= con.prepareStatement("insert into customer values=(?,?");
			pstmt.setInt(1, p.id);
			pstmt.setString(2, p.name);
			pstmt.execute();
			
			
				PreparedStatement pstmt1=con.prepareStatement("insert into complaint values(?,?,?,?,?)");
				pstmt1.setInt(1, p.c.cid);
				pstmt1.setString(2, p.c.title);
				pstmt1.setString(3, p.c.description);
				pstmt1.setInt(4,1);
				pstmt1.setInt(5, p.c.customerId);
				pstmt1.execute();
				return true;
	}
	catch(SQLException e) {
		e.printStackTrace();
		return false;
	}
}
			
public boolean registerComplaintWithOldUser(Person p){
	try {
		pstmt= con.prepareStatement("select *from complaint where cid=?");
			pstmt.setInt(1, p.id);
			ResultSet r= pstmt.executeQuery();
			boolean b= r.next();
			if(b) {
			
				PreparedStatement pstmt1=con.prepareStatement("insert into complaint values(?,?,?,?,?)");
				pstmt1.setInt(1, p.c.cid);
				pstmt1.setString(2, p.c.title);
				pstmt1.setString(3, p.c.description);
				pstmt1.setInt(4,1);
				pstmt1.setInt(5, p.c.customerId);
				pstmt1.execute();
				return true;
	}
			else {
				return false;
			}
	}catch(SQLException e) {
		e.printStackTrace();
		return false;
	}
}
}