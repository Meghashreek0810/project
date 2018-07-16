package com.cg.pwa.db;

import java.util.HashMap;

import com.cg.pwa.bean.Account;

public class AccountDb {
	
	private static HashMap<String,Account> account=new HashMap<String,Account>();
	public static HashMap<String,Account> accountDb(){
		return account;
	}
	
	static{
		account.put("9945876321", new Account("lucy","9945876321","lucy@gmail.com",7000));
		account.put("9535597905", new Account("john","9535597905","john@gmail.com",1000));
		account.put("9987698536", new Account("ram","9987698536","ram@gmail.com",2500));
		account.put("8763549869", new Account("sarah","8763549869","sarah@gmail.com",5000));
		
	}

}
