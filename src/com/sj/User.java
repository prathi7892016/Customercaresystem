package com.sj;

import java.util.List;
import java.util.Scanner;

public class User {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Customer per=new Person();
Scanner sc=new Scanner(System.in);
char h;
char cr;
do {
	System.out.println("press 1 to view all the customers by keyid");
	System.out.println("press 2 to select a customer by keyid to view all the complaints");
	System.out.println("press 3 to select a complaint to view its status ");
	System.out.println("press 4 to register a new complaint with new user");
	System.out.println("press 5 to register a new complaint with existing user");
int choice=sc.nextInt();
switch(choice){
	case 1:
		List<Customer> clist=per.viewAllCustomer();
		for(Customer c:clist) {
			System.out.println(((Person)c).id+" "+((Person)c).name);
		}
	break;
	case 2:
		System.out.println("enter the keyid");
		int id= sc.nextInt();
		List<Complaint> list=per.viewComplaintByID(id);
		for(Complaint com : list) {
			System.out.println(com.cid+" "+com.title+" "+com.description+" "+com.status+" "+com.customerId+" ");
		}
		break;
	case 3:
		System.out.println("enter the complaint id");
		int cid= sc.nextInt();
		
		
		Complaint comp=per.viewComplaintStatus(cid);
		if(comp.status==0) {
			System.out.println("your complaint title is"+comp.title+" and your Complaint status is "+comp.status);
		}
					else{
					System.out.println("your complaint title is"+comp.title+" and your Complaint status is "+comp.status);
					}
							
							break;
					case 4:
						System.out.println("enter the id");
						int id2=sc.nextInt();
						System.out.println("enter customer name");
						String name=sc.next();
						System.out.println("enter the complaintid");
						int cid1=sc.nextInt();
						System.out.println("enter title");
						String title=sc.next();
						System.out.println("enter description");
						sc.nextLine();
						String description=sc.next();
						Complaint com= new Complaint();
						Person p=new Person(id2,name,com);
						boolean b=per.launchComplaintWithExistingUser(p);
						if(b) {
							System.out.println("complaint registered");
						}else {
							System.out.println("some issue");
						}
						break;
					case 5:
						System.out.println("enter the id");
						int oid=sc.nextInt();
						System.out.println("enter customer name");
						String oname=sc.next();
						System.out.println("enter the complaintid");
						int ocid1=sc.nextInt();
						System.out.println("enter title");
						String otitle=sc.next();
						System.out.println("enter description");
						sc.nextLine();
						String odescription=sc.next();
						Complaint ocom=new Complaint();
						Person op=new Person(oid,oname,ocom);
						boolean b1=per.launchComplaintWithExistingUser(op);
						if(b1) {
							System.out.println("complaint registered");
						}else {
							System.out.println("some issue");
						}
						break;
						default:
							break;
							
}
		
		System.out.println("press y for main menu");
		cr=sc.next().charAt(0);
}while(cr== 'Y'||cr == 'y');

}
		}


	

	

