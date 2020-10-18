package com.sj;

import java.util.List;

public interface Customer {

	public abstract List<Customer> viewAllCustomer();

	public abstract List<Complaint> viewComplaintByID(int id);
public abstract Complaint viewComplaintStatus(int id);
public abstract boolean launchComplaintWithExistingUser(Person p);
public abstract boolean launchComplaintWithOldUser(Person p);
}
