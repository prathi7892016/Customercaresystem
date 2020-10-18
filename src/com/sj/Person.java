package com.sj;


	import java.util.List;

	public class Person implements Customer {
		
		public int id;
		public String name;
		public Complaint c;
		
		
	public Person(int i, String name, Complaint c1) {
		super();
		}
	DAO dao= new DAO();
	public Person() {
		super();
		this.id = id;
		this.name = name;
		this.c = c;
	}
	public Person(int i, String name2, Complaint[] c1) {
		// TODO Auto-generated constructor stub
	}
	public List<Customer>viewAllCustomer(){
		List<Customer> list=dao.viewAllCustomer();
		return list;
	}
	public List<Complaint>viewComplaintById(int id){
		System.out.println("here");
	List<Complaint> list=dao.viewComplaintsById(id);
	return list;
	}
	public Complaint viewComplaintStatus(int id){
		Complaint cmp=dao.viewComplaintStatus(id);
	return cmp;
	}
	
	public boolean launchComplaintWithExistingUser(Person p) {
	boolean b=dao.registerNewComplaint(p);
	return b;
	}
	
	public boolean launchComplaintWithOldUser(Person p) {
		boolean b=dao.registerComplaintWithOldUser(p);
		return b;
		}
		


	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", c="+c;
	}
	@Override
	public List<Complaint> viewComplaintByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	}


