package com.codegnan.cards;

import com.codegnan.customExceptions.InsufficientBalanceException;
import com.codegnan.customExceptions.InsufficientMachineBalanceException;
import com.codegnan.customExceptions.InvalidAmountException;
import com.codegnan.customExceptions.NotAOperatorException;

import Interfaces.IATMService;
public class OperatorCard implements IATMService {
private int pinNumber;
private long id;
private String name;
private final String type = "operator";
public OperatorCard(long idn, int pin, String name) {
id = idn;
pinNumber = pin;
this.name = name;
}
@Override
public String getUserType() throws NotAOperatorException {
// TODO Auto-generated method stub
return type;
}
@Override
public double withdrawAmount(double wthAmount)
throws InvalidAmountException, InsufficientBalanceException,
InsufficientMachineBalanceException {
return 0;
}
@Override
public void depositAmount(double dptAmount) throws
InvalidAmountException {
}
@Override
public double checkAccountBalance() {
return 0;
}
@Override
public void changePinNumber(int pinNumber) {
}
@Override
public int getPinNumber() {
return pinNumber;
}
@Override
public String getUserName() {
return name;
}
@Override
public void decreaseChances() {
// TODO Auto-generated method stub
}
@Override
public int getChances() {
// TODO Auto-generated method stub
return 0;
}
@Override
public void resetPinChances() {
}
@Override
public void generateMiniStatement() {
// TODO Auto-generated method stub
}
}
