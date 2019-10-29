package org.drools.shihu.learn.rules.lhs;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	
	private String name;
	
	private String city;
	
	private List<Account> accounts = new ArrayList<>();

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	

}
