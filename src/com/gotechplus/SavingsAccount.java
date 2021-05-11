package com.gotechplus;

public class SavingsAccount {
    private final double annualInterestRate;
    private double balance;
    private double totalAmountOfDeposit = 0;
    private double totalAmountWithdrawn = 0;
    private double totalInterest = 0;

    //Constructor
    public SavingsAccount(double annualInterestRate, double startingBalance) {
        this.annualInterestRate = annualInterestRate;
        this.balance = startingBalance;
    }

    // getters
    public double getBalance() {
        return balance;
    }

    public double getTotalAmountOfDeposit() {
        return totalAmountOfDeposit;
    }

    public double getTotalAmountWithdrawn() {
        return totalAmountWithdrawn;
    }

    public double getTotalInterest() {
        return totalInterest;
    }
    //======================================

    // Methods
    public void withdraw(double amount){
        if(this.balance >= amount){
            this.totalAmountWithdrawn += amount;
            this.balance -= amount;
            System.out.println("You have withdrawn the amount of $" + amount + " your new balance is: " + this.balance);
        }else{
            System.out.println("Sorry, you can't withdraw $" + amount +
                    " you don't have enough balance in your account.\nyour current balance is: $" + this.balance);
        }
    }

    public void deposit(double amount){
        this.totalAmountOfDeposit += amount;
        this.balance += amount;
        System.out.println("deposit amount \"" + amount + "\" succeeded, your balance is: $" + this.balance);
    }

    public double addInterest(){
            double interest = this.balance * this.annualInterestRate / 12;
            this.totalInterest += interest;
            this.balance += interest;
            return interest;
    }
}
