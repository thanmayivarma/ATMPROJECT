package Interfaces;

import com.codegnan.customExceptions.InsufficientBalanceException;
import com.codegnan.customExceptions.InsufficientMachineBalanceException;
import com.codegnan.customExceptions.InvalidAmountException;
import com.codegnan.customExceptions.NotAOperatorException;
public interface IATMService {
		 // to get the user type.weather the user is operator or normal user.
		 public abstract String getUserType() throws NotAOperatorException;
		 // To WithdrawAmount
// 1)will throw InvalidAmountException if the amount is not valid denomination
// 2) will throw insufficient balance Exception if the customer has insufficient
// amount in his/her account
// 3)will throw insufficient machine balance exception if the machine has in
// sufficient cash.
		public abstract double withdrawAmount(double wthAmount)
		 throws InvalidAmountException, InsufficientBalanceException,
		 InsufficientMachineBalanceException;
		 // to deposit amount
		 public abstract void depositAmount(double dptAmount) throws
		 InvalidAmountException;
		 // to check AccountBalance
		 public abstract double checkAccountBalance();
		 // to change PIN Number
		 public abstract void changePinNumber(int pinNumber);
		 // to get the PIN number
		 public abstract int getPinNumber();
		 // to get the userName
		 public abstract String getUserName();
		// to decrease the number of chances while enter the wrong pin number
		 public abstract void decreaseChances();
		 // to get the Chances of PIN Number
		 public abstract int getChances();
		 // to reset the pin number chances by the bank Operator.
		 public abstract void resetPinChances();
		 // to get the miniStatement of an account
		 public abstract void generateMiniStatement();

	}

