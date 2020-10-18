package com.sj;

public class Complaint {

public int cid;
public String title;
public String description;
public int status;
public int customerId;

public Complaint() {
	super();
	this.cid = cid;
	this.title = title;
	this.description = description;
	this.status = status;
	this.customerId = customerId;
}
public Complaint(int ocid1, String otitle, String odescription, String i, int oid) {
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Complaint [cid=" + cid + ", title=" + title + ", description=" + description + ", status=" + status
			+ ", customerid=" + customerId + "]";
}

}
