package com.codegnan.cards;

import java.util.ArrayList;
import java.util.Collections;

import com.codegnan.customExceptions.InsufficientBalanceException;
import com.codegnan.customExceptions.InsufficientMachineBalanceException;
import com.codegnan.customExceptions.InvalidAmountException;
import com.codegnan.customExceptions.NotAOperatorException;

import Interfaces.IATMService;

public class SBIDebitCard implements IATMService {
	String name;
	long debitCardNumber;
	double accountBalance;
	int pinNumber;
	ArrayList<String> statement;
	final String type = "user";
	int chances;

	public SBIDebitCard(long debitCardNumber, String name, double accountBalance, int pinNumber) {
		chances = 3;
		this.name = name;
		this.accountBalance = accountBalance;
		this.pinNumber = pinNumber;
		statement = new ArrayList<>();
	}

	public String getUserType() throws NotAOperatorException {
// TODO Auto-generated method stub
		return type;
	}

	public double withdrawAmount(double wthAmount)
			throws InvalidAmountException, InsufficientBalanceException, InsufficientMachineBalanceException {
		if (wthAmount <= 0) {
			throw new InvalidAmountException("You can Enter Zero(0)amount to withdraw. please enter valid amount");
		} else if (wthAmount % 10 != 0) {
			throw new InsufficientBalanceException("Please Withdraw Multiples of 100");
		} else if (wthAmount < 500) {
			throw new InsufficientBalanceException("Please Withdraw More Than 500");
		} else if (wthAmount > accountBalance) {
			throw new InsufficientBalanceException(
					"you don:t have sufficient balance to withdraw.. Please check your balanace");
		} else {
			accountBalance = accountBalance - wthAmount;
			statement.add("Debited : " + wthAmount);
			return wthAmount;
		}
	}

	public void depositAmount(double dptAmount) throws InvalidAmountException {
		if (dptAmount <= 0 || dptAmount % 10 != 0) {
			throw new InvalidAmountException("Please Deposit Multiples of 10");
		} else {
			accountBalance = accountBalance + dptAmount;
			statement.add("Creadited : " + dptAmount);
		}
	}

	public double checkAccountBalance() {
// TODO Auto-generated method stub
		return accountBalance;
	}

	public void changePinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
	}

	public int getPinNumber() {
		return pinNumber;
	}

	public String getUserName() {
		return name;
	}

	public void decreaseChances() {
		--chances;
	}

	public int getChances() {
		return chances;
	}

	public void resetPinChances() {
		chances = 3;
	}

	public void generateMiniStatement() {
		int count = 5;
		if (statement.size() == 0) {
			System.out.println("There are no Transactions Happend");
			return;
		}
		System.out.println("================List 5 Transactions========================");
		Collections.reverse(statement);
		for (String trans : statement) {
			if (count == 0) {
				break;
			}
			System.out.println(trans);
			count--;
		}
		Collections.reverse(statement);
	}
}
