package com.sj;

public class DataBase {
	Customer [] customerDB;

public DataBase() {
		
	Complaint [] c1= {new Complaint(1,"t1","d1","0",1), new Complaint(2,"t2","d2","0",1),new Complaint(3,"t3","d3","0",1)};
	
	Complaint [] c2= {new Complaint(14,"t14","d14","0",2), new Complaint(22,"t22","d22","0",2)};
	
	Complaint [] c3= {new Complaint(16,"t16","d16","0",4)};
	

customerDB= new Customer[3];
customerDB[0]= new Person(1,"name1",c1);
customerDB[1]= new Person(2,"name2",c2);
customerDB[2]= new Person(3,"name3",c3);

}
}
