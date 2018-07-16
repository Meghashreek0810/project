package com.cg.pwa.dao;

import java.util.HashMap;

import com.cg.pwa.bean.Account;
import com.cg.pwa.db.AccountDb;
import com.cg.pwa.exception.AccountException;

public class AccountDao implements IAccountDao {

	static HashMap<String, Account> accMap = AccountDb.accountDb();

	@Override
	public Account createAccount(Account acc) throws AccountException {
		Account acc1 = accMap.put(acc.getMobileNo(), acc);

		return acc1;
	}

	@Override
	public double showBalance(String mobileNo) throws AccountException {
		Account acc = accMap.get(mobileNo);
		if (accMap.get(mobileNo) == null) {
			throw new AccountException("account doesnot exists");
		}

		return acc.getBalance();

	}

	@Override
	public double depositAmount(String mobileNo, double depositAmount)
			throws AccountException {
		Account acc = accMap.get(mobileNo);
		if (accMap.get(mobileNo) == null) {
			throw new AccountException("account doesnot exists");
		}
		double balanceAmount = acc.getBalance() + depositAmount;
		acc.setBalance(balanceAmount);
		return balanceAmount;
	}

	@Override
	public double withdrawAmount(String mobileNo, double withdrawAmount)
			throws AccountException {
		Account acc = accMap.get(mobileNo);
		if (accMap.get(mobileNo) == null) {
			throw new AccountException("account doesnot exists");

		} else if (withdrawAmount > acc.getBalance()) {
			throw new AccountException(
					"enter withdraw amount less than available balance");
		}

		double balanceAmount = acc.getBalance() - withdrawAmount;
		acc.setBalance(balanceAmount);
		return balanceAmount;
	}

	@Override
	public double fundTransfer(String mobileNo1, String mobileNo2, double amount)
			throws AccountException {

		double balance1 = withdrawAmount(mobileNo1, amount);
		depositAmount(mobileNo2, amount);

		return balance1;
	}

	@Override
	public Account printTransaction(String mobileNo) throws AccountException {

		Account account = accMap.put(mobileNo, accMap.get(mobileNo));
		if (account == null) {
			throw new AccountException("account doesnot exists");
		}

		return account;
	}
	
	
}
